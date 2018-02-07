package com.bebetter.po;

public class RolePo {
    private int id;
    private String name;
    public RolePo(){}
    public RolePo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void print() {
        System.out.println(String.format("role：id=%d，name=%s", this.getId(), this.getName()));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
