
package Collection_Framework;

import java.util.Deque;
import java.util.ArrayDeque;

public class Queue_impl_Dequeue {
    public static void main(String[] args) {

        // Create a Deque
        Deque<Integer> dq = new ArrayDeque<>();

        // Add elements at the front and rear
        dq.addFirst(20);
        dq.addFirst(10);
        dq.addLast(30);
        dq.addLast(40);

        System.out.println("Deque: " + dq);

        // Get first and last elements
        System.out.println("First element: " + dq.getFirst());
        System.out.println("Last element: " + dq.getLast());

        // Remove elements from both ends
        System.out.println("Removed from front: " + dq.removeFirst());
        System.out.println("Removed from rear: " + dq.removeLast());

        // Final Deque
        System.out.println("Deque after removal: " + dq);

        // Check size and emptiness
        System.out.println("Size: " + dq.size());
        System.out.println("Is empty: " + dq.isEmpty());
    }
}
