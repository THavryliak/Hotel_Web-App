package com.havryliak.Model;

public class Roomer {
    private String first_name;
    private String second_name;
    private int age;
    private String country;

    private Room room;

    public Roomer(String first_name, String second_name, int age, String country, Room room) {
        this.first_name = first_name;
        this.second_name = second_name;
        this.age = age;
        this.country = country;
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Person{" +
                "first_name='" + first_name + '\'' +
                ", second_name='" + second_name + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", room=" + room +
                '}';
    }
}
