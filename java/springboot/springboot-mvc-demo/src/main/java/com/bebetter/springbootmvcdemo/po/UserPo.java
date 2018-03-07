package com.bebetter.springbootmvcdemo.po;

public class UserPo {
    private int id;
    private String name;
    private String roleName;

    public UserPo(int id, String name, String roleName) {
        this.id = id;
        this.name = name;
        this.roleName = roleName;
    }

    /**
     * 为了mapper自动实现数据库和pojo之间的转换
     */
    public UserPo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void print() {
        System.out.println(String.format("user：id=%d，name=%s，roleName=%s", this.getId(), this.getName(), this.getRoleName()));
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
