package com.bglemon.blue.taste.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
* Class
* Batch
*
* @author zhuchaunshun
* @created Create Time: 2021-01-18 18:22:59
*/
@ApiModel(value="com.bglemon.blue.taste.domain.Batch",description="")
@Data()
public class Batch {
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
    private Date productionDate;

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
    private Date createTime;

    /**
     * 更新时间
	* 列名:update_time 类型:TIMESTAMP(19) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="更新时间",name="updateTime")
    private Date updateTime;

    /**
     * 状态
	* 列名:deleted 类型:TINYINT(3) 允许空:true 缺省值:0
     */
    @ApiModelProperty(value="状态",name="deleted")
    private Integer deleted;
}