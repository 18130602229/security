package com.bglemon.blue.taste.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.util.Date;

/**
* Class
* QueryRecord
*
* @author zhuchaunshun
* @created Create Time: 2021-01-18 18:22:59
*/
@ApiModel(value="com.bglemon.blue.taste.domain.QueryRecord",description="")
@Data()
public class QueryRecord {
    /**
     * 
	* 列名:id 类型:INTEGER(10) 允许空:false 缺省值:null
     */
    @ApiModelProperty(value="",name="id")
    private Integer id;

    /**
     * 二维码信息
	* 列名:qr_code 类型:VARCHAR(255) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="二维码信息",name="qrCode")
    @Length(max = 255, message = "二维码信息名长度最长为255")
    private String qrCode;

    /**
     * 客户ID
	* 列名:customer_id 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="客户ID",name="customerId")
    private String unionId;

    /**
     * ip 地址
	* 列名:ip 类型:VARCHAR(255) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="ip 地址",name="ip")
    @Length(max = 255, message = "ip 地址名长度最长为255")
    private String ip;

    /**
     * 经度
	* 列名:longitude 类型:DECIMAL(10) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="经度",name="longitude")
    private BigDecimal longitude;

    /**
     * 纬度
	* 列名:latitude 类型:DECIMAL(10) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="纬度",name="latitude")
    private BigDecimal latitude;

    /**
     * 地址位置
	* 列名:position 类型:VARCHAR(255) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="地址位置",name="position")
    @Length(max = 255, message = "地址位置名长度最长为255")
    private String position;

    /**
     * 创建时间
	* 列名:create_time 类型:TIMESTAMP(19) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="创建时间",name="createTime")
    private Date createTime;
}