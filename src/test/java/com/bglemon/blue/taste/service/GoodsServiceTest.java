package com.bglemon.blue.taste.service;

import com.bglemon.blue.taste.vo.GoodsVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @description: 商品单元测试
 * @author: immortal
 * @modified By：
 * @create: 2021-01-19 12:31
 **/
@SpringBootTest
public class GoodsServiceTest {
    @Resource
    GoodsService goodsService;

    @Test
    void getOne(){
        goodsService.getById(1);
    }
    @Test
    void get(){
        goodsService.getSearch(new GoodsVO());
    }
    @Test
    void save(){
        GoodsVO goodsVO = new GoodsVO();
        goodsVO.setAd("gggg");
        goodsVO.setAntiCounterfeiting("防伪说明");
        goodsVO.setKind("食品");
        goodsVO.setName("辣条");
        goodsVO.setPrice(400);
        goodsVO.setSource("德州");
        goodsVO.setSunKind("小吃");
        goodsVO.setTrademark("商标");
        goodsVO.setValidity("2020-12-12");
        goodsService.save(goodsVO);
    }
    @Test
    void edit(){
        GoodsVO goodsVO = new GoodsVO();
        goodsVO.setId(1);
        goodsVO.setAd("all love");
        goodsService.edit(goodsVO);
    }
    @Test
    void remove(){
        Integer id = 1;
        goodsService.remove(id);
    }
}