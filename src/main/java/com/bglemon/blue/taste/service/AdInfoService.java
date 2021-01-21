package com.bglemon.blue.taste.service;

import com.bglemon.blue.taste.dao.AdInfoDao;
import com.bglemon.blue.taste.domain.AdInfo;
import com.bglemon.blue.taste.vo.AdInfoVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: immortal
 * @modified By：
 * @create: 2021-01-21 13:32
 **/
@Service
public class AdInfoService {
    @Resource
    AdInfoDao adInfoDao;

    public List getSearch(AdInfoVO adInfoVO) {
        return adInfoDao.getSearch(adInfoVO);
    }

    public AdInfo getById(Integer id) {
        return adInfoDao.getById(id);
    }

    public void save(AdInfoVO adInfoVO) {
        adInfoDao.save(adInfoVO);
    }

    public void edit(AdInfoVO adInfoVO) {
        adInfoDao.edit(adInfoVO);
    }

    public void remove(Integer id) {
        adInfoDao.remove(id);
    }
}