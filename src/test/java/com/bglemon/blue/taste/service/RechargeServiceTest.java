package com.bglemon.blue.taste.service;

import com.bglemon.blue.taste.vo.RechargeVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @description: 充值单元测试
 * @author: immortal
 * @modified By：
 * @create: 2021-01-19 12:31
 **/
@SpringBootTest
public class RechargeServiceTest {
    @Resource
    RechargeService rechargeService;

    @Test
    void getOne(){
        rechargeService.getById(1);
    }
    @Test
    void get(){
        rechargeService.getSearch(new RechargeVO());
    }
    @Test
    void save(){
        RechargeVO rechargeVO = new RechargeVO();
        rechargeVO.setName("30元，畅销");
        rechargeVO.setPrice(6000);
        rechargeVO.setDuration(3000);
        rechargeService.save(rechargeVO);
    }
    @Test
    void edit(){
        RechargeVO rechargeVO = new RechargeVO();
        rechargeVO.setId(1);
        rechargeVO.setName("90元，买一送一");
        rechargeService.edit(rechargeVO);
    }
    @Test
    void remove(){
        Integer id = 1;
        rechargeService.remove(id);
    }
}