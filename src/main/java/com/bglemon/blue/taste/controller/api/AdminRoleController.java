package com.bglemon.blue.taste.controller.api;


import com.bglemon.blue.taste.config.JWTUtil;
import com.bglemon.blue.taste.domain.Permission;
import com.bglemon.blue.taste.domain.Role;
import com.bglemon.blue.taste.domain.RolePermission;
import com.bglemon.blue.taste.domain.UserRole;
import com.bglemon.blue.taste.service.PermissionService;
import com.bglemon.blue.taste.service.RolePermissionService;
import com.bglemon.blue.taste.service.RoleService;
import com.bglemon.blue.taste.service.UserRoleService;
import com.bglemon.blue.taste.utils.ApiResult;
import com.bglemon.blue.taste.vo.RoleVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zhuchuanshun
 * @Description: 角色相关
 * @Date: 2019/4/18 18:55
 * @Modificd:
 */
@RestController
@Api(value="AdminRoleController",description="AdminRoleController",tags={"角色相关 API 接口"})
public class AdminRoleController {
    @Autowired
    RoleService roleService;

    @Autowired
    PermissionService permissionService;

    @Autowired
    RolePermissionService rolePermissionService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    UserRoleService userRoleService;

    @GetMapping("role")
    @RequiresRoles("admin")
    @ApiOperation(value = "分页查询角色", notes = "分页查询角色 API")
    public ApiResult<PageInfo<Role>> lists(@RequestParam(value="pageNumber",required = false,defaultValue = "0") int pageNumber,
                                           @RequestParam(value="pageSize",required = false,defaultValue = "10") int pageSize,
                                           @RequestParam(required = false) String role
                                                ) {
        PageHelper.startPage(pageNumber,pageSize);
        PageInfo<Role> pageInfo = new PageInfo(roleService.getRole(role));
        return new ApiResult().withData(pageInfo);
    }
    @GetMapping("role-all")
    @RequiresRoles("admin")
    @ApiOperation(value = "查询角色", notes = "查询角色 API")
    public ApiResult<List<Role>> getRoleAll() {
        List<Role> list = roleService.getAll();
        return new ApiResult().withData(list);
    }

    @PostMapping("role")
    @RequiresRoles("admin")
    @ApiOperation(value = "新增角色", notes = "新增角色 API")
    public ApiResult save(RoleVO roleVO){
        // 保存role 表
        Role role = new Role(roleVO.getRole(), roleVO.getDescription());
        roleService.save(role);
        // 保存role_permission 中间表
        if (roleVO.getAddPermissions() != null){
            Integer[] permissions = roleVO.getAddPermissions();
            List<RolePermission> list = new ArrayList<>();
            if (permissions.length > 0){
                for (int item : permissions){
                    list.add(new RolePermission(role.getId(), item));
                }
                rolePermissionService.batchSave(list);
            }
        }
        return new ApiResult();

    }
    @PutMapping("role")
    @RequiresRoles("admin")
    @ApiOperation(value = "编辑角色", notes = "编辑角色 API")
    @Transactional
    public ApiResult edit(RoleVO roleVO){
        int roleId = roleVO.getId();
        // 修改 role 表
        roleService.edit(roleVO);
        // 添加的权限 保存role_permission 中间表
        Integer[] permissions = roleVO.getAddPermissions();

        if (permissions != null){
            List<RolePermission> list = new ArrayList<>();
            for (int item : permissions){
                list.add(new RolePermission(roleId, item));
            }
            rolePermissionService.batchSave(list);
        }
        // 删除无用的权限
        Integer[] removePermissions = roleVO.getRemovePermissions();
        if (removePermissions != null){
            for (int permissionId : removePermissions){
                rolePermissionService.edit(roleId, permissionId);
            }
            // rolePermissionService.batchEdit(removeList);
        }
        return new ApiResult();
    }
    @GetMapping("role/exist")
    @ApiOperation(value = "检验角色是否存在", notes = "角色描述 长度有误  API")
    @RequiresRoles("admin")
    public ApiResult exist(@RequestParam(value = "id",required = false) Integer id, @RequestParam String role){
        // 删除 role_permission 中间表中的数据
        Boolean flag =  roleService.exist(id,role);
        return new ApiResult().withData(flag);
    }

    @DeleteMapping("role")
    @ApiOperation(value = "删除角色", notes = "删除角色 API")
    @Transactional
    @RequiresRoles("admin")
    public ApiResult remove(@RequestParam Integer id){
        // 删除 role 表中的数据
        roleService.remove(id);
        // 删除 role_permission 中间表中的数据
        rolePermissionService.remove(id);
        return new ApiResult();
    }

    /*============================== 权限接口 ========================================*/

    /**
     * 如 type = null 则，查询所有的目录及权限
     * @param type 0：菜单类型；1：功能类型'
     * @return
     */
    @GetMapping("permission")
//    @RequiresRoles("admin")
    @ApiOperation(value = "查询目录或权限", notes = "查询目录或权限 API")
    public ApiResult<List<Permission>> getPermissionByType(@RequestParam(value = "type",required = false) Integer type) {
        String token = request.getHeader("Authorization");
        int id = JWTUtil.getUserId(token); // 这个id 是，用户 adminUser 的id。
        UserRole ur = userRoleService.findByUserId(id);// 通过 userId获取roleId；
        List<Permission> list;
        if (type == null){
            list = permissionService.getAllPermissions(ur.getRoleId());
        }else {
            list = permissionService.getPermissions(ur.getRoleId(), type);
        }
        return new ApiResult().withData(list);
    }

    @GetMapping("permissionByRoleId")
    @ApiOperation(value = "查询目录或权限", notes = "查询目录或权限 API")
    public ApiResult<List<Permission>> getPermissionByRoleId(@RequestParam("roleId") Integer roleId) {
        List<Permission> list = permissionService.getAllPermissions(roleId);
        return new ApiResult().withData(list);
    }
}
