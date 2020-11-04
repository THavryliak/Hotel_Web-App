package com.havryliak;

import com.havryliak.DAO.RoomDAO;
import com.havryliak.DAO.Room_Roomer_DAO;
import com.havryliak.DAO.RoomerDAO;
import com.havryliak.Model.Room;
import com.havryliak.Model.Room_Roomer;
import com.havryliak.Model.Roomer;

public class Main {

    public static void main(String[] args) {

        RoomDAO dao = new RoomDAO();
        RoomerDAO rDao = new RoomerDAO();
        Room_Roomer_DAO rrDao = new Room_Roomer_DAO();

        System.out.println(dao.getAll());
        System.out.println(rDao.getAll());
        System.out.println(rrDao.getAll());

    }
}
