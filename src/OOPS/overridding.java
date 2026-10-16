package OOPS;

/*class Parent1 {

    void display() {
        System.out.println("Parent class");
    }
}
// Child class child ke reference se parent class ke method ko nhi call kr skte

public class overridding extends Parent1 {

    @Override
    void display() {
        System.out.println("Child class");
    }

    public static void main(String[] args) {

        overridding obj = new overridding();

        obj.display();
    }
}

 */


// Parent class
class Parent1 {

    void display() {
        System.out.println("Parent method");
    }
}

// Child class
public class overridding extends Parent1 {

    // Parent ke display() ko override kar rahe hain
    @Override
    void display() {
        System.out.println("Child method");

        // Parent class ke overridden method ko call karna
        super.display();
    }

    public static void main(String[] args) {

        // Child class ka object
        overridding obj = new overridding();

        // Child ka display() call hoga
        obj.display();
    }
}
