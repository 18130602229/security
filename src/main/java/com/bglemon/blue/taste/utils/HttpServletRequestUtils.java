package com.bglemon.blue.taste.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * Copyright: Copyright (c) 2018 LanRu-zhouyao
 *
 * @ClassName: cn.com.blackview.iov.fleet.utils
 * @Description: HttpServletRequest相关工具类
 * @version: v1.0.0
 * @author: zhouyao
 * @date: 2018/11/6 16:42
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018/11/6     Administrator           v1.0.0               修改原因
 */
public class HttpServletRequestUtils {

    /**
    * $see_to_overridden}
    * @Function: HttpServletRequestUtils.java
    * @Description: 获取ip地址
    * @param: HttpServletRequest
    * @return String ip地址
    * @version: v1.0.0
    * @author: zhouyao
    * @date: 2018/11/6 16:43
    *
    * Modification History:
    * Date         Author          Version            Description
    *---------------------------------------------------------*
    * 2018/11/6     Administrator           v1.0.0               修改原因
    */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
