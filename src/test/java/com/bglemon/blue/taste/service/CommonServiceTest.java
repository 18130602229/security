package com.bglemon.blue.taste.service;

import com.bglemon.blue.taste.vo.QueryCordVO;
import com.bglemon.blue.taste.vo.TipsVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @description: 接口较少的测试
 * @author: immortal
 * @modified By：
 * @create: 2021-01-21 12:44
 **/
@SpringBootTest
public class CommonServiceTest {
    @Resource
    CommonService commonService;


    @Test
    void getQueryCord(){
        commonService.getQueryCord(new QueryCordVO());
    }

    @Test
    void getTips(){
        commonService.getTips(new TipsVO());
    }
}