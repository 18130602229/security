package com.bglemon.blue.taste.dao;

import com.bglemon.blue.taste.domain.OperationLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OperationLogDao {
    void insert(OperationLog operationLog);

    List<OperationLog> find();
}
