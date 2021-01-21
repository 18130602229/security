package com.bglemon.blue.taste.service;

import com.bglemon.blue.taste.dao.RechargeDao;
import com.bglemon.blue.taste.domain.Recharge;
import com.bglemon.blue.taste.vo.RechargeVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: immortal
 * @modified By：
 * @create: 2021-01-21 14:13
 **/
@Service
public class RechargeService {
    @Resource
    RechargeDao rechargeDao;

    public void remove(Integer id) {
        rechargeDao.remove(id);
    }

    public void edit(RechargeVO rechargeVO) {
        rechargeDao.edit(rechargeVO);
    }

    public void save(RechargeVO rechargeVO) {
        rechargeDao.save(rechargeVO);
    }

    public Recharge getById(Integer id) {
        return rechargeDao.getById(id);
    }

    public List getSearch(RechargeVO rechargeVO) {
        return rechargeDao.getSearch(rechargeVO);
    }
}