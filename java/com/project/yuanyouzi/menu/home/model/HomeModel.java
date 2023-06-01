package com.project.laundryappui.menu.home.model;

public class HomeModel {
    private String content;
    private String name;
    private String date;
    private String location;

    public HomeModel(String content, String name, String date, String location) {
        this.content = content;
        this.name = name;
        this.date = date;
        this.location = location;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String price) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
