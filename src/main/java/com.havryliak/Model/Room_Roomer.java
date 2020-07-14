package com.havryliak.Model;

public class Room_Roomer {

    private int id;
    private int roomer_id;
    private int room_id;
    private String living_period;

    public Room_Roomer(int id, int roomer_id, int room_id, String living_period) {
        this(roomer_id, room_id, living_period);
        this.id = id;
    }

    public Room_Roomer(int roomer_id, int room_id, String living_period) {
        this.roomer_id = roomer_id;
        this.room_id = room_id;
        this.living_period = living_period;
    }

    public int getRoomer_id() {
        return roomer_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRoomer_id(int roomer_id) {
        this.roomer_id = roomer_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getLiving_period() {
        return living_period;
    }

    public void setLiving_period(String living_period) {
        this.living_period = living_period;
    }

    @Override
    public String toString() {
        return "Room_Roomer{" +
                "id=" + id +
                ", roomer_id=" + roomer_id +
                ", room_id=" + room_id +
                ", living_period='" + living_period + '\'' +
                '}';
    }
}
