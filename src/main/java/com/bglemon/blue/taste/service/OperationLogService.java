package com.bglemon.blue.taste.service;

import com.bglemon.blue.taste.dao.OperationLogDao;
import com.bglemon.blue.taste.domain.OperationLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:zhuchuanshun
 * @Description: TODO
 * @Date: 2019/4/18 19:25
 * @Modificd:
 */
@Service
public class OperationLogService {
    @Autowired
    OperationLogDao operationLogDao;
    public void insert(OperationLog operationLog) {
        operationLogDao.insert(operationLog);
    }
}
