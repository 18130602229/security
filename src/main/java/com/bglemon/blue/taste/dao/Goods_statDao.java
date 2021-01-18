package com.bglemon.blue.taste.dao;

import com.bglemon.blue.taste.domain.Goods_stat;
import org.apache.ibatis.annotations.Mapper;

/**
* Interface
* Goods_statDao
*
* @author zhuchaunshun
* @created Create Time: 2021-01-18 18:22:59
*/
@Mapper()
public interface Goods_statDao {
    /**
     * 根据主键删除数据
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入数据库记录（不建议使用）
     * @param record
     */
    int insert(Goods_stat record);

    /**
     * 插入数据库记录（建议使用）
     * @param record
     */
    int insertSelective(Goods_stat record);

    /**
     * 根据主键id查询
     * @param id
     */
    Goods_stat selectByPrimaryKey(Integer id);

    /**
     * 修改数据(推荐使用)
     * @param record
     */
    int updateByPrimaryKeySelective(Goods_stat record);

    /**
     * 修改数据
     * @param record
     */
    int updateByPrimaryKey(Goods_stat record);
}