package com.havryliak;

import com.havryliak.DAO.RoomDAO;
import com.havryliak.Model.Room;

public class Main {

    public static void main(String[] args) {

        RoomDAO dao = new RoomDAO();
        System.out.println(dao.getRooms());
        dao.updateRoomStatus(false,101);
        System.out.println(dao.findRoomByNumber(102));
        System.out.println(dao.getAvailableRooms());
    }
}
