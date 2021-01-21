package com.bglemon.blue.taste.service;

import com.bglemon.blue.taste.dao.GoodsDao;
import com.bglemon.blue.taste.vo.GoodsVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 商品的实现类
 * @author: immortal
 * @modified By：
 * @create: 2021-01-19 12:08
 **/
@Service
public class GoodsService {
    @Resource
    GoodsDao goodsDao;

    public List getSearch(GoodsVO goodsVO) {
        return goodsDao.select(goodsVO);
    }

    public void remove(Integer id) {
        goodsDao.deleteByPrimaryKey(id);
    }

    public void save(GoodsVO goodsVO) {
        goodsDao.insert(goodsVO);
    }

    public void edit(GoodsVO goodsVO) {
        goodsDao.updateByPrimaryKeySelective(goodsVO);
    }

    public Object getById(Integer id) {
        return goodsDao.selectByPrimaryKey(id);
    }
}