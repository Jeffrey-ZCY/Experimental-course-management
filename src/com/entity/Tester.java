package com.entity;

public class Tester {
    private Integer testerid;//用户id
    private String  testername;//用户姓名
    private String  testerpwd;//用户密码

    public Integer getTesterid() {
        return testerid;
    }

    public void setTesterid(Integer testerid) {
        this.testerid = testerid;
    }

    public String getTestername() {
        return testername;
    }

    public void setTestername(String testername) {
        this.testername = testername;
    }

    public String getTesterpwd() {
        return testerpwd;
    }

    public void setTesterpwd(String testerpwd) {
        this.testerpwd = testerpwd;
    }

    @Override
    public String toString() {
        return "Tester{" +
                "testerid=" + testerid +
                ", testername='" + testername + '\'' +
                ", testerpwd='" + testerpwd + '\'' +
                '}';
    }
}
