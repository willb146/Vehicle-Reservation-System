# Vehicle-Reservation-System
A Java application that manages vehicle reservations, built using object-oriented programming (OOP) principles. Developed in BlueJ as part of a university coursework project. This program models customers, vehicles and reservations whilst applying inheritance, encapsulation and polymorphism.

#Overview:

This application allows users to:
- View available vehicles (Cars, Vans, Trucks)
- Add and manage customer details
- Make and track reservations
- Store and retrieve data using file utilities
- Test functionality through a dedicated Test class

#Class Structures:

- Vehicle: Base class for all vehicle types, containing shared attributes like make, model, and registration
- Car, Van, Truck, Commercial: Subclasses of the Vehicle class that implements type-specific features
- Customer: Represents customer data and contact information
- VehicleReservation: Manages reservation details, linking customers to vehicles and reservation dates
- ReservationSystem: Main logic class controlling the overall system and operations
- Diary: Keeps track of booked and available vehicles for certain dates
- DataUtil: Handles data persistence and file operations (saving/loading data)
- Test: Contains test cases to verify the systems functions

#What I learned:
- Designing and implementing a class hierarchy using inheritance
- Applying OOP principles in a system
- Managing relationships between objects such as Customer with Vehicle
- Handling file I/O in Java for data persistence
- Writing and organizing code for testing allowing it to be maintained

#Technology Used:

- Java
- BlueJ IDE

#Notes:
- This project was developed for educational purposes only as part of a university software engineering module
