package com.havryliak.DBconnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnector {

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String jdbcURL = "jdbc:h2:D:\\EpamProject\\taras_havryliak\\db\\new";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "root";

    public Connection getConnection() {
        Connection jdbcConnection = null;
        try {
            Class.forName(DB_DRIVER);
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return jdbcConnection;
    }
}
