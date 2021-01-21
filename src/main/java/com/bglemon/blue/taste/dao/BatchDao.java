package com.bglemon.blue.taste.dao;

import com.bglemon.blue.taste.domain.Batch;
import com.bglemon.blue.taste.vo.BatchVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* Interface
* BatchDao
*
* @author zhuchaunshun
* @created Create Time: 2021-01-18 18:22:59
*/
@Mapper()
public interface BatchDao {

    Batch getById(Integer id);

    List select(BatchVO batchVO);

    void delete(Integer id);

    int insert(BatchVO record);

    void updateByPrimaryKey(BatchVO batchVO);
    /* ============================ */

    /**
     * 插入数据库记录（不建议使用）
     * @param record
     */


    /**
     * 插入数据库记录（建议使用）
     * @param record
     */
    int insertSelective(Batch record);


    /**
     * 修改数据(推荐使用)
     * @param record
     */
    int updateByPrimaryKeySelective(Batch record);

}