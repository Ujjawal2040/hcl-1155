
package Collection_Framework;

import java.util.ArrayList;
import java.util.Iterator;

public class Iterator_use {
    public static void main(String[] args) {

        // Create ArrayList and add 5 names
        ArrayList<String> names = new ArrayList<>();

        names.add("Ujjawal");
        names.add("Rahul");
        names.add("Aman");
        names.add("Siddhant");
        names.add("Rohit");

        // Print names using Iterator
        Iterator<String> itr = names.iterator();

        System.out.println("Names:");
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // Remove a name using a condition
        itr = names.iterator();

        while (itr.hasNext()) {
            String name = itr.next();

            if (name.equals("Aman")) {
                itr.remove();
            }
        }

        // Print updated ArrayList
        System.out.println("After removal: " + names);
    }
}
