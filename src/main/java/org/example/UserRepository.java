package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements UserRepositoryInterface {
    User user = null;
    private DatabaseConnection database;

    public UserRepository(DatabaseConnection database) {
        this.database = database;
    }

    @Override
    public void creation(User user) {
        try {
            String sql = "INSERT INTO users (name, surname, wealth) VALUES (?, ?, ?)";
            PreparedStatement statement = database.getConnection().prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setDouble(3, user.getWealth());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM users";
            PreparedStatement statement = database.getConnection().prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                double wealth = result.getDouble("wealth");
                String surname = result.getString("surname");
                String name = result.getString("name");
                int id = result.getInt("id");
                User user = new User(id, name, surname, wealth);
                userList.add(user);
            }
            result.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return userList;
    }

    @Override
    public User getUser(int userId) {
        try {
            String sql = "SELECT * FROM users WHERE id = ?";
            PreparedStatement statement = database.getConnection().prepareStatement(sql);
            statement.setInt(1, userId);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String surname = result.getString("surname");
                double wealth = result.getDouble("wealth");
                User user = new User(id, name, surname, wealth);

                return user;
            }
            result.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return null;
    }
}