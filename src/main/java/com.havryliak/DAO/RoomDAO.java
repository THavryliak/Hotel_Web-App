package com.havryliak.DAO;

import com.havryliak.DBconnector.dbConnector;
import com.havryliak.Model.Room;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {

    dbConnector connector;

    private static final String SELECT_ALL_ROOMS = "SELECT * FROM room;";
    private static final String INSERT_ROOM = "INSERT INTO room" + "  (number, room_type, available) VALUES " + " (?, ?, ?);";
    private static final String UPDATE_ROOM_STATUS = "UPDATE room SET available = ? WHERE number = ?;";
    private static final String SELECT_ROOM_BY_NUMBER = "SELECT * FROM room WHERE number = ?;";
    private static final String DELETE_ROOM_BY_NUMBER = "DELETE FROM room WHERE number = ?;";


    public List<Room> getTable() {
        List<Room> listClient = new ArrayList<>();
        try (Connection connection = connector.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(SELECT_ALL_ROOMS);
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                int number = rs.getInt("number");
                String room_type = rs.getString("room_type");
                boolean available = rs.getBoolean("available");
                Room room = new Room(id, number, room_type, available);
                listClient.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listClient;
    }
}
