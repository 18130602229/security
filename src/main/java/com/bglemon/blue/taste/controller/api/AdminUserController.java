package com.bglemon.blue.taste.controller.api;


import com.bglemon.blue.taste.config.JWTUtil;
import com.bglemon.blue.taste.domain.AccountLog;
import com.bglemon.blue.taste.domain.AdminUser;
import com.bglemon.blue.taste.domain.Role;
import com.bglemon.blue.taste.domain.UserRole;
import com.bglemon.blue.taste.service.*;
import com.bglemon.blue.taste.utils.ApiResult;
import com.bglemon.blue.taste.utils.HttpServletRequestUtils;
import com.bglemon.blue.taste.utils.RedisUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Author:zhuchuanshun
 * @Description: 用户相关
 * @Date: 2019/4/18 18:55
 * @Modificd:
 */
@RestController
@RequestMapping("user")
@Api(value="UserController",description="UserController",tags={"用户相关 API 接口"})
public class AdminUserController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    AdminUserService userService;
    @Autowired
    private AccountLogService accountLogService;
    @Autowired
    UserRoleService userRoleService;
    @Autowired
    RoleService roleService;
    @Autowired
    PermissionService permissionService;
    @Autowired
    RedisUtil redisUtil;
    @PostMapping("login")
    @ApiOperation(value = "用户登录", notes = "用户登录 API")
    public ApiResult login(@RequestParam(value = "account") String account,
                           @RequestParam(value = "password") String password,
                           HttpServletRequest request){
        logger.info("========用户登录============");
        AdminUser user = userService.findByAccount(account);
        if (null == user){
            return new ApiResult(1001, "账号不存在");
        }
        if (!user.getEnabled()){
            return new ApiResult(1003, "账号已被禁用");
        }
        if (user.getPassword().equals(DigestUtils.md5Hex(password + user.getSalt()))) {
            redisUtil.remove("role_permission_"+account);  // 登录时清除 缓存的角色和权限
            AccountLog accLog = new AccountLog();
            accLog.setUserId(user.getId());
            accLog.setLogType(1);
            accLog.setIp(HttpServletRequestUtils.getIpAddr(request));
            accLog.setSucceed(true);
            accountLogService.insert(accLog);
            Map<String, Object> map = new HashMap();
            Role role = roleService.getRoleByUserId(user.getId());
            map.put("role",role);
            map.put("permissions",permissionService.getPermissions(role.getId(),1));
            map.put("token", JWTUtil.sign(account, user.getId()+""));
            return new ApiResult(200, "Login success").withData(map);
        } else {
            return new ApiResult(1002, "密码不正确");
        }
    }

    @GetMapping
    @RequiresRoles("admin")
    public ApiResult<PageInfo<AdminUser>> lists(@RequestParam(value="pageNumber",required = false,defaultValue = "0")int pageNumber,
                                                @RequestParam(value="pageSize",required = false,defaultValue = "10") int pageSize,
                                                @RequestParam(required = false) String account, @RequestParam(required = false) String role) {
        PageHelper.startPage(pageNumber,pageSize);
        PageInfo<AdminUser> pageInfo = new PageInfo<>(userService.getUsers(account, role));
        return new ApiResult().withData(pageInfo);
    }

    @PostMapping
    @RequiresRoles("admin")
    @ApiOperation(value = "新增用户", notes = "新增用户 API")
    public ApiResult save(AdminUser adminUser,@RequestParam(required = false) Integer roleId ){
        String salt = UUID.randomUUID().toString().replace("-","");
        adminUser.setSalt(salt);
        adminUser.setPassword(DigestUtils.md5Hex("12345678"+salt));
        userService.save(adminUser);
        //保存用户角色
        if (null != roleId){
            userRoleService.save(new UserRole(adminUser.getId(), roleId));
        }
        return new ApiResult();
    }

    @GetMapping("exit")
    @RequiresRoles("admin")
    @ApiOperation(value = "查询用户是否已经存在", notes = "查询用户是否已经存在 API")
    public ApiResult save(@RequestParam String account){
        AdminUser exit = userService.findByAccount(account);
        return new ApiResult().withData(exit);
    }

    @PutMapping
    @ApiOperation(value = "修改密码", notes = "修改密码 API")
    public ApiResult editPassword(@RequestParam String account, @RequestParam String oldPassword, @RequestParam String newPassword){
        AdminUser user = userService.findByAccount(account);
        if (user.getPassword().equals(DigestUtils.md5Hex(oldPassword + user.getSalt()))) {
            String md5Password = DigestUtils.md5Hex(newPassword + user.getSalt());
            userService.editPassword(account,md5Password);
            return new ApiResult(200, "密码修改成功");
        } else {
            return new ApiResult(1002, "密码不正确");
        }
    }
    @PutMapping("info")
    @ApiOperation(value = "修改账号和密码", notes = "修改账号和密码 API")
    @Transactional
    public ApiResult editAccountAndRole(@RequestParam Integer id, @RequestParam String account, @RequestParam Integer roleId){
        userService.editAccount(id, account);
        userRoleService.editRole(id, roleId);
        return new ApiResult();
    }
    @GetMapping("check-account")
    @ApiOperation(value = "检验新添的账号是否存在", notes = "检验新添的账号是否存在 API")
    @Transactional
    public ApiResult checkAccount( @RequestParam String account){
        return userService.findNumberByAccount(account);
    }

    /**
     * 只有 超级管理员才有权限 重置密码 默认密码：123456
     * @param id
     * @return
     */
    @PutMapping("reset")
    @RequiresRoles("admin")
    @ApiOperation(value = "重置密码", notes = "重置密码 API")
    public ApiResult resetPassword(@RequestParam Integer id){
        String salt = UUID.randomUUID().toString().replace("-","");
        String password = DigestUtils.md5Hex("12345678"+ salt);
        userService.resetPassword(id, salt, password);
        return new ApiResult();
    }

    @PutMapping("disable")
    @RequiresRoles("admin")
    @ApiOperation(value = "禁用用户", notes = "禁用用户 API")
    public ApiResult disabledUser(@RequestParam Integer id){
        userService.disabledUser(id);
        return new ApiResult();
    }

    @DeleteMapping
    @RequiresRoles("admin")
    @ApiOperation(value = "删除用户", notes = "删除用户 API")
    public ApiResult removeUser(@RequestParam Integer id){
        userService.removeUser(id);
        return new ApiResult();
    }

    @GetMapping("all")
    @RequiresRoles("admin")
    @ApiOperation(value = "获取所有的用户", notes = "获取所有的用户")
    public ApiResult getAllUser(){
        List<AdminUser> list = userService.getAllUser();
        return new ApiResult().withData(list);
    }
}
