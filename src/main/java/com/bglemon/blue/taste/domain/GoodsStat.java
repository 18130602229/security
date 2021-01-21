package com.bglemon.blue.taste.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
* Class
* Goods_stat
*
* @author zhuchaunshun
* @created Create Time: 2021-01-18 18:22:59
*/
@ApiModel(value="com.bglemon.blue.taste.domain.Goods_stat",description="")
@Data()
public class GoodsStat {
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
     * 总查询次数
	* 列名:sum_scan_num 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="总查询次数",name="sumScanNum")
    private Integer sumScanNum;

    /**
     * 总错误次数
	* 列名:sum_scan_err_num 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="总错误次数",name="sumScanErrNum")
    private Integer sumScanErrNum;

    /**
     * 重复率
	* 列名:repetition_rate 类型:VARCHAR(255) 允许空:true 缺省值:null
     */
    @ApiModelProperty(value="重复率",name="repetitionRate")
    @Length(max = 255, message = "重复率名长度最长为255")
    private String repetitionRate;
}