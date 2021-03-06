package com.teenyda.common;

import org.springframework.util.StringUtils;

/**
 * 统一返回格式
 * @Author Administrator
 * @Date 2019-01-06.
 * @Email teenyda@gmail.com
 */
public class ResultBody<T> {

    /**
     * 响应码
     */
    private int code;

    /**
     * 响应消息
     */
    private String msg;

    /**
     * 响应结果
     */
    private T data;

    public ResultBody(ErrorInfoInterface errorInfo){
        this.code = errorInfo.getCode();
        this.msg = errorInfo.getMessage();
        String explain = errorInfo.getExplain();
        if (!StringUtils.isEmpty(explain)) {
            this.msg = String.format(this.msg, explain);
        }
    }

    public ResultBody(T data){
        this.code = GlobalErrorInfoEnum.SUCCESS.getCode();
        this.msg = GlobalErrorInfoEnum.SUCCESS.getMessage();
        this.data = data;
    }

    public ResultBody(ErrorInfoInterface errorInfo,T data){
        this.code = errorInfo.getCode();
        this.msg = errorInfo.getMessage();
        this.data = data;
    }

    public ResultBody(GlobalErrorInfoException errorInfo) {
        this.code = errorInfo.getCode();
        this.msg = errorInfo.getMessage();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
