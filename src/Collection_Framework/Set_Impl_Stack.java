
package Collection_Framework;

import java.util.Stack;

public class Set_Impl_Stack {
    public static void main(String[] args) {

        // Create a Stack
        Stack<Integer> st = new Stack<>();

        // Push elements into the stack
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);

        System.out.println("Stack: " + st);

        // View the top element
        System.out.println("Top element: " + st.peek());

        // Remove the top element
        System.out.println("Popped element: " + st.pop());

        // Stack after removal
        System.out.println("Stack after pop: " + st);

        // Search for an element (1-based position from the top)
        System.out.println("Position of 20: " + st.search(20));

        // Check whether the stack is empty
        System.out.println("Is empty: " + st.empty());
    }
}
