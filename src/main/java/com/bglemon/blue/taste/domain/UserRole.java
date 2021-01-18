package com.bglemon.blue.taste.domain;

import lombok.Data;

import java.util.Date;

@Data
public class UserRole {
    /**
     *
     * 列名:id 类型:INTEGER(10) 允许空:false 缺省值:null
     */
    private Integer id;

    /**
     * 用户id
     * 列名:user_id 类型:INTEGER(10) 允许空:false 缺省值:null
     */
    private Integer userId;

    /**
     * 角色id
     * 列名:role_id 类型:INTEGER(10) 允许空:false 缺省值:null
     */
    private Integer roleId;

    /**
     * 创建时间
     * 列名:create_time 类型:TIMESTAMP(19) 允许空:true 缺省值:null
     */
    private Date createTime;

    /**
     * 删除（0存在，1删除）
     * 列名:deleted 类型:BIT(0) 允许空:true 缺省值:0
     */
    private Boolean deleted;

    public UserRole() {
    }

    public UserRole(Integer userId, Integer roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", roleId=" + roleId +
                ", createTime=" + createTime +
                '}';
    }
}