package com.bglemon.blue.taste.dao;

import com.bglemon.blue.taste.domain.Recharge;
import com.bglemon.blue.taste.vo.RechargeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* Interface
* RechargeDao
*
* @author zhuchaunshun
* @created Create Time: 2021-01-18 18:22:59
*/
@Mapper()
public interface RechargeDao {

    void remove(Integer id);

    void edit(RechargeVO rechargeVO);

    void save(RechargeVO rechargeVO);

    Recharge getById(Integer id);

    List getSearch(RechargeVO rechargeVO);

    /* ============================ */

}