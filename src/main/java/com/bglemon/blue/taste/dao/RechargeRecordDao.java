package com.bglemon.blue.taste.dao;

import com.bglemon.blue.taste.domain.RechargeRecord;
import com.bglemon.blue.taste.vo.RechargeRecordVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* Interface
* RechargeRecordDao
*
* @author zhuchaunshun
* @created Create Time: 2021-01-18 18:22:59
*/
@Mapper()
public interface RechargeRecordDao {

    List getSearch(RechargeRecordVO rechargeRecordVO);

    void save(@Param("userId") int userId,@Param("rechargeId") int rechargeId);
    /* ============================ */
    /**
     * 根据主键删除数据
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 修改数据(推荐使用)
     * @param record
     */
    int updateByPrimaryKeySelective(RechargeRecord record);

    /**
     * 修改数据
     * @param record
     */
    int updateByPrimaryKey(RechargeRecord record);

}