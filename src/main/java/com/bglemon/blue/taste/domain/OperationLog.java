package com.bglemon.blue.taste.domain;

import lombok.Data;

import java.util.Date;

@Data
public class OperationLog {
    /**
     * 操作日志id
     * 列名:id 类型:INTEGER(10) 允许空:false 缺省值:null
     */
    private Integer id;

    /**
     * 操作id
     * 列名:user_id 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    private Integer userId;

    /**
     * 接口路径
     * 列名:url 类型:VARCHAR(128) 允许空:true 缺省值:null
     */
    private String url;

    /**
     * 请求方式（get、post...）
     * 列名:http_method 类型:VARCHAR(7) 允许空:true 缺省值:null
     */
    private String httpMethod;

    /**
     * 操作时间
     * 列名:operation_time 类型:TIMESTAMP(19) 允许空:true 缺省值:null
     */
    private Date operationTime;

    /**
     * 是否执行成功(0失败1成功)
     * 列名:succeed 类型:BIT(0) 允许空:true 缺省值:null
     */
    private Boolean succeed;

    @Override
    public String toString() {
        return "OperationLog{" +
                "id=" + id +
                ", userId=" + userId +
                ", url='" + url + '\'' +
                ", httpMethod='" + httpMethod + '\'' +
                ", operationTime=" + operationTime +
                ", succeed=" + succeed +
                '}';
    }
}