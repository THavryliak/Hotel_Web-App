package com.havryliak.DAO;

import com.havryliak.DBconnector.dbConnector;
import com.havryliak.Model.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO implements DAOi<Room> {


    dbConnector connector = new dbConnector(); // цікаво, що без конструктора - не працює

    private static final String SELECT_ALL_ROOMS = "SELECT * FROM room;";
    private static final String INSERT_ROOM = "INSERT INTO room" + "  (number, room_type, available) VALUES " + " (?, ?, ?);";
    private static final String UPDATE_ROOM_STATUS = "UPDATE room SET available = ? WHERE number = ?;";
    private static final String SELECT_ROOM_BY_NUMBER = "SELECT * FROM room WHERE number = ?;";
    private static final String DELETE_ROOM_BY_NUMBER = "DELETE FROM room WHERE number = ?;";
    private static final String SELECT_AVAILABLE_ROOMS = "SELECT * FROM room WHERE available = true;";

    @Override
    public List<Room> getAll() {
        List<Room> roomsList = new ArrayList<>();
        try (Connection connection = connector.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(SELECT_ALL_ROOMS)
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                int number = rs.getInt("number");
                String room_type = rs.getString("room_type");
                boolean available = rs.getBoolean("available");
                Room room = new Room(id, number, room_type, available);
                roomsList.add(room);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return roomsList;
    }

    @Override
    public void add(Room room) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_ROOM)
        ) {
            statement.setInt(1, room.getNumber());
            statement.setString(2, room.getRoom_type());
            statement.setBoolean(3, room.isAvailable());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBy(int number) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ROOM_BY_NUMBER)
        ) {
            statement.setInt(1, number);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Room findBy(int number) {
        Room room = null;
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ROOM_BY_NUMBER)
        ) {
            statement.setInt(1, number);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                room = new Room(rs.getInt("id"), rs.getInt("number"), rs.getString("room_type"), rs.getBoolean("available"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return room;
    }

    public void updateRoomStatus(boolean status, int number) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ROOM_STATUS)
        ) {
            statement.setBoolean(1, status);
            statement.setInt(2, number);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Room> getAvailableRooms(){
        List<Room> availableRooms = new ArrayList<>();
        try (Connection connection = connector.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(SELECT_AVAILABLE_ROOMS)
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                int number = rs.getInt("number");
                String room_type = rs.getString("room_type");
                boolean available = rs.getBoolean("available");
                Room room = new Room(id, number, room_type, available);
                availableRooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return availableRooms;
    }
}