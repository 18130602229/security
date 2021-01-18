package com.bglemon.blue.taste.utils;

public enum ErrorCode {
    OK(200, "请求成功"),
    CREATED(201, "创建成功"),
    ACCEPTED(202, "请求已经接收"),
    NO_CONTENT(204, "没有内容"),
    BAD_REQUEST(400, "无效的请求"),
    UNAUTHORIZED(401, "用户未认证"),
    FORBIDDEN(403, "用户无权限访问该资源"),
    NOT_FOUND(404, "找不到URI对应的资源"),
    CONFLICT(409, "资源冲突"),
    TOO_MANY_REQUESTS(429, "访问太频繁"),
    INTERNAL_SERVER_ERROR(500, "服务器错误"),
    BLACKVIEW_DEFINITION(6000, "凌度自定义"),
    PARAMS_ERROR(6001, "参数错误 "),
    FORBID_EMPLOY(6002, "禁止登陆"),
    MAX_VALUE(2147483647, "错误码最大值");

    private int code;
    private String message;

    private ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toString() {
        return "ErrorCode{code=" + this.code + ", message='" + this.message + '\'' + '}';
    }
}