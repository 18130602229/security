package com.bglemon.blue.taste.domain;

import lombok.Data;

import java.util.Date;

@Data
public class RolePermission {
    /**
     * 角色权限id
     * 列名:id 类型:INTEGER(10) 允许空:false 缺省值:null
     */
    private Integer id;

    /**
     * 角色id
     * 列名:role_id 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    private Integer roleId;

    /**
     * 权限id
     * 列名:permission_id 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    private Integer permissionId;

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

    public RolePermission() {
    }

    public RolePermission(Integer roleId, Integer permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", permissionId=" + permissionId +
                ", createTime=" + createTime +
                ", deleted=" + deleted +
                '}';
    }
}