package com.bglemon.blue.taste.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @Author:zhuchuanshun
 * @Description: TODO
 * @Date: 2019/4/22 16:44
 * @Modificd:
 */
public class JWTUtil {
    // 过期时间 8 小时
    private static final long EXPIRE_TIME = 8*60*60*1000;

    /**
     * 校验token是否正确
     * @param token 密钥
     * @param id 用户的id
     * @return 是否正确
     */
    public static boolean verify(String token, String username, String id) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(id);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();
            // DecodedJWT jwt = verifier.verify(token);
            verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }
    /**
     * 获得token中的信息无需secret解密也能获得
     * @return token中包含的用户名
     */
    public static Integer getUserId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            String userId = jwt.getClaim("id").asString();
            return Integer.parseInt(userId.toString());
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 生成签名,5min后过期
     * @param username 用户名
     * @param id 用户的Id
     * @return 加密的token
     */
    public static String sign(String username, String id) {
        try {
            Date date = new Date(System.currentTimeMillis()+EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(id);
            // 附带username信息
            return JWT.create()
                    .withClaim("username", username)
                    .withClaim("id", id)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
}
