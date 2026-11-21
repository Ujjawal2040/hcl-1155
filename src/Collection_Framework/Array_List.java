package Collection_Framework;

import java.util.ArrayList;

public class Array_List {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        // Add 10 elements
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        // Update two elements
        list.set(2, 100);
        list.set(5, 200);

        // Print updated elements
        System.out.println("First updated element: " + list.get(2));
        System.out.println("Second updated element: " + list.get(5));

        // Print complete ArrayList
        System.out.println("Complete ArrayList: " + list);
    }
}