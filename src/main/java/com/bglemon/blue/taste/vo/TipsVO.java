package com.bglemon.blue.taste.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 提示记录
 * @author: immortal
 * @modified By：
 * @create: 2021-01-21 18:12
 **/
@Data
public class TipsVO {

    private String unionId;
    // 商品名称
    private String goodsName;
    // 商品类型
    private String goodsKind;
    // 广告名称
    private String adName;
    // 提示类型
    private String type;
    // 广告类型
    private String adType;
    /**
     * 创建时间
     * 列名:create_time 类型:TIMESTAMP(19) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="创建时间",name="createTime")
    private String createTime;
}