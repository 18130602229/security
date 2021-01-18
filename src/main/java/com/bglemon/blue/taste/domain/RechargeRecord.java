package com.bglemon.blue.taste.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
* Class
* RechargeRecord
*
* @author zhuchaunshun
* @created Create Time: 2021-01-18 18:22:59
*/
@ApiModel(value="com.bglemon.blue.taste.domain.RechargeRecord",description="")
@Data()
public class RechargeRecord {
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
    @ApiModelProperty(value="创建时间",name="createTime")
    private Date createTime;

    /**
     * 状态
	* 列名:deleted 类型:TINYINT(3) 允许空:true 缺省值:0
     */
    @ApiModelProperty(value="状态",name="deleted")
    private Integer deleted;
}