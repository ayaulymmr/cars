package org.example;

import java.sql.SQLException;
import java.util.List;

public interface UserRepositoryInterface {
    void creation(User user) throws SQLException;

    List<User> getAllUsers() throws SQLException;

    User getUser(int userId) throws SQLException;
}