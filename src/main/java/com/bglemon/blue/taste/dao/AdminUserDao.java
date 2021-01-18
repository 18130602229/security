package com.bglemon.blue.taste.dao;

import com.bglemon.blue.taste.domain.AdminUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminUserDao {

    AdminUser findByAccount(@Param("account") String account);

    AdminUser selectUserByUserNameWithRole(String account);

    List<AdminUser> getUsers(@Param("account") String account, @Param("role") String role);

    Integer save(AdminUser adminUser);

    void editPassword(@Param("account") String account, @Param("password") String password);

    void resetPassword(@Param("id") Integer id, @Param("salt") String salt, @Param("password") String password);

    void disabledUser(@Param("id") Integer id);

    void removeUser(Integer id);

    void editAccount(@Param("id") Integer id, @Param("account") String account);

    List<AdminUser> getAllUser();

    int findNumberByAccount(@Param("account") String account);
}
