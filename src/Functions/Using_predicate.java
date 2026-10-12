
package Functions;

import java.util.function.Predicate;

public class Using_predicate {
    public static void main(String[] args) {

        Predicate<Integer> checkEven = n -> n % 2 == 0;

        System.out.println(checkEven.test(10));
        System.out.println(checkEven.test(7));
    }
}
