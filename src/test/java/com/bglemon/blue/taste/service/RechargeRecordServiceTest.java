package com.bglemon.blue.taste.service;

import com.bglemon.blue.taste.vo.RechargeRecordVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @description: 充值记录单元测试
 * @author: immortal
 * @modified By：
 * @create: 2021-01-21 20:33
 **/
@SpringBootTest
public class RechargeRecordServiceTest {
    @Resource
    RechargeRecordService rechargeRecordService;

    @Test
    void add(){
        int userId = 1;
        int rechargeId = 2;
        rechargeRecordService.save(userId,rechargeId);
    }

    @Test
    void get(){
        rechargeRecordService.getSearch(new RechargeRecordVO());
    }
}