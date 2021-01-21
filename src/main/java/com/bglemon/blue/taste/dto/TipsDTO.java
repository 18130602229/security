package com.bglemon.blue.taste.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @description: 提示列表返回对象
 * @author: immortal
 * @modified By：
 * @create: 2021-01-21 18:20
 **/
@Data
public class TipsDTO {
    private int id;
    // 文字性 描述
    private String Text;
    /**
     * 客户ID
     * 列名:customer_id 类型:VARCHAR(255) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="客户ID",name="customerId")
    @Length(max = 255, message = "客户ID名长度最长为255")
    private String unionId;
    // 商品名称
    private String goodsName;
    /**
     * 商品ID
     * 列名:goods_id 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="商品ID",name="goodsId")
    private Integer goodsId;
    // 商品类型
    private String goodsKind;
    /**
     * 广告ID
     * 列名:ad_id 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="广告ID",name="adId")
    private Integer adId;

    @ApiModelProperty(value="广告ID",name="adId")
    private Integer type;

    // 广告名称
    private String adName;
    // 广告类型
    private String adType;
    // 查询记录Id
    private Integer queryRecordId;
    /**
     * 创建时间
     * 列名:create_time 类型:TIMESTAMP(19) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="创建时间",name="createTime")
    private String createTime;
}