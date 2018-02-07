package com.bebetter.po;

public class UserPo {
    private int id;
    private String name;
    private RolePo rolePo;

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

    public RolePo getRolePo() {
        return rolePo;
    }

    public void setRolePo(RolePo rolePo) {
        this.rolePo = rolePo;
    }
}
