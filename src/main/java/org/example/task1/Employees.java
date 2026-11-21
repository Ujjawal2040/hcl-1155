
package org.example.task1;

public class Employees {
    private Address address;
    private Salary salary;

    public Employees(Address address, Salary salary) {
        this.address = address;
        this.salary = salary;
    }

    public void display() {
        System.out.println("Employee Details:");
        address.displayAddress();
        salary.displaySalary();
    }
}
