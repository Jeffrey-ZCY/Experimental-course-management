package com.xidian.pojo;

public class Experiment {
    private int course_id;
    private int experiment_id;
    private String experiment_name;
    private String experiment_category;
    private int difficulty;
    private int hours;
    private int schedule_weeks;

    public Experiment() {
    }

    public Experiment(int course_id,int experiment_id, String experiment_name, String experiment_category,
                      int difficulty, int hours, int schedule_weeks) {
        this.course_id = course_id;
        this.experiment_id = experiment_id;
        this.experiment_name = experiment_name;
        this.experiment_category = experiment_category;
        this.difficulty = difficulty;
        this.hours = hours;
        this.schedule_weeks = schedule_weeks;
    }

    public Experiment(Experiment experiment) {
        this.course_id = experiment.course_id;
        this.experiment_id = experiment.experiment_id;
        this.experiment_name = experiment.experiment_name;
        this.experiment_category = experiment.experiment_category;
        this.difficulty = experiment.difficulty;
        this.hours = experiment.hours;
        this.schedule_weeks = experiment.schedule_weeks;
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

    public String getExperiment_name() {
        return experiment_name;
    }

    public void setExperiment_name(String experiment_name) {
        this.experiment_name = experiment_name;
    }

    public String getExperiment_category() {
        return experiment_category;
    }

    public void setExperiment_category(String experiment_category) {
        this.experiment_category = experiment_category;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getSchedule_weeks() {
        return schedule_weeks;
    }

    public void setSchedule_weeks(int schedule_weeks) {
        this.schedule_weeks = schedule_weeks;
    }

    @Override
    public String toString() {
        return "Experiment{" +
                "course_id=" + course_id +
                ", experiment_id=" + experiment_id +
                ", experiment_name='" + experiment_name + '\'' +
                ", experiment_category='" + experiment_category + '\'' +
                ", difficulty=" + difficulty +
                ", hours=" + hours +
                ", schedule_weeks=" + schedule_weeks +
                '}';
    }
}
