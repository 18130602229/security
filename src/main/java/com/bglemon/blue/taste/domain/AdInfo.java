package com.bglemon.blue.taste.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
* Class
* adInfo
*
* @author zhuchaunshun
* @created Create Time: 2021-01-18 18:22:59
*/
@ApiModel(value="com.bglemon.blue.taste.domain.adInfo",description="")
@Data()
public class AdInfo {
    /**
     * 
	* 列名:id 类型:INTEGER(10) 允许空:false 缺省值:null
     */
    @ApiModelProperty(value="",name="id")
    private Integer id;

    /**
     * 广告内容
	* 列名:content 类型:VARCHAR(255) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="广告内容",name="content")
    @Length(max = 255, message = "广告内容名长度最长为255")
    private String content;

    /**
     * 广告类型（餐饮/房地产等）
	* 列名:type 类型:VARCHAR(255) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="广告类型（餐饮/房地产等）",name="type")
    @Length(max = 255, message = "广告类型（餐饮/房地产等）名长度最长为255")
    private String type;

    /**
     * 广告标题
	* 列名:tittle 类型:VARCHAR(255) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="广告标题",name="tittle")
    @Length(max = 255, message = "广告标题名长度最长为255")
    private String title;

    /**
     * 图片
	* 列名:img 类型:VARCHAR(255) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="图片",name="img")
    @Length(max = 255, message = "图片名长度最长为255")
    private String img;

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
     * 状态
	* 列名:deleted 类型:TINYINT(3) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="状态",name="deleted")
    private Integer deleted;
}