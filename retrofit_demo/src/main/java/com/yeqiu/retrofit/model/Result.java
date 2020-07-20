package com.yeqiu.retrofit.model;



public class Result<T> {

    private int code = 0;
    private String message;
    private T data;



    public static  Result getInstance(){
        Result result = new Result();
        result.setCode(0);
        result.setMessage("请求成功");
        return result;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
