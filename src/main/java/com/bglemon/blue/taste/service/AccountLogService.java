package com.bglemon.blue.taste.service;

import com.bglemon.blue.taste.dao.AccountLogDao;
import com.bglemon.blue.taste.domain.AccountLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:zhuchuanshun
 * @Description: TODO
 * @Date: 2019/4/17 19:23
 * @Modificd:
 */
@Service
public class AccountLogService {
    @Autowired
     AccountLogDao accountLogDao;


    public void insert(AccountLog accLog) {
        accountLogDao.insert(accLog);
    }

    public List<AccountLog> findByUserId(int userId) {
        return accountLogDao.findByUserId(userId);
    }

    public List<AccountLog> findByUserIdAndDate(int userId, String date) {
        return accountLogDao.findByUserIdAndDate(userId, date);
    }

    public List<AccountLog> findByAccountAndDate(String account, String date) {
        return accountLogDao.findByAccountAndDate(account, date);
    }
}
