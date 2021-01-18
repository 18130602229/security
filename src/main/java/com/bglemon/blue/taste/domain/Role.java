package com.bglemon.blue.taste.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Role {
    /**
     * 角色id
     * 列名:id 类型:INTEGER(10) 允许空:false 缺省值:null
     */
    private Integer id;

    /**
     * 角色名称
     * 列名:role 类型:VARCHAR(16) 允许空:false 缺省值:null
     */
    private String role;

    /**
     * 类型(0.超级管理员，1.普通管理员)
     * 列名:role_type 类型:INTEGER(10) 允许空:false 缺省值:1
     */
    private Integer roleType;

    /**
     * 角色描述
     * 列名:description 类型:VARCHAR(128) 允许空:false 缺省值:null
     */
    private String description;

    /**
     * 创建时间
     * 列名:create_time 类型:TIMESTAMP(19) 允许空:true 缺省值:null
     */
    private Date createTime;

    /**
     *
     * 列名:update_time 类型:TIMESTAMP(19) 允许空:false 缺省值:CURRENT_TIMESTAMP
     */
    private Date updateTime;

    /**
     * 删除（0存在，1删除）
     * 列名:deleted 类型:BIT(0) 允许空:true 缺省值:0
     */
    private Boolean deleted = false;

    private List<Permission> permissions;// 角色 - 权限关系定义;

    public Role() {
    }

    public Role(String role, String description) {
        this.role = role;
        this.description = description;
    }
}