package com.bglemon.blue.taste.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @description: 广告接受类
 * @author: immortal
 * @modified By：
 * @create: 2021-01-21 13:35
 **/
@Data
public class AdInfoVO {
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
     * 列名:title 类型:VARCHAR(255) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="广告标题",name="title")
    @Length(max = 255, message = "广告标题名长度最长为255")
    private String title;

    private String img;
    /**
     *
     * 列名:create_time 类型:TIMESTAMP(19) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="",name="createTime")
    private String createTime;
}