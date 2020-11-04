package com.havryliak.DAO;

import com.havryliak.DBconnector.dbConnector;
import com.havryliak.Model.Room_Roomer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Room_Roomer_DAO implements DAOi<Room_Roomer> {

    dbConnector connector = new dbConnector();

    private static final String SELECT_ALL_ROOM_ROOMERS = "SELECT * FROM ROOM_ROOMER;";
    private static final String INSERT_ROOM_ROOMER = "INSERT INTO ROOM_ROOMER" + "( ID_ROOM, ID_ROOMER, LIVING_PERIOD ) VALUES" + "(?, ?, ?);";
    private static final String DELETE_ROOM_ROOMER_BY_ID = "DELETE FROM ROOM_ROOMER WHERE id=?;";
    private static final String SELECT_ROOM_ROOMER_BY_ID = "SELECT * FROM ROOM_ROOMER WHERE id=?;";
    private static final String UPDATE_ROOM_ROOMER = "UPDATE ROOM_ROOMER SET id_room = ?, id_roomer = ?, living_period = ? where id = ?;";

    @Override
    public List<Room_Roomer> getAll() {
        List<Room_Roomer> room_roomer_list = new ArrayList<>();
        try (Connection connection = connector.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(SELECT_ALL_ROOM_ROOMERS);
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                int id_room = rs.getInt("id_room");
                int id_roomer = rs.getInt("id_roomer");
                String living_period = rs.getString("living_period");
                Room_Roomer room_roomer = new Room_Roomer(id, id_room, id_roomer, living_period);
                room_roomer_list.add(room_roomer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return room_roomer_list;
    }

    //gets Room_Roomer from servlet
    @Override
    public void add(Room_Roomer room_roomer) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_ROOM_ROOMER)
        ) {
            statement.setInt(1, room_roomer.getId());
            statement.setInt(2, room_roomer.getRoom_id());
            statement.setInt(3, room_roomer.getRoomer_id());
            statement.setString(4, room_roomer.getLiving_period());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBy(int id) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ROOM_ROOMER_BY_ID)
        ) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Room_Roomer findBy(int id) {
        Room_Roomer room_roomer = null;
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ROOM_ROOMER_BY_ID)
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                room_roomer = new Room_Roomer(rs.getInt("id"), rs.getInt("id_room"), rs.getInt("id_roomer"), rs.getString("living_period"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return room_roomer;
    }

    //gets Room_roomer from servlet
    public void updateRoomRoomer(Room_Roomer room_roomer) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ROOM_ROOMER)
        ) {
            statement.setInt(1, room_roomer.getRoom_id());
            statement.setInt(2, room_roomer.getRoomer_id());
            statement.setString(3, room_roomer.getLiving_period());
            statement.setInt(4, room_roomer.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
