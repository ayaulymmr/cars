package org.example;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Application {
    String url = "jdbc:postgresql://localhost:5432/Cars";
    String user = "postgres";
    String password = "13579";

    static Scanner scanner = new Scanner(System.in);

    public void start() {
        try {
            DatabaseConnection db = new Database(url, user, password);
            UserRepositoryInterface userRep = new UserRepository(db);
            CarRepositoryInterface carRep = new CarRepository(db);
            List<User> users = userRep.getAllUsers();

            toString();

            while (true) {
                System.out.println();
                System.out.println("Welcome to our Application");
                System.out.println("This table of user, choose one of them ");
                System.out.println("1. Add user");
                System.out.println("2. Add car");
                System.out.println("3. Print table of users");
                System.out.println("4. Print table of cars");
                System.out.println("5. Get cars for a user");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");

                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Enter user details:");
                        System.out.print("Name: ");
                        String name = scanner.next();
                        System.out.print("Surname: ");
                        String surname = scanner.next();
                        System.out.print("Wealth: ");
                        double wealth = scanner.nextDouble();

                        User newUser = new User(name, surname, wealth);
                        userRep.creation(newUser);
                        break;
                    case 2:
                        System.out.println("Enter car details:");
                        System.out.print("Name: ");
                        String carName = scanner.next();
                        System.out.print("Brand: ");
                        String brand = scanner.next();
                        System.out.print("Price: ");
                        double price = scanner.nextDouble();
                        System.out.print("Equipment :");
                        String equipment = scanner.next();

                        Car newCar = new Car(carName, brand, price, equipment);
                        carRep.creation(newCar);
                        break;
                    case 3:
                        System.out.println("Table of Users");
                        for (User user : users)
                            System.out.println(user);
                        break;
                    case 4:
                        System.out.println("Table of Cars");
                        List<Car> cars = carRep.getAllCars();
                        for (Car car : cars)
                            System.out.println(car);
                        break;
                    case 5:
                        System.out.println("Choose the user: ");
                        for (User user : users)
                            System.out.println(user);
                        int userId = scanner.nextInt();
                        User selectedUser = userRep.getUser(userId);
                        if (selectedUser != null) {
                            List<Car> carsByUser = carRep.getCarsByUser(userId);
                            selectedUser.printCars(carsByUser);
                        } else
                            System.out.println("User not found.");
                        break;
                    case 0:
                        System.out.println("Exiting program");
                        scanner.close();
                        db.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
                System.out.print("Continue? (yes/no): ");
                scanner.nextLine();
                String continueChoice = scanner.nextLine().trim();
                continueChoice.toLowerCase();

                if (!continueChoice.equalsIgnoreCase("yes")) {
                    System.out.println("Exiting program.");
                    scanner.close();
                    break;
                }
            }
            db.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}