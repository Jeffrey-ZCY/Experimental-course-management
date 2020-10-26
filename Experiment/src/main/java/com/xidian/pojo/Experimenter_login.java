package com.xidian.pojo;

public class Experimenter_login {
    private int id;
    private String pwd;

    public Experimenter_login(int id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }

    public Experimenter_login(Experimenter_login login) {
        this.id = login.id;
        this.pwd = login.pwd;
    }

    public Experimenter_login() {
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
        return "Experimenter_login{" +
                "id=" + id +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
