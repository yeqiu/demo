package com.yeqiu.demo.model;

/**
 * @project：demo
 * @author：小卷子
 * @date 2019-11-15
 * @describe：
 * @fix：
 */

public class Result<T> {


    private int code;
    private String msg;
    private T data;

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
