package OOPS;

class Parent {

    void displayParent() {
        System.out.println("I am Parent");
    }
}

public class Inheritance extends Parent {

    void displayChild() {
        System.out.println("I am Child");
    }

    public static void main(String[] args) {

        Inheritance obj = new Inheritance();

        // Parent class method
        obj.displayParent();

        // Child class method
        obj.displayChild();
    }
}