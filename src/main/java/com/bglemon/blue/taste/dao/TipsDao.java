package com.bglemon.blue.taste.dao;

import com.bglemon.blue.taste.domain.Tips;
import com.bglemon.blue.taste.vo.TipsVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* Interface
* TipsDao
*
* @author zhuchaunshun
* @created Create Time: 2021-01-18 18:22:59
*/
@Mapper()
public interface TipsDao {

    List getTips(TipsVO tipsVO);
    /* ============================ */
    /**
     * 根据主键删除数据
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入数据库记录（不建议使用）
     * @param record
     */
    int insert(Tips record);

    /**
     * 插入数据库记录（建议使用）
     * @param record
     */
    int insertSelective(Tips record);

    /**
     * 根据主键id查询
     * @param id
     */
    Tips selectByPrimaryKey(Integer id);

    /**
     * 修改数据(推荐使用)
     * @param record
     */
    int updateByPrimaryKeySelective(Tips record);

    /**
     * 修改数据
     * @param record
     */
    int updateByPrimaryKey(Tips record);
}