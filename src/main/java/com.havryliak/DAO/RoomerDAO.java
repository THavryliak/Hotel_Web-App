package com.havryliak.DAO;

import com.havryliak.DBconnector.dbConnector;
import com.havryliak.Model.Roomer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class RoomerDAO implements DAOi<Roomer> {
    dbConnector connector = new dbConnector();

    private static final String SELECT_ALL_ROOMERS = "SELECT * FROM roomer;";
    private static final String INSERT_ROOMER = "INSERT INTO roomer" + "  (FIRST_NAME, SECOND_NAME, AGE, NATIONALITY) VALUES " + " (?, ?, ?, ?);";
    private static final String DELETE_ROOMER_BY_ID = "DELETE FROM roomer WHERE ID = ?;";
    private static final String SELECT_ROOMER_BY_ID = "SELECT * FROM roomer WHERE id = ?;";
    private static final String UPDATE_ROOMER = "UPDATE roomer SET first_name = ?, second_name = ?, age = ?, nationality = ? where id = ?;";

    @Override
    public List<Roomer> getAll() {
        List<Roomer> tenantsList = new ArrayList<>();
        try (Connection connection = connector.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(SELECT_ALL_ROOMERS)
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String first_name = rs.getString("first_name");
                String second_name = rs.getString("second_name");
                int age = rs.getInt("age");
                String nationality = rs.getString("nationality");
                Roomer roomer = new Roomer(id, first_name, second_name, age, nationality);
                tenantsList.add(roomer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tenantsList;
    }

    @Override
    public void add(Roomer roomer) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_ROOMER)
        ) {
            statement.setString(1, roomer.getFirst_name());
            statement.setString(2, roomer.getSecond_name());
            statement.setInt(3, roomer.getAge());
            statement.setString(4, roomer.getNationality());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBy(int id) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ROOMER_BY_ID)
        ) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Roomer findBy(int id) {
        Roomer roomer = null;
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ROOMER_BY_ID)
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                roomer = new Roomer(rs.getInt("id"), rs.getString("first_name"), rs.getString("second_name"), rs.getInt("age"), rs.getString("nationality"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomer;
    }

    //gets Room roomer from servlet
    public void updateRoomer(Roomer roomer) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ROOMER)
        ) {
            statement.setString(1, roomer.getFirst_name());
            statement.setString(2, roomer.getSecond_name());
            statement.setInt(3, roomer.getAge());
            statement.setString(4, roomer.getNationality());
            statement.setInt(5, roomer.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
