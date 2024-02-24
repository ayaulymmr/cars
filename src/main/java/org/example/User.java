package org.example;

import java.util.List;

public class User implements UserInterface {
    private int id;
    private String name;
    private String surname;
    private double wealth;

    public User(String name, String surname, double wealth) {
        this.name = name;
        this.surname = surname;
        this.wealth = wealth;
    }

    public User(int id, String name, String surname, double wealth) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.wealth = wealth;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public double getWealth() {
        return wealth;
    }

    @Override
    public String toString() {
        return this.id + ". " + name + " " + surname + ", wealth: " + wealth;
    }

    @Override
    public void printCars(List<Car> cars) {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println();
        if (cars.isEmpty())
            System.out.println("No cars found for this user.");
        stringBuilder.append("Cars owned by " + this.getName() + " " + this.getSurname() + ":\n");
        for (Car car : cars)
            stringBuilder.append(car.toString()).append(";\n");
        System.out.println(stringBuilder.toString());

    }
}
