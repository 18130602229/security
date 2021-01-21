package com.bglemon.blue.taste.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @description: 充值记录 返回数据
 * @author: immortal
 * @modified By：
 * @create: 2021-01-21 20:23
 **/
@Data
public class RechargeRecordDTO {
    /**
     *
     * 列名:id 类型:INTEGER(10) 允许空:false 缺省值:null
     */
    @ApiModelProperty(value="",name="id")
    private Integer id;

    /**
     * 用户ID
     * 列名:user_id 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="用户ID",name="userId")
    private Integer userId;

    /**
     * 充值ID
     * 列名:recharge_id 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="充值ID",name="rechargeId")
    private Integer rechargeId;

    /**
     * 创建时间
     * 列名:create_time 类型:TIMESTAMP(19) 允许空:true 缺省值:null
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    // 账号
    private String account;
    // 套餐名称
    private String name;
    // 价格
    private int price;
    // 时长
    private int duration;
}