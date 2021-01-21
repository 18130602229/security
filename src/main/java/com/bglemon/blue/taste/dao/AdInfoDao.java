package com.bglemon.blue.taste.dao;

import com.bglemon.blue.taste.domain.AdInfo;
import com.bglemon.blue.taste.vo.AdInfoVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* Interface
* adInfoDao
*
* @author zhuchaunshun
* @created Create Time: 2021-01-18 18:22:59
*/
@Mapper()
public interface AdInfoDao {
    List getSearch(AdInfoVO adInfoVO);

    AdInfo getById(Integer id);

    void save(AdInfoVO adInfoVO);

    void edit(AdInfoVO adInfoVO);

    void remove(Integer id);

    /* ============================ */



}