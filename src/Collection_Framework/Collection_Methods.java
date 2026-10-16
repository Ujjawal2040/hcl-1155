
package Collection_Framework;

import java.util.*;

public class Collection_Methods{
    public static void main(String[] args) {

        Collection<Integer> c = new ArrayList<>();
        Collection<Integer> c2 = new ArrayList<>();

        // 1. add()
        c.add(10);
        c.add(20);
        c.add(30);
        c.add(40);
        System.out.println("add(): " + c);

        // 2. addAll()
        c2.add(20);
        c2.add(30);
        c2.add(50);
        c.addAll(c2);
        System.out.println("addAll(): " + c);

        // 3. size()
        System.out.println("size(): " + c.size());

        // 4. isEmpty()
        System.out.println("isEmpty(): " + c.isEmpty());

        // 5. contains()
        System.out.println("contains(20): " + c.contains(20));

        // 6. containsAll()
        System.out.println("containsAll(): " + c.containsAll(c2));

        // 7. iterator()
        System.out.print("iterator(): ");
        Iterator<Integer> itr = c.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();

        // 8. remove()
        c.remove(10);
        System.out.println("remove(10): " + c);

        // 9. removeAll()
        c.removeAll(c2);
        System.out.println("removeAll(): " + c);

        // Add values again for retainAll()
        c.add(20);
        c.add(30);
        c.add(60);

        // 10. retainAll()
        c.retainAll(c2);
        System.out.println("retainAll(): " + c);

        // 11. removeIf()
        c.removeIf(n -> n == 20);
        System.out.println("removeIf(): " + c);

        // 12. toArray()
        Object[] arr = c.toArray();
        System.out.println("toArray(): " + Arrays.toString(arr));

        // 13. stream()
        System.out.print("stream(): ");
        c.stream().forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 14. parallelStream()
        System.out.print("parallelStream(): ");
        c.parallelStream().forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 15. clear()
        c.clear();
        System.out.println("clear(): " + c);
        System.out.println("isEmpty() after clear: " + c.isEmpty());
    }
}
