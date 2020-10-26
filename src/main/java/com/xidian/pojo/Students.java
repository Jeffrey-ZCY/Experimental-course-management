package com.xidian.pojo;

public class Students {
    private int stu_id;
    private String stu_class;
    private int course_id;
    private int experiment_id;
    private int total_score;

    public Students() {
    }

    public Students(int stu_id, String stu_class, int course_id,
                    int experiment_id, int total_score) {
        this.stu_id = stu_id;
        this.stu_class = stu_class;
        this.course_id = course_id;
        this.experiment_id = experiment_id;
        this.total_score = total_score;
    }

    public Students(Students students) {
        this.stu_id = students.stu_id;
        this.stu_class = students.stu_class;
        this.course_id = students.course_id;
        this.experiment_id = students.experiment_id;
        this.total_score = students.total_score;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_class() {
        return stu_class;
    }

    public void setStu_class(String stu_class) {
        this.stu_class = stu_class;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getExperiment_id() {
        return experiment_id;
    }

    public void setExperiment_id(int experiment_id) {
        this.experiment_id = experiment_id;
    }

    public int getTotal_score() {
        return total_score;
    }

    public void setTotal_score(int total_score) {
        this.total_score = total_score;
    }

    @Override
    public String toString() {
        return "Students{" +
                "stu_id=" + stu_id +
                ", stu_class='" + stu_class + '\'' +
                ", course_id=" + course_id +
                ", experiment_id=" + experiment_id +
                ", total_score=" + total_score +
                '}';
    }

}
