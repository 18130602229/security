package com.bglemon.blue.taste.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class AdminUser {
    private int id;

    private String account;

    private String password;

    private String salt;

    private Date createTime;

    private Date updateTime;

    private Boolean deleted;

    private Boolean enabled;
    private List<Role> roleList;
}