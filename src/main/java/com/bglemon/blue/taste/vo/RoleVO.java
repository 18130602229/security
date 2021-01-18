package com.bglemon.blue.taste.vo;

import lombok.Data;

/**
 * @Author:zhuchuanshun
 * @Description: TODO
 * @Date: 2019/6/20 11:35
 * @Modificd:
 */
@Data
public class RoleVO {
    private int id;
    private String role;

    private String description;

    private Integer[] addPermissions;

    private Integer[] removePermissions;
}
