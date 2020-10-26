package com.xidian.pojo;

public class Experiment_score {
    private String experiment_name;
    private String course_name;
    private int stu_id;
    private String stu_name;
    private String stu_class;
    private int experiment_score;

    public Experiment_score() {
    }

    public Experiment_score(String experiment_name, String course_name, int stu_id,
                            String stu_name, String stu_class, int experiment_score) {
        this.experiment_name = experiment_name;
        this.course_name = course_name;
        this.stu_id = stu_id;
        this.stu_name = stu_name;
        this.stu_class = stu_class;
        this.experiment_score = experiment_score;
    }

    public Experiment_score(Experiment_score score) {
        this.experiment_name = score.experiment_name;
        this.course_name = score.course_name;
        this.stu_id = score.stu_id;
        this.stu_name = score.stu_name;
        this.stu_class = score.stu_class;
        this.experiment_score = score.experiment_score;
    }

    public String getExperiment_name() {
        return experiment_name;
    }

    public void setExperiment_name(String experiment_name) {
        this.experiment_name = experiment_name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_class() {
        return stu_class;
    }

    public void setStu_class(String stu_class) {
        this.stu_class = stu_class;
    }

    public int getExperiment_score() {
        return experiment_score;
    }

    public void setExperiment_score(int experiment_score) {
        this.experiment_score = experiment_score;
    }

    @Override
    public String toString() {
        return "Experiment_score{" +
                "experiment_name='" + experiment_name + '\'' +
                ", course_name='" + course_name + '\'' +
                ", stu_id=" + stu_id +
                ", stu_name='" + stu_name + '\'' +
                ", stu_class='" + stu_class + '\'' +
                ", experiment_score=" + experiment_score +
                '}';
    }
}
