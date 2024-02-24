package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarRepository implements CarRepositoryInterface {
    private DatabaseConnection database;

    public CarRepository(DatabaseConnection database) {
        this.database = database;
    }

    @Override
    public void creation(Car cars) {
        try {
            String sql = "INSERT INTO cars (brand, model, price, equipment) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = database.getConnection().prepareStatement(sql);
            statement.setString(1, cars.getBrand());
            statement.setString(2, cars.getModel());
            statement.setDouble(3, cars.getPrice());
            statement.setString(4, cars.getComplication());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> carList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM cars";
            PreparedStatement statement = database.getConnection().prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String brand = result.getString("brand");
                String model = result.getString("model");
                double price = result.getInt("price");
                String equipment = result.getString("equipment");
                Car car = new Car(id, brand, model, price, equipment);
                carList.add(car);
            }
            result.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return carList;
    }

    @Override
    public Car getCar(int carId) {
        try {
            String sql = "SELECT brand, model, price, equipment FROM cars";
            PreparedStatement statement = database.getConnection().prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int id = result.getInt("id");
                String brand = result.getString("brand");
                String model = result.getString("model");
                double price = result.getDouble("price");
                String equipment = result.getString("equipment");
                Car car = new Car(id, brand, model, price, equipment);

                return car;
            }
            result.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Car> getCarsByUser(int userId) {
        List<Car> carList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM cars WHERE userId = ?";
            PreparedStatement statement = database.getConnection().prepareStatement(sql);
            statement.setInt(1, userId);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String brand = result.getString("brand");
                String model = result.getString("model");
                double price = result.getDouble("price");
                String complication = result.getString("complication");

                Car car = new Car(id, brand, model, price, complication);
                carList.add(car);
            }
            result.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return carList;
    }
}
