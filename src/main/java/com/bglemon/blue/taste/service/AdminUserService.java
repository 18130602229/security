package com.bglemon.blue.taste.service;

import com.bglemon.blue.taste.dao.AdminUserDao;
import com.bglemon.blue.taste.domain.AdminUser;
import com.bglemon.blue.taste.utils.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:zhuchuanshun
 * @Description: TODO
 * @Date: 2019/4/18 19:11
 * @Modificd:
 */
@Service
public class AdminUserService {
    @Autowired
    AdminUserDao userDao;

    /**
     * 新增用户时检测账户是否存在
     * @param account
     * @return
     */
    
    public AdminUser findByAccount(String account) {
        return userDao.findByAccount(account);
    }

    
    public AdminUser selectUserByUserNameWithRole(String username) {
        return userDao.selectUserByUserNameWithRole(username);
    }

    
    public List<AdminUser> getUsers(String account, String role) {
        return userDao.getUsers(account, role);
    }

    
    public Integer save(AdminUser adminUser) {
        return userDao.save(adminUser);
    }

    
    public void editPassword(String account, String md5Password) {
        userDao.editPassword(account, md5Password);
    }

    
    public void resetPassword(Integer id, String salt, String password) {
        userDao.resetPassword( id, salt, password);
    }

    
    public void disabledUser(Integer id) {
        userDao.disabledUser(id);
    }

    
    public void removeUser(Integer id) {
        userDao.removeUser(id);
    }

    
    public void editAccount(Integer id, String account) {
        userDao.editAccount(id, account);
    }

    
    public List<AdminUser> getAllUser() {
        return userDao.getAllUser();
    }

    
    public ApiResult findNumberByAccount(String account) {
        Integer size = userDao.findNumberByAccount(account);
        Map<String, Integer> map = new HashMap<>();
        map.put("size",size);
        return new ApiResult().withData(map);
    }
}
