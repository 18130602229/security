package com.bglemon.blue.taste.domain;


import lombok.Data;

import java.util.Date;

/**
 *
 * @author zhuchuanshun
 * @date 2019-12-17
 * 数据表account_log映射bean，由Mybaits自动生成工具生成
 */
@Data
public class AccountLog {
    /**
     * id
     * 列名:id 类型:INTEGER(10) 允许空:false 缺省值:null
     */
    private Integer id;

    /**
     * 日志名称(1:login,2:logout,3:register)
     * 列名:log_type 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    private Integer logType;

    /**
     * 用户id
     * 列名:user_id 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    private Integer userId;

    /**
     * 登录ip
     * 列名:ip 类型:VARCHAR(32) 允许空:true 缺省值:null
     */
    private String ip;

    /**
     * 创建时间
     * 列名:create_time 类型:TIMESTAMP(19) 允许空:true 缺省值:CURRENT_TIMESTAMP
     */
    private Date createTime;

    /**
     * 是否执行成功(0失败1成功)
     * 列名:succeed 类型:BIT(0) 允许空:true 缺省值:null
     */
    private Boolean succeed;
    @Override
    public String toString() {
        return "AccountLog{" +
                "id=" + id +
                ", logType=" + logType +
                ", userId=" + userId +
                ", ip='" + ip + '\'' +
                ", createTime=" + createTime +
                ", succeed=" + succeed +
                '}';
    }
}