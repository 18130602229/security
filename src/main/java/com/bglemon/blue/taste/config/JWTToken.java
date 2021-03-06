package com.bglemon.blue.taste.config;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Author:zhuchuanshun
 * @Description: TODO
 * @Date: 2019/4/22 16:48
 * @Modificd:
 */
public class JWTToken implements AuthenticationToken {

    // 密钥
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
