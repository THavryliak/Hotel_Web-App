package com.havryliak;

import com.havryliak.Model.Roomer;
import com.havryliak.Model.Room;


public class Application {
    public static void main(String[] args) {

        Room some = new Room(1, "LUX", true);
        Roomer one = new Roomer("Taras", "Havryliak", 22, "ua", some);

        System.out.println(one);
    }
}
