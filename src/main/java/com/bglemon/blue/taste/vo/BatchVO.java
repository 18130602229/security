package com.bglemon.blue.taste.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @description: 批次单元测试
 * @author: immortal
 * @modified By：
 * @create: 2021-01-19 17:42
 **/
@Data
public class BatchVO {
    /**
     *
     * 列名:id 类型:INTEGER(10) 允许空:false 缺省值:null
     */
    @ApiModelProperty(value="",name="id")
    private Integer id;

    /**
     * 商品ID
     * 列名:goods_id 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="商品ID",name="goodsId")
    private Integer goodsId;

    /**
     * 第几批
     * 列名:number 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="第几批",name="number")
    private Integer number;

    /**
     * 原料信息
     * 列名:material_info 类型:VARCHAR(255) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="原料信息",name="materialInfo")
    @Length(max = 255, message = "原料信息名长度最长为255")
    private String materialInfo;

    /**
     * 生产日期
     * 列名:production_date 类型:TIMESTAMP(19) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="生产日期",name="productionDate")
    private String productionDate;

    /**
     * 销售地区
     * 列名:sales_area 类型:VARCHAR(255) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="销售地区",name="salesArea")
    @Length(max = 255, message = "销售地区名长度最长为255")
    private String salesArea;

    /**
     * 经销商
     * 列名:dealers 类型:VARCHAR(255) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="经销商",name="dealers")
    @Length(max = 255, message = "经销商名长度最长为255")
    private String dealers;

    /**
     * 创建时间
     * 列名:create_time 类型:TIMESTAMP(19) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="创建时间",name="createTime")
    private String createTime;

    /**
     * 更新时间
     * 列名:update_time 类型:TIMESTAMP(19) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="更新时间",name="updateTime")
    private String updateTime;
}