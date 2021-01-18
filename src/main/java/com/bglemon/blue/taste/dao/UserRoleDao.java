package com.bglemon.blue.taste.dao;

import com.bglemon.blue.taste.domain.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserRoleDao {
    void insert(UserRole userRole);

    List<UserRole> find();

    void editRole(@Param("id") Integer id, @Param("roleId") Integer roleId);

    UserRole findByUserId(int id);
}
