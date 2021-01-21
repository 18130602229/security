package com.bglemon.blue.taste.service;

import com.bglemon.blue.taste.dao.BatchDao;
import com.bglemon.blue.taste.domain.Batch;
import com.bglemon.blue.taste.vo.BatchVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 商品批次表
 * @author: immortal
 * @modified By：
 * @create: 2021-01-19 17:55
 **/
@Service
public class BatchService {
    @Resource
    BatchDao batchDao;

    public Batch getById(Integer id) {
        return batchDao.getById(id);
    }

    public List getSearch(BatchVO batchVO) {
        return batchDao.select(batchVO);
    }

    public void save(BatchVO batchVO) {
        batchDao.insert(batchVO);
    }

    public void edit(BatchVO batchVO) {
        batchDao.updateByPrimaryKey(batchVO);
    }

    public void remove(Integer id) {
        batchDao.delete(id);
    }
}