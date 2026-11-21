package Collection_Framework;

import java.util.Queue;
import java.util.LinkedList;

public class queue_usinig_LL {
    public static void main(String[] args) {

        // Create Queue using LinkedList
        Queue<Integer> q = new LinkedList<>();

        // Insert elements (enqueue)
        q.offer(10);
        q.offer(20);
        q.offer(30);
        q.offer(40);

        System.out.println("Queue: " + q);

        // Front element
        System.out.println("Front: " + q.peek());

        // Remove elements (dequeue)
        System.out.println("Removed: " + q.poll());
        System.out.println("Queue after removal: " + q);

        // Check size
        System.out.println("Size: " + q.size());

        // Check if empty
        System.out.println("Is Empty: " + q.isEmpty());
    }
}
