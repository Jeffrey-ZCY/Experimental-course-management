package com.xidian.pojo;

public class Experimenter {
    private int id;
    private String name;

    public Experimenter() {
    }

    public Experimenter(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Experimenter(Experimenter experimenter) {
        this.id = experimenter.id;
        this.name = experimenter.name;
    }

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

    @Override
    public String toString() {
        return "Experimenter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
