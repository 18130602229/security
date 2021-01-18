package com.bglemon.blue.taste.service;

import com.bglemon.blue.taste.dao.UserRoleDao;
import com.bglemon.blue.taste.domain.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:zhuchuanshun
 * @Description: TODO
 * @Date: 2019/6/20 15:54
 * @Modificd:
 */
@Service
public class UserRoleService{
    @Autowired
    UserRoleDao userRoleDao;

    public void save(UserRole userRole) {
        userRoleDao.insert(userRole);
    }

    public void editRole(Integer id, Integer roleId) {
        userRoleDao.editRole(id, roleId);
    }

    public UserRole findByUserId(int id) {
        return userRoleDao.findByUserId(id);
    }
}
