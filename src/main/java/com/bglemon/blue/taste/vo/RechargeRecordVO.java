package com.bglemon.blue.taste.vo;

import lombok.Data;

/**
 * @description: 充值记录
 * @author: immortal
 * @modified By：
 * @create: 2021-01-21 20:05
 **/
@Data
public class RechargeRecordVO {
    // 用户账号
    private String account;
    // 套餐名称
    private String name;
    // 时间
    private String createTime;
}