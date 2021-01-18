package com.bglemon.blue.taste.dao;

import com.bglemon.blue.taste.domain.RolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RolePermissionDao {
    void insert(RolePermission rolePermission);


    void batchSave(List<RolePermission> list);

    void batchEdit(List<RolePermission> list);

    void remove(Integer roleId);

    void edit(@Param("roleId") int roleId, @Param("permissionId") int permissionId);
}
