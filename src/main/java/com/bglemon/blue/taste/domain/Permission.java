package com.bglemon.blue.taste.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Permission {
    /**
     * 权限id
     * 列名:id 类型:INTEGER(10) 允许空:false 缺省值:null
     */
    private Integer id;

    /**
     * 权限名称
     * 列名:permission 类型:VARCHAR(64) 允许空:false 缺省值:null
     */
    private String permission;

    /**
     * 类型：0：菜单类型；1：功能类型
     * 列名:type 类型:INTEGER(10) 允许空:false 缺省值:0
     */
    private Integer type;

    /**
     * 父级权限
     * 列名:parent_id 类型:INTEGER(10) 允许空:true 缺省值:0
     */
    private Integer parentId;

    /**
     * 权限描述
     * 列名:description 类型:VARCHAR(128) 允许空:true 缺省值:null
     */
    private String description;

    /**
     * 资源(权限路径)
     * 列名:url 类型:VARCHAR(128) 允许空:true 缺省值:null
     */
    private String url;

    /**
     * 菜单前面的 icon
     * 列名:menu_icon 类型:VARCHAR(64) 允许空:true 缺省值:null
     */
    private String menuIcon;

    /**
     * 创建时间
     * 列名:create_time 类型:TIMESTAMP(19) 允许空:true 缺省值:null
     */
    private Date createTime;

    /**
     * 更新时间
     * 列名:update_time 类型:TIMESTAMP(19) 允许空:false 缺省值:CURRENT_TIMESTAMP
     */
    private Date updateTime;

    /**
     * 删除（0存在，1删除）
     * 列名:deleted 类型:BIT(0) 允许空:true 缺省值:0
     */
    private Boolean deleted;

    /**
     * 排序；数字越大越往后
     * 列名:order_no 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    private Integer orderNo;

}