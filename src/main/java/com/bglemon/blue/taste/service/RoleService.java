package com.bglemon.blue.taste.service;

import com.bglemon.blue.taste.dao.RoleDao;
import com.bglemon.blue.taste.domain.Role;
import com.bglemon.blue.taste.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:zhuchuanshun
 * @Description: TODO
 * @Date: 2019/4/19 11:17
 * @Modificd:
 */
@Service
public class RoleService {

    @Autowired
    RoleDao roleDao;

    public Role selectRoleByIdWithPermission(Integer id) {
        return roleDao.selectRoleByIdWithPermission(id);
    }

    public List<Role> getRole(String role) {
        return roleDao.getRole( role);
    }

    public void remove(Integer id) {
        roleDao.delete(id);
    }

    public Integer save(Role role) {
       return roleDao.insert(role);
    }

    public void edit(RoleVO roleVO) {
        roleDao.edit(roleVO);
    }
    public List<Role> getAll() {
        return roleDao.getAll();
    }

    public Role getRoleByUserId(int id) {
        return roleDao.getRoleByUserId(id);
    }

    public Boolean exist(Integer id, String role) {
        return roleDao.exist(id,role);
    }

}
