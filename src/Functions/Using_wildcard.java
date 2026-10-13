
package Functions;

import java.util.*;

public class Using_wildcard {

    public static void printList(List<?> list) {
        for (Object x : list) {
            System.out.println(x);
        }
    }

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 20, 30);
        List<String> names = Arrays.asList("Aman", "Rahul", "Ujjawal");

        printList(numbers);
        printList(names);
    }
}
