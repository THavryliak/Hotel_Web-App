package com.havryliak.Model;

public class Room {
    private int number;
    private String room_type;
    private boolean available;


    public Room(int number, String room_type, boolean available){
        this.number = number;
        this.room_type = room_type;
        this.available = available;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                ", room_type='" + room_type + '\'' +
                ", available=" + available +
                '}';
    }
}