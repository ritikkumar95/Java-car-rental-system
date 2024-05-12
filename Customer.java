// Author: Ritik Kumar

// Customer class representing a customer
public class Customer{
    // Private fields to store customer ID and name
    private String customerId;
    private String name;

    // Constructor to initialize a customer with a customer ID and name
    public Customer(String customerId, String name){
        this.customerId = customerId;
        this.name = name;
    }

    // Getter method to retrieve the customer ID
    public String getCustomerId(){
        return customerId;
    }

    // Getter method to retrieve the customer's name
    public String getName(){
        return name;
    }
}
