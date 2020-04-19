package com.havryliak.Model;

import java.util.ArrayList;

public class Management {
    private ArrayList<Roomer> living = new ArrayList<>();
    private ArrayList<Room> rooms = new ArrayList<>();

    public ArrayList<Roomer> getLiving(){
        return living;
    }

    public void addRoomer(Roomer roomer){
        living.add(roomer);
    }

    public ArrayList<Room> getRooms(){
        return rooms;
    }

    public void addRoom(Room room){
        rooms.add(room);
    }
}
