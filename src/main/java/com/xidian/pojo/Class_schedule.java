package com.xidian.pojo;

public class Class_schedule {
    private int course_id;
    private int total_number;
    private int experiment_id;
    private String name;
    private String experiment_time;
    private int experiment_room;
    private int batch;
    private int stu_number;

    public Class_schedule() {
    }

    public Class_schedule(int course_id, int total_number, int experiment_id, String name,
                          String experiment_time, int experiment_room, int batch, int stu_number) {
        this.course_id = course_id;
        this.total_number = total_number;
        this.experiment_id = experiment_id;
        this.name = name;
        this.experiment_time = experiment_time;
        this.experiment_room = experiment_room;
        this.batch = batch;
        this.stu_number = stu_number;
    }

    public Class_schedule(Class_schedule schedule) {
        this.course_id = schedule.course_id;
        this.total_number = schedule.total_number;
        this.experiment_id = schedule.experiment_id;
        this.name = schedule.name;
        this.experiment_time = schedule.experiment_time;
        this.experiment_room = schedule.experiment_room;
        this.batch = schedule.batch;
        this.stu_number = schedule.stu_number;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getTotal_number() {
        return total_number;
    }

    public void setTotal_number(int total_number) {
        this.total_number = total_number;
    }

    public int getExperiment_id() {
        return experiment_id;
    }

    public void setExperiment_id(int experiment_id) {
        this.experiment_id = experiment_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExperiment_time() {
        return experiment_time;
    }

    public void setExperiment_time(String experiment_time) {
        this.experiment_time = experiment_time;
    }

    public int getExperiment_room() {
        return experiment_room;
    }

    public void setExperiment_room(int experiment_room) {
        this.experiment_room = experiment_room;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public int getStu_number() {
        return stu_number;
    }

    public void setStu_number(int stu_number) {
        this.stu_number = stu_number;
    }

    @Override
    public String toString() {
        return "Class_schedule{" +
                "course_id=" + course_id +
                ", total_number=" + total_number +
                ", experiment_id=" + experiment_id +
                ", name='" + name + '\'' +
                ", experiment_time='" + experiment_time + '\'' +
                ", experiment_room=" + experiment_room +
                ", batch=" + batch +
                ", stu_number=" + stu_number +
                '}';
    }
}
