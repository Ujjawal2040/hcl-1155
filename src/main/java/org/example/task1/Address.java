
package org.example.task1;

public class Address {
    private String city;
    private String state;

    public Address() {
        this.city = "Ghaziabad";
        this.state = "Uttar Pradesh";
    }

    public void displayAddress() {
        System.out.println("City: " + city);
        System.out.println("State: " + state);
    }
}
