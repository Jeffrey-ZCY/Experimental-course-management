package com.xidian.pojo;

public class Laboratory {
    private int room;
    private int number;

    public Laboratory() {
    }

    public Laboratory(int room, int number) {
        this.room = room;
        this.number = number;
    }

    public Laboratory(Laboratory laboratory) {
        this.room = laboratory.room;
        this.number = laboratory.number;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Laboratory{" +
                "room=" + room +
                ", number=" + number +
                '}';
    }
}
