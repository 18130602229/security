package com.bglemon.blue.taste.service;

import com.bglemon.blue.taste.dao.RolePermissionDao;
import com.bglemon.blue.taste.domain.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:zhuchuanshun
 * @Description: TODO
 * @Date: 2019/6/20 17:26
 * @Modificd:
 */
@Service
public class RolePermissionService{
    @Autowired
    RolePermissionDao rolePermissionDao;

    public void batchSave(List<RolePermission> list) {
        rolePermissionDao.batchSave(list);
    }

    public void batchEdit(List<RolePermission> list) {
        rolePermissionDao.batchEdit(list);
    }

    public void remove(Integer roleId) {
        rolePermissionDao.remove(roleId);
    }

    public void edit(int roleId, int permissionId) {
        rolePermissionDao.edit(roleId, permissionId);
    }

}
