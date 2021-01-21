package com.bglemon.blue.taste.service;

import com.bglemon.blue.taste.dao.QueryRecordDao;
import com.bglemon.blue.taste.dao.TipsDao;
import com.bglemon.blue.taste.vo.QueryCordVO;
import com.bglemon.blue.taste.vo.TipsVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: immortal
 * @modified By：
 * @create: 2021-01-21 12:16
 **/
@Service
public class CommonService {
    @Resource
    QueryRecordDao queryRecordDao;

    @Resource
    TipsDao tipsDao;

    public List getQueryCord(QueryCordVO queryCordVO) {
        return queryRecordDao.selectQueryCord(queryCordVO);
    }

    public List getTips(TipsVO tipsVO) {
        return tipsDao.getTips(tipsVO);
    }
}