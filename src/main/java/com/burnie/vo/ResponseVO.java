package com.burnie.vo;

/**
 * Created by liangboning on 2019/7/9.
 */
public class ResponseVO<T> {

    private int resultcode;

    private String message;

    private T data;

    public int getResultcode() {
        return resultcode;
    }

    public void setResultcode(int resultcode) {
        this.resultcode = resultcode;
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
