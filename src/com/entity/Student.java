package com.entity;


public class Student {
    private Integer stunumber;
    private String stuname;
    private String stuclass;
    private String testname;
    private Integer testscore;


    public Integer getStunumber() {
        return stunumber;
    }

    public void setStunumber(Integer stunumber) {
        this.stunumber = stunumber;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getStuclass() {
        return stuclass;
    }

    public void setStuclass(String stuclass) {
        this.stuclass = stuclass;
    }

    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        this.testname = testname;
    }

    public Integer getTestscore() {
        return testscore;
    }

    public void setTestscore(Integer testscore) {
        this.testscore = testscore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stunumber=" + stunumber +
                ", stuname='" + stuname + '\'' +
                ", stuclass='" + stuclass + '\'' +
                ", testname='" + testname + '\'' +
                ", testscore=" + testscore +
                '}';
    }
}
