
package OOPS;

import java.util.*;

public class Linked_List {
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();

        // 1. add()
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        System.out.println("add(): " + list);

        // 2. addAll()
        list2.add(20);
        list2.add(30);
        list2.add(50);
        list.addAll(list2);
        System.out.println("addAll(): " + list);

        // 3. size()
        System.out.println("size(): " + list.size());

        // 4. isEmpty()
        System.out.println("isEmpty(): " + list.isEmpty());

        // 5. contains()
        System.out.println("contains(20): " + list.contains(20));

        // 6. containsAll()
        System.out.println("containsAll(): " + list.containsAll(list2));

        // 7. iterator()
        System.out.print("iterator(): ");
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();

        // 8. remove()
        list.remove(Integer.valueOf(10));
        System.out.println("remove(10): " + list);

        // 9. removeAll()
        list.removeAll(list2);
        System.out.println("removeAll(): " + list);

        // Add values again for retainAll()
        list.add(20);
        list.add(30);
        list.add(60);

        // 10. retainAll()
        list.retainAll(list2);
        System.out.println("retainAll(): " + list);

        // 11. removeIf()
        list.removeIf(n -> n == 20);
        System.out.println("removeIf(): " + list);

        // 12. toArray()
        Object[] arr = list.toArray();
        System.out.println("toArray(): " + Arrays.toString(arr));

        // 13. stream()
        System.out.print("stream(): ");
        list.stream().forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 14. parallelStream()
        System.out.print("parallelStream(): ");
        list.parallelStream().forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 15. LinkedList-specific methods
        list.addFirst(100);
        list.addLast(200);
        System.out.println("addFirst() and addLast(): " + list);

        System.out.println("getFirst(): " + list.getFirst());
        System.out.println("getLast(): " + list.getLast());

        list.removeFirst();
        list.removeLast();
        System.out.println("removeFirst() and removeLast(): " + list);

        // 16. clear()
        list.clear();
        System.out.println("clear(): " + list);
        System.out.println("isEmpty() after clear: " + list.isEmpty());

        // 17. Add an element after a given element
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        int target = 20;
        int newElement = 25;
        boolean found = false;

        ListIterator<Integer> li = list.listIterator();

        while (li.hasNext()) {
            int current = li.next();

            if (current == target) {
                li.add(newElement); // Adds after the target element
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("After inserting " + newElement
                    + " after " + target + ": " + list);
        } else {
            System.out.println(target + " not found in the list.");
        }
    }
}
