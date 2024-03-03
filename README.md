I used Spring Boot, which is a framework in Java, to create the backend. I used Persistence, Java Persistence API, and Lombok to organize databases. In general, we start with the models. In the models folder, there are classes like Car and User.
First, we use decorators. It adds getters and setters to the object properties. So, you don't need to specify them separately; you can call them directly. 
After that, we create a service, which means services and interfaces for services and interfaces for repositories. With the help of the Java Persistence API, we can create a repository.
In general, we create an interface based on it, and then we call it in the service to interact with this data storage object. That is, it includes find all, save, find, and you can also edit, and so on.

After finishing with services for each entity, we create a controller. In the controller, we specify endpoints for each entity.
For example, for creation, for displaying one, all, or searching all cars for a user.

One of our problems was that cars for a user were repeating. That is, if we pull cars for a user once, they start repeating because a user has an array of cars, and a car has a user entity. And in this entity, 
there is another car, and so on indefinitely.

In general, for user functionality, we can show one, show all users, and create a user. For cars, the same applies. Find one car by ID, show all cars, and create a car. 
When purchasing a car, we first check that the car ID for the user is correctly entered, then we buy it, i.e., add it to the user's list of cars and subtract the price. 
When selling, it's the opposite. We pull the car from there and add the car's price
