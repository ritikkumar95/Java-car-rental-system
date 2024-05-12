// Author: Ritik Kumar

// Main class representing the entry point of the program
public class Main{
    // Main method, starting point of the program
    public static void main(String[] args) {
        // Creating an instance of CarRentalSystem
        CarRentalSystem rentalSystem = new CarRentalSystem();

        // Creating instances of Car with different details
        Car car1 = new Car("C001", "Ford", "Ford Edge", 60.0); // Car with ID C001, make Ford, model Ford Edge, base price $60 per day
        Car car2 = new Car("C002", "Dodge", "Dodge Grand caravan", 100.0); // Car with ID C002, make Dodge, model Dodge Grand Caravan, base price $100 per day
        Car car3 = new Car("C003", "Chevrolet", "Equinox", 150.0); // Car with ID C003, make Chevrolet, model Equinox, base price $150 per day
        
        // Adding the cars to the rental system
        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);

        // Displaying the menu of the rental system
        rentalSystem.menu();
    }
}
