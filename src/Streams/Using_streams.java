
package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Using_streams {
    public static void main(String[] args) {

        ArrayList<Integer> lis = new ArrayList<>();

        lis.add(10);
        lis.add(15);
        lis.add(20);
        lis.add(25);
        lis.add(30);

        // 1. Print all elements
        lis.stream().forEach(System.out::println);

        // 2. Filter even numbers
        List<Integer> even = lis.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("Even numbers: " + even);

        // 3. Square every element
        List<Integer> squares = lis.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());

        System.out.println("Squares: " + squares);

        // 4. Count elements
        long count = lis.stream().count();
        System.out.println("Count: " + count);
    }
}
