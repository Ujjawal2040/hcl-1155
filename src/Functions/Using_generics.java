
package Functions;

public class Using_generics {

    // Generic method
    public <T> void display(T value) {
        System.out.println(value);
    }

    public static void main(String[] args) {
        Using_generics obj = new Using_generics();

        obj.display(100);        // Integer
        obj.display("Hello");    // String
        obj.display(10.5);       // Double
    }
}
