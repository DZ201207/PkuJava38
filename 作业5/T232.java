package excise;

import java.util.Stack;

public class T232 {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	 // Push element x to the back of queue.
    public void push(int x) {
        stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
        stack2.pop();
        while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
    }

    // Get the front element.
    public int peek() {
    	 while (!stack1.isEmpty()) {
 			stack2.push(stack1.pop());
 		}
         int k =stack2.peek();
         while (!stack2.isEmpty()) {
 			stack1.push(stack2.pop());
 		}
         return k;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.isEmpty();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
