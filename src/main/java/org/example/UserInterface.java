package org.example;

import java.util.List;

public interface UserInterface {
    String getName();

    String getSurname();

    double getWealth();

    String toString();

    void printCars(List<Car> cars);
}
