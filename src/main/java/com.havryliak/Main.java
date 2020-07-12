package com.havryliak;

import com.havryliak.DAO.RoomDAO;

public class Main {

    public static void main(String[] args) {

        RoomDAO dao = new RoomDAO();
        System.out.println(dao.getTable());
    }
}
