package com.project.laundryappui.user.adapter;

public class Person {

    private int code;

    private String msg;

    private String result;


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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "code=" + code +
                ", msg=" + msg +
                ", result='" + result + '\'' +
                '}';
    }
}
