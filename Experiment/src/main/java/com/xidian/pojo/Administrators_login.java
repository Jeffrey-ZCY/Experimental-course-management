package com.xidian.pojo;

public class Administrators_login {
    private int id;
    private String pwd;

    public Administrators_login() {
    }

    public Administrators_login(int id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }

    public Administrators_login(Administrators_login login) {
        this.id = login.id;
        this.pwd = login.pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Administrators_login{" +
                "id=" + id +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
