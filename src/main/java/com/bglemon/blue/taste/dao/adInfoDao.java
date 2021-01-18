package com.bglemon.blue.taste.dao;

import com.bglemon.blue.taste.domain.adInfo;
import org.apache.ibatis.annotations.Mapper;

/**
* Interface
* adInfoDao
*
* @author zhuchaunshun
* @created Create Time: 2021-01-18 18:22:59
*/
@Mapper()
public interface adInfoDao {

    /**
     * 根据主键删除数据
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入数据库记录（不建议使用）
     * @param record
     */
    int insert(adInfo record);

    /**
     * 插入数据库记录（建议使用）
     * @param record
     */
    int insertSelective(adInfo record);

    /**
     * 根据主键id查询
     * @param id
     */
    adInfo selectByPrimaryKey(Integer id);

    /**
     * 修改数据(推荐使用)
     * @param record
     */
    int updateByPrimaryKeySelective(adInfo record);

    /**
     * 修改数据
     * @param record
     */
    int updateByPrimaryKey(adInfo record);
}