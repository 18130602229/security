package com.bglemon.blue.taste.dao;

import com.bglemon.blue.taste.domain.Goods;
import com.bglemon.blue.taste.vo.GoodsVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* Interface
* GoodsDao
*
* @author zhuchaunshun
* @created Create Time: 2021-01-18 18:22:59
*/
@Mapper()
public interface GoodsDao {


    List select(GoodsVO goodsVO);

    /**
     * 根据主键删除数据
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsVO record);

    /**
     * 修改数据(推荐使用)
     * @param record
     */
    int updateByPrimaryKeySelective(GoodsVO record);

    Goods selectByPrimaryKey(Integer id);
    /* ============================ */


}