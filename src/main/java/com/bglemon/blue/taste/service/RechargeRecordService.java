package com.bglemon.blue.taste.service;

import com.bglemon.blue.taste.dao.RechargeRecordDao;
import com.bglemon.blue.taste.vo.RechargeRecordVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: immortal
 * @modified By：
 * @create: 2021-01-21 20:03
 **/
@Service
public class RechargeRecordService {
    @Resource
    RechargeRecordDao rechargeRecordDao;

    public List getSearch(RechargeRecordVO rechargeRecordVO) {
        return rechargeRecordDao.getSearch(rechargeRecordVO);
    }

    public void save(int userId,int rechargeId) {
        rechargeRecordDao.save(userId,rechargeId);
    }
}