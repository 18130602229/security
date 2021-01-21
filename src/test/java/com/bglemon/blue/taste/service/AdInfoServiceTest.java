package com.bglemon.blue.taste.service;

import com.bglemon.blue.taste.vo.AdInfoVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @description: 广告单元测试
 * @author: immortal
 * @modified By：
 * @create: 2021-01-19 12:31
 **/
@SpringBootTest
public class AdInfoServiceTest {
    @Resource
    AdInfoService adInfoService;

    @Test
    void getOne(){
        adInfoService.getById(1);
    }
    @Test
    void get(){
        adInfoService.getSearch(new AdInfoVO());
    }
    @Test
    void save(){
        AdInfoVO adInfoVO = new AdInfoVO();
        adInfoVO.setContent("大自然的搬运工");
        adInfoVO.setTitle("矿泉水");
        adInfoVO.setType("饮料");
        adInfoService.save(adInfoVO);
    }
    @Test
    void edit(){
        AdInfoVO adInfoVO = new AdInfoVO();
        adInfoVO.setId(1);
        adInfoVO.setTitle("哇哈哈");
        adInfoService.edit(adInfoVO);
    }
    @Test
    void remove(){
        Integer id = 1;
        adInfoService.remove(id);
    }
}