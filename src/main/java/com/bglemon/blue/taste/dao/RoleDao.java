package com.bglemon.blue.taste.dao;

import com.bglemon.blue.taste.domain.Role;
import com.bglemon.blue.taste.vo.RoleVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleDao {
    Role selectRoleByIdWithPermission(Integer id);

    Integer insert(Role role);

    List<Role> find();

    List<Role> getRole(@Param("role") String role);

    void delete(Integer id);

    List<Role> getAll();
    
    void edit(RoleVO roleVO);

    Role selectRoleById(int id);

    Role getRoleByUserId(int id);

    Boolean exist(@Param("id") Integer id, @Param("role") String role);
}
