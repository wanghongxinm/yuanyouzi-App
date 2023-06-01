package com.project.laundryappui.user.model;

public class User {

    Long id;

    String password;

    Long p1;

    Long p2;

    int state=0;

    int state1=0;

    int state2=0;

    int state3=0;

    int state4=0;

    String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getState1() {
        return state1;
    }

    public void setState1(int state1) {
        this.state1 = state1;
    }

    public int getState2() {
        return state2;
    }

    public void setState2(int state2) {
        this.state2 = state2;
    }

    public int getState3() {
        return state3;
    }

    public void setState3(int state3) {
        this.state3 = state3;
    }

    public int getState4() {
        return state4;
    }

    public void setState4(int state4) {
        this.state4 = state4;
    }


    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Long getP1() {
        return p1;
    }

    public void setP1(Long p1) {
        this.p1 = p1;
    }

    public Long getP2() {
        return p2;
    }

    public void setP2(Long p2) {
        this.p2 = p2;
    }

}