// Author: Ritik Kumar

// Rental class representing a rental transaction
class Rental{
    // Private fields to store car, customer, and number of rental days
    private Car car;
    private Customer customer;
    private int days;

    // Constructor to initialize a rental transaction with a car, customer, and number of days
    public Rental(Car car , Customer customer, int days){
        this.car = car;
        this.customer = customer;
        this.days = days;
    }

    // Getter method to retrieve the rented car
    public Car getCar(){
        return car;
    }

    // Getter method to retrieve the renting customer
    public Customer getCustomer(){
        return customer;
    }

    // Getter method to retrieve the number of rental days
    public int getDays(){
        return days;
    }
}
