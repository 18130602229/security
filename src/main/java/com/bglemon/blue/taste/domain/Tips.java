package com.bglemon.blue.taste.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
* Class
* Tips
*
* @author zhuchaunshun
* @created Create Time: 2021-01-18 18:22:59
*/
@ApiModel(value="com.bglemon.blue.taste.domain.Tips",description="")
@Data()
public class Tips {
    /**
     * 
	* 列名:id 类型:INTEGER(10) 允许空:false 缺省值:null
     */
    @ApiModelProperty(value="",name="id")
    private Integer id;

    /**
     * 客户ID
	* 列名:customer_id 类型:VARCHAR(255) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="客户ID",name="customerId")
    @Length(max = 255, message = "客户ID名长度最长为255")
    private String unionId;

    /**
     * 提示的文字
	* 列名:text 类型:VARCHAR(255) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="提示的文字",name="text")
    @Length(max = 255, message = "提示的文字名长度最长为255")
    private String text;

    /**
     * 商品ID
	* 列名:goods_id 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="商品ID",name="goodsId")
    private Integer goodsId;

    /**
     * 广告ID
	* 列名:ad_id 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="广告ID",name="adId")
    private Integer adId;

    /**
     * 类型 （1:60s 内一查过 2:未查到 商品 3:商品是第一次查询: 4 商品不是第一次查询）
	* 列名:type 类型:VARCHAR(255) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="类型 （1:60s 内一查过 2:未查到 商品 3:商品是第一次查询: 4 商品不是第一次查询）",name="type")
    @Length(max = 255, message = "类型 （1:60s 内一查过 2:未查到 商品 3:商品是第一次查询: 4 商品不是第一次查询）名长度最长为255")
    private String type;

    /**
     * 创建时间
	* 列名:create_time 类型:TIMESTAMP(19) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="创建时间",name="createTime")
    private Date createTime;
}