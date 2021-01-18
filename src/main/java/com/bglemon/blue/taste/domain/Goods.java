package com.bglemon.blue.taste.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
* Class
* Goods
*
* @author zhuchaunshun
* @created Create Time: 2021-01-18 18:22:59
*/
@ApiModel(value="com.bglemon.blue.taste.domain.Goods",description="")
@Data()
public class Goods {
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
     * 商品名称
	* 列名:name 类型:VARCHAR(255) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="商品名称",name="name")
    @Length(max = 255, message = "商品名称名长度最长为255")
    private String name;

    /**
     * 商品种类
	* 列名:kind 类型:VARCHAR(255) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="商品种类",name="kind")
    @Length(max = 255, message = "商品种类名长度最长为255")
    private String kind;

    /**
     * 商品子类型
	* 列名:sun_kind 类型:VARCHAR(255) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="商品子类型",name="sunKind")
    @Length(max = 255, message = "商品子类型名长度最长为255")
    private String sunKind;

    /**
     * 生产厂家
	* 列名:source 类型:VARCHAR(255) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="生产厂家",name="source")
    @Length(max = 255, message = "生产厂家名长度最长为255")
    private String source;

    /**
     * 价格（单位 分）
	* 列名:price 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="价格（单位 分）",name="price")
    private Integer price;

    /**
     * 有效期
	* 列名:validity 类型:TIMESTAMP(19) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="有效期",name="validity")
    private Date validity;

    /**
     * 商品自家的 广告语
	* 列名:ad 类型:VARCHAR(255) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="商品自家的 广告语",name="ad")
    @Length(max = 255, message = "商品自家的 广告语名长度最长为255")
    private String ad;

    /**
     * 商标（图片）
	* 列名:trademark 类型:VARCHAR(255) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="商标（图片）",name="trademark")
    @Length(max = 255, message = "商标（图片）名长度最长为255")
    private String trademark;

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
     * 状态（0:未删 1 已删）
	* 列名:deleted 类型:TINYINT(3) 允许空:true 缺省值:0
     */
    @ApiModelProperty(value="状态（0:未删 1 已删）",name="deleted")
    private Integer deleted;

    /**
     * 防伪说明
	* 列名:anti _counterfeiting 类型:VARCHAR(255) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="防伪说明",name="antiCounterfeiting")
    @Length(max = 255, message = "防伪说明名长度最长为255")
    private String antiCounterfeiting;
}