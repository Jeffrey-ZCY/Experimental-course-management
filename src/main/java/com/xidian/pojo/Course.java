package com.xidian.pojo;

public class Course {

    private int course_id;
    private String course_name;
    private int experiment_hours;
    private String classes;
    private String teaching_department;
    private String teaching_term;

    public Course() {
    }

    public Course(int course_id, String course_name, int experiment_hours,
                  String classes, String teaching_department, String teaching_term) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.experiment_hours = experiment_hours;
        this.classes = classes;
        this.teaching_department = teaching_department;
        this.teaching_term = teaching_term;
    }

    public Course(Course c) {
        this.course_id = c.course_id;
        this.course_name = c.course_name;
        this.experiment_hours = c.experiment_hours;
        this.classes = c.classes;
        this.teaching_department = c.teaching_department;
        this.teaching_term = c.teaching_term;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getExperiment_hours() {
        return experiment_hours;
    }

    public void setExperiment_hours(int experiment_hours) {
        this.experiment_hours = experiment_hours;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getTeaching_department() {
        return teaching_department;
    }

    public void setTeaching_department(String teaching_department) {
        this.teaching_department = teaching_department;
    }

    public String getTeaching_term() {
        return teaching_term;
    }

    public void setTeaching_term(String teaching_term) {
        this.teaching_term = teaching_term;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id=" + course_id +
                ", course_name='" + course_name + '\'' +
                ", experiment_hours=" + experiment_hours +
                ", classes='" + classes + '\'' +
                ", teaching_department='" + teaching_department + '\'' +
                ", teaching_term='" + teaching_term + '\'' +
                '}';
    }
}
