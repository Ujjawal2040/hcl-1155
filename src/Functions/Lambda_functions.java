
package Functions;

interface Add {
    int sum(int a, int b);
}

public class Lambda_functions {
    public static void main(String[] args) {

        // Lambda expression to implement the sum method
        Add obj = (a, b) -> a + b;

        // Call the method
        System.out.println("Sum: " + obj.sum(10, 20));

        // Lambda expression to print a message
        Runnable r = () -> System.out.println("Hello Java");

        r.run();
    }
}
