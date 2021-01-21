package com.bglemon.blue.taste.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @description: 请求记录
 * @author: immortal
 * @modified By：
 * @create: 2021-01-21 12:17
 **/
@Data
public class QueryCordVO {
    /**
     * 二维码信息
     * 列名:qr_code 类型:VARCHAR(255) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="二维码信息",name="qrCode")
    @Length(max = 255, message = "二维码信息名长度最长为255")
    private String qrCode;

    /**
     * ip 地址
     * 列名:ip 类型:VARCHAR(255) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="ip 地址",name="ip")
    @Length(max = 255, message = "ip 地址名长度最长为255")
    private String ip;

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
    private String createTime;

    /**
     * 用户唯一标示
     */
    @ApiModelProperty(value="用户唯一标示",name="unionId")
    private String unionId;
}