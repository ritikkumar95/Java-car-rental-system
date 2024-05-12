import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Author: Ritik Kumar

// CarRentalSystem class managing car rental operations
class CarRentalSystem{
    // Lists to store cars, customers, and rentals
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    // Constructor to initialize lists
    public CarRentalSystem(){
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    // Method to add a car to the system
    public void addCar(Car car){
        cars.add(car);
    }

    // Method to add a customer to the system
    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    // Method to rent a car
    public void rentCar(Car car, Customer customer, int days){
        if(car.isAvailable()){
            car.rent();
            rentals.add(new Rental(car, customer, days));
        }
        else{
            System.out.println("Sorry, Car is not available for rent ");
        }
    }

    // Method to return a rented car
    public void returnCar(Car car){
        Rental rentalToRemove = null;

        for(Rental rental : rentals){
            if(rental.getCar() == car){
                rentalToRemove = rental;
                break;
            }
        }

        if(rentalToRemove != null){
            rentals.remove(rentalToRemove);
            car.returnCar();
        }
        else{
            System.out.println("Car was not rented");
        }
    }

    // Method to display the menu and handle user input
    public void menu(){
        Scanner keyboard = new Scanner(System.in);
        while(true){
            System.out.println(" Welcome to Car Rental System\n Author: Ritik Kumar");
            System.out.println("Enter 1 to rent a car. \nEnter 2 to return a car \nPress 3 to exit this menu");
            System.out.println("Enter your choice:");
            int choice = keyboard.nextInt();
            keyboard.nextLine();

            if(choice == 1){
                System.out.println("Rent a car");
                System.out.println("Enter your name:");

                String customerName = keyboard.nextLine();
                System.out.println("Enter the car ID to rent the car:");
                String carId = keyboard.nextLine();
                System.out.println("Enter the number of days of rental:");
                int rentalDays = keyboard.nextInt();
                keyboard.nextLine();

                Customer newCustomer = new Customer("cUS" + (customers.size() + 1), customerName);
                addCustomer(newCustomer);

                Car selectedCar = null;

                for(Car car : cars){
                    if(car.getCarId().equals(carId) && car.isAvailable()){
                        selectedCar = car;
                        break;
                    }
                }

                if(selectedCar != null){
                    double totalPrice = selectedCar.calculatePrice(rentalDays);
                    System.out.println("Rental Information");
                    System.out.println("Customer ID: " + newCustomer.getCustomerId());
                    System.out.println("Customer Name: " + newCustomer.getName());
                    System.out.println("Car: " + selectedCar.getBrand() + " " + selectedCar.getModel());
                    System.out.println("Rental days: " + rentalDays);
                    System.out.println("Total price: " + totalPrice);
                    System.out.println("Confirm rental (Y/N): ");
                    String confirm = keyboard.nextLine();

                    if(confirm.equalsIgnoreCase("Y")){
                        rentCar(selectedCar, newCustomer, rentalDays);
                        System.out.println("Car rental success!");
                    }
                    else{
                        System.out.println("Rental cancelled");
                    }
                }
                else{
                    System.out.println("Invalid selection or car is not available for rent!");
                }
            }
            else if(choice == 2){
                System.out.println("Return a car");
                System.out.println("Enter the car ID to return:");
                String carId = keyboard.nextLine();
                Car carToReturn = null;

                for(Car car : cars){
                    if(car.getCarId().equals(carId) && !car.isAvailable()){
                        carToReturn = car;
                        break;
                    }
                }

                if(carToReturn != null){
                    Customer customer = null;
                    for(Rental rental : rentals){
                        if(rental.getCar() == carToReturn){
                            customer = rental.getCustomer();
                            break;
                        }
                    }
                    if(customer != null){
                        returnCar(carToReturn);
                        System.out.println("Car return success by " + customer.getName());
                    }
                    else{
                        System.out.println("Car was not returned or rental information is missing");
                    }
                }
                else{
                    System.out.println("Invalid car ID or car is not rented");
                }
            }
            else if(choice == 3){
                System.out.println("Exited! Thank you");
                break;
            }
            else{
                System.out.println("Invalid choice, Try Again");
            }
        }
        System.out.println("Thank you for using my program!");
    }
}
