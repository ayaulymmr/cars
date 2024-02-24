package org.example;

import java.sql.SQLException;
import java.util.List;

public interface CarRepositoryInterface {
    void creation(Car car) throws SQLException;

    List<Car> getAllCars() throws SQLException;

    Car getCar(int carId) throws SQLException;

    List<Car> getCarsByUser(int userId) throws SQLException;
}
