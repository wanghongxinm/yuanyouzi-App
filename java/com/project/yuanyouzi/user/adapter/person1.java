package com.project.laundryappui.user.adapter;

public class person1 {

    private int code;

    private String msg;

    private String result;

    private String result1;

    private String result2;

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

    public String getResult1() {
        return result1;
    }

    public void setResult1(String result1) {
        this.result1 = result1;
    }

    public String getResult2() {
        return result2;
    }

    public void setResult2(String result2) {
        this.result2 = result2;
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
