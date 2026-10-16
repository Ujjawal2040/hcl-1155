
package OOPS;

class call {
    static int count = 0;

    // Constructor
    call() {
        count++;
    }
}

public class Instance_count extends call {

    public static void main(String[] args) {
        call obj1 = new call();
        call obj2 = new call();
        call obj3 = new call();
        call obj4 = new call();

        System.out.println("Total objects created: " + call.count);
    }
}
