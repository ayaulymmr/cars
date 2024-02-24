package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface DatabaseConnection {
    ResultSet executeQuery(String query) throws SQLException;

    void close();

    Connection getConnection();
}
