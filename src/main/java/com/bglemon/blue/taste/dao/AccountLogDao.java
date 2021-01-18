package com.bglemon.blue.taste.dao;

import com.bglemon.blue.taste.domain.AccountLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AccountLogDao {
    void insert(AccountLog accountLog);

    List<AccountLog> findByUserId(int userId);

    List<AccountLog> findByUserIdAndDate(@Param("userId") int userId, @Param("date") String date);

    List<AccountLog> findByAccountAndDate(@Param("account") String account, @Param("date") String date);
}
