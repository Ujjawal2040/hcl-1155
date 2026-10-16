package OOPS;

public class constructor_overloading {

    String name;
    int roll_number;

    // Constructor 1: No arguments
    constructor_overloading() {
        name = "Unknown";
        roll_number = 0;
    }

    // Constructor 2: String argument
    constructor_overloading(String name) {
        this.name = name;
        this.roll_number = 0;
    }

    // Constructor 3: String + int arguments
    constructor_overloading(String name, int roll_number) {
        this.name = name;
        this.roll_number = roll_number;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + roll_number);
    }

    public static void main(String[] args) {

        constructor_overloading s1 = new constructor_overloading();

        constructor_overloading s2 =
                new constructor_overloading("Ujjawal");

        constructor_overloading s3 =
                new constructor_overloading("Ujjawal", 101);

        s1.display();
        s2.display();
        s3.display();
    }
}