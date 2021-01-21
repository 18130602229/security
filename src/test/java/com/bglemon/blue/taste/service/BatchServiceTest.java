package com.bglemon.blue.taste.service;

import com.bglemon.blue.taste.vo.BatchVO;
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
public class BatchServiceTest {
    @Resource
    BatchService batchService;

    @Test
    void getOne(){
        batchService.getById(1);
    }
    @Test
    void get(){
        batchService.getSearch(new BatchVO());
    }
    @Test
    void save(){
        BatchVO batchVO = new BatchVO();
        batchVO.setDealers("华南");
        batchVO.setGoodsId(1);
        batchVO.setMaterialInfo("纯天然");
        batchVO.setNumber(1);
        batchVO.setProductionDate("2020-11-21");
        batchVO.setSalesArea("广东");
        batchService.save(batchVO);
    }
    @Test
    void edit(){
        BatchVO batchVO = new BatchVO();
        batchVO.setId(1);
        batchVO.setSalesArea("北美");
        batchService.edit(batchVO);
    }
    @Test
    void remove(){
        Integer id = 1;
        batchService.remove(id);
    }
}