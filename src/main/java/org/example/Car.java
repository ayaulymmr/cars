
package org.example;

public class Car implements CarInterface {
    private int id;
    private String brand;
    private String model;
    private double price;
    private String complication;
    private int userId;

    public Car(int id, String name, String model, double price, String complec) {
        this.id = id;
        this.brand = name;
        this.model = model;
        this.price = price;
        this.complication = complec;
    }

    public Car(String name, String model, double price, String complec) {
        this.brand = name;
        this.model = model;
        this.price = price;
        this.complication = complec;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getComplication() {
        return complication;
    }

    @Override
    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return brand + " " + model + "Equipped with "
                + complication + ". Price: " + price + "$";
    }
}
