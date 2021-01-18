package com.bglemon.blue.taste.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
* Class
* UserApplet
*
* @author zhuchaunshun
* @created Create Time: 2021-01-18 18:22:59
*/
@ApiModel(value="com.bglemon.blue.taste.domain.UserApplet",description="")
@Data()
public class UserApplet {
    /**
     * 
	* 列名:id 类型:INTEGER(10) 允许空:false 缺省值:null
     */
    @ApiModelProperty(value="",name="id")
    private Integer id;

    /**
     * 	用户的标识，对当前公众号唯一
	* 列名:open_id 类型:VARCHAR(32) 允许空:false 缺省值:null
     */
    @ApiModelProperty(value="	用户的标识，对当前公众号唯一",name="openId")
    @Length(max = 32, message = "	用户的标识，对当前公众号唯一名长度最长为32")
    private String openId;

    /**
     * 昵称
	* 列名:nickname 类型:VARCHAR(64) 允许空:false 缺省值:null
     */
    @ApiModelProperty(value="昵称",name="nickname")
    @Length(max = 64, message = "昵称名长度最长为64")
    private String nickname;

    /**
     * 性别1:男;2:女;0:未知
	* 列名:sex 类型:VARCHAR(2) 允许空:false 缺省值:null
     */
    @ApiModelProperty(value="性别1:男;2:女;0:未知",name="sex")
    @Length(max = 2, message = "性别1:男;2:女;0:未知名长度最长为2")
    private String sex;

    /**
     * 语言
	* 列名:language 类型:VARCHAR(16) 允许空:false 缺省值:null
     */
    @ApiModelProperty(value="语言",name="language")
    @Length(max = 16, message = "语言名长度最长为16")
    private String language;

    /**
     * 城市
	* 列名:city 类型:VARCHAR(16) 允许空:false 缺省值:null
     */
    @ApiModelProperty(value="城市",name="city")
    @Length(max = 16, message = "城市名长度最长为16")
    private String city;

    /**
     * 省份
	* 列名:province 类型:VARCHAR(16) 允许空:false 缺省值:null
     */
    @ApiModelProperty(value="省份",name="province")
    @Length(max = 16, message = "省份名长度最长为16")
    private String province;

    /**
     * 国家
	* 列名:country 类型:VARCHAR(16) 允许空:false 缺省值:null
     */
    @ApiModelProperty(value="国家",name="country")
    @Length(max = 16, message = "国家名长度最长为16")
    private String country;

    /**
     * 微信头像路径
	* 列名:head_img_url 类型:VARCHAR(200) 允许空:false 缺省值:null
     */
    @ApiModelProperty(value="微信头像路径",name="headImgUrl")
    @Length(max = 200, message = "微信头像路径名长度最长为200")
    private String headImgUrl;

    /**
     * 
	* 列名:phone 类型:VARCHAR(11) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="",name="phone")
    @Length(max = 11, message = "名长度最长为11")
    private String phone;

    /**
     * 
	* 列名:create_time 类型:TIMESTAMP(19) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="",name="createTime")
    private Date createTime;

    /**
     * 数据修改时间
	* 列名:update_time 类型:TIMESTAMP(19) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="数据修改时间",name="updateTime")
    private Date updateTime;

    /**
     * 是否关注 1：关注 0：取消关注
	* 列名:state 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="是否关注 1：关注 0：取消关注",name="state")
    private Integer state;
}