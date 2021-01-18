package com.bglemon.blue.taste.service;

import com.bglemon.blue.taste.dao.PermissionDao;
import com.bglemon.blue.taste.domain.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:zhuchuanshun
 * @Description: TODO
 * @Date: 2019/6/20 14:24
 * @Modificd:
 */
@Service
public class PermissionService {
    @Autowired
    PermissionDao permissionDao;

    public List<Permission> getPermissions(Integer id, Integer type) {
        return permissionDao.getPermissions(id, type);
    }

    public void remove(Integer id) {
        permissionDao.delete(id);
    }

    public List<Permission> getAllPermissions(Integer roleId) {
        return permissionDao.getAllPermissions(roleId);
    }

    public List<String> getPermissionsByRoleId(Integer id) {
        return permissionDao.getPermissionsByRoleId(id);
    }
}
