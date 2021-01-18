package com.bglemon.blue.taste.utils;

/**
 * @Author:zhuchuanshun
 * @Description: TODO
 * @Date: 2019/12/7 11:26
 * @Modificd:
 */
public class ApiResult<T> {
    private Integer code;
    private String message;
    private T data;

    public ApiResult() {
        this.code = ErrorCode.OK.getCode();
        this.message = ErrorCode.OK.getMessage();
        this.setErrorCode(ErrorCode.OK);
    }

    public ApiResult(Integer code, String message) {
        this.code = ErrorCode.OK.getCode();
        this.message = ErrorCode.OK.getMessage();
        this.setCodeAndMessage(code, message);
    }

    public void setSuccessCode() {
        this.setErrorCode(ErrorCode.OK);
    }

    public void setFailCode() {
        this.setErrorCode(ErrorCode.INTERNAL_SERVER_ERROR);
    }

    public void setFailMessage(String message) {
        this.code = ErrorCode.INTERNAL_SERVER_ERROR.getCode();
        this.message = message;
    }

    public void setCodeAndMessage(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiResult<T> withcode(Integer code) {
        this.setCode(code);
        return this;
    }

    public ApiResult<T> withMessage(String message) {
        this.setMessage(message);
        return this;
    }

    public ApiResult<T> withData(T data) {
        this.setData(data);
        return this;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.setCodeAndMessage(errorCode.getCode(), errorCode.getMessage());
    }

    public Integer getcode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    //public String toString() {
    //    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    //}
}
