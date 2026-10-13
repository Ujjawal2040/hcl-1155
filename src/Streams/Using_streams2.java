
package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Using_streams2 {
    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();

        names.add("Rahul");
        names.add("Rohit");
        names.add("Raj");
        names.add("Robert");
        names.add("Amit");
        names.add("Rajat");
        names.add("Rit");

        // Filter names starting with R
        List<String> startsWithR = names.stream()
                .filter(name -> name.startsWith("R"))
                .collect(Collectors.toList());

        System.out.println("Names starting with R: " + startsWithR);

        // Filter names ending with t
        List<String> endsWithT = names.stream()
                .filter(name -> name.endsWith("t"))
                .collect(Collectors.toList());

        System.out.println("Names ending with t: " + endsWithT);
    }
}
