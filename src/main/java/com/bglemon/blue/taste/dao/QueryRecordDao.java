package com.bglemon.blue.taste.dao;

import com.bglemon.blue.taste.domain.QueryRecord;
import com.bglemon.blue.taste.vo.QueryCordVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* Interface
* QueryRecordDao
*
* @author zhuchaunshun
* @created Create Time: 2021-01-18 18:22:59
*/
@Mapper()
public interface QueryRecordDao {

    List selectQueryCord(QueryCordVO queryCordVO);

    /* ============================ */
    /**
     * 插入数据库记录（不建议使用）
     * @param record
     */
    int insert(QueryRecord record);

    /**
     * 插入数据库记录（建议使用）
     * @param record
     */
    int insertSelective(QueryRecord record);

    /**
     * 根据主键id查询
     * @param id
     */
    QueryRecord selectByPrimaryKey(Integer id);

    /**
     * 修改数据(推荐使用)
     * @param record
     */
    int updateByPrimaryKeySelective(QueryRecord record);

    /**
     * 修改数据
     * @param record
     */
    int updateByPrimaryKey(QueryRecord record);

}