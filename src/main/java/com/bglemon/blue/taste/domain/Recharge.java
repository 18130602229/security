package com.bglemon.blue.taste.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
* Class
* Recharge
*
* @author zhuchaunshun
* @created Create Time: 2021-01-18 18:22:59
*/
@ApiModel(value="com.bglemon.blue.taste.domain.Recharge",description="")
@Data()
public class Recharge {
    /**
     * 
	* 列名:id 类型:INTEGER(10) 允许空:false 缺省值:null
     */
    @ApiModelProperty(value="",name="id")
    private Integer id;

    /**
     * 充值描述
	* 列名:name 类型:VARCHAR(11) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="充值描述",name="name")
    @Length(max = 11, message = "充值描述名长度最长为11")
    private String name;

    /**
     * 价格（单位 分）
	* 列名:price 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="价格（单位 分）",name="price")
    private Integer price;

    /**
     * 时长（分钟）
	* 列名:duration 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="时长（分钟）",name="duration")
    private Integer duration;

    /**
     * 
	* 列名:create_time 类型:TIMESTAMP(19) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="",name="createTime")
    private Date createTime;

    /**
     * 
	* 列名:update_time 类型:TIMESTAMP(19) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="",name="updateTime")
    private Date updateTime;

    /**
     * 
	* 列名:deleted 类型:TINYINT(3) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="",name="deleted")
    private Integer deleted;
}