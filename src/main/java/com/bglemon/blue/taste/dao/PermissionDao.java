package com.bglemon.blue.taste.dao;

import com.bglemon.blue.taste.domain.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PermissionDao {
    void insert(Permission permission);

    List<Permission> getPermissions(@Param("id") Integer id, @Param("type") Integer type);

    void delete(Integer id);

    List<Permission> getAllPermissions(@Param("id") Integer roleId);

    List<String> getPermissionsByRoleId(Integer id);
}
