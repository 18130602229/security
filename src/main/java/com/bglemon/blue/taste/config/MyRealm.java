package com.bglemon.blue.taste.config;

import com.bglemon.blue.taste.domain.AdminUser;
import com.bglemon.blue.taste.service.PermissionService;
import com.bglemon.blue.taste.service.RoleService;
import com.bglemon.blue.taste.service.AdminUserService;
import com.bglemon.blue.taste.utils.RedisUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:zhuchuanshun
 * @Description: 自己重写 过滤权限
 * @Date: 2019/4/22 16:48
 * @Modificd:
 */
@Service
public class MyRealm extends AuthorizingRealm {
    Logger logger = LoggerFactory.getLogger(MyRealm.class);
    @Autowired
    private AdminUserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    PermissionService permissionService;
    @Autowired
    RedisUtil redisUtil;

    @Autowired
    public void setUserService(AdminUserService userService) {
        this.userService = userService;
    }

    /**
     * 大坑！，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = JWTUtil.getUsername(principals.toString());
        // 将 存储验证信息的 SimpleAuthorizationInfo 对象直接放入缓存中。
        SimpleAuthorizationInfo simpleAuthorizationInfo = (SimpleAuthorizationInfo)redisUtil.getCollection("role_permission_"+username);
        if (simpleAuthorizationInfo == null) {
            SimpleAuthorizationInfo innerSimpleAuthorizationInfo = new SimpleAuthorizationInfo();
            AdminUser user = userService.selectUserByUserNameWithRole(username);
            user.getRoleList().forEach(role -> {
                // 添加角色
                String roleNode = role.getRole();
                innerSimpleAuthorizationInfo.addRole(roleNode);
                // 根据 roleId 获取所有的权限
                List<String> permissions  = permissionService.getPermissionsByRoleId(role.getId());
                if (permissions.size() > 0 ){
                    innerSimpleAuthorizationInfo.addStringPermissions(permissions);
                }
            });
            redisUtil.setObj("role_permission_"+username,innerSimpleAuthorizationInfo,60*60L);
            return innerSimpleAuthorizationInfo;
        }
            return simpleAuthorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtil.getUsername(token);
        String id = JWTUtil.getUserId(token).toString();
        if (username == null) {
            throw new AuthenticationException("token invalid");
        }
        if (! JWTUtil.verify(token, username, id)) {
            throw new AuthenticationException("Username or password error");
        }

        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }
}