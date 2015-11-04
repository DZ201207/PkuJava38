package excise;

import java.util.LinkedList;
import java.util.Queue;

public class T225 {
	Queue<Integer> q = new LinkedList<Integer>();
	 // Push element x onto stack.
    public void push(int x) {
        q.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
    	int n = q.size();
    	if (n==0) {
			return;
		}
    	int temp;
    	for (int i = 0; i < n-1; i++) {
			temp = q.remove();
			q.add(temp);
		}
        q.remove();
    }

    // Get the top element.
    public int top() {
    	int n = q.size();
    	int temp;
    	for (int i = 0; i < n-1; i++) {
			temp = q.remove();
			q.add(temp);
		}
    	n = q.peek();
    	temp = q.remove();
		q.add(temp);
        
       return n;	 
    }

    // Return whether the stack is empty.
    public boolean empty() {
       return q.isEmpty();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		System.out.println(q.remove());

	}

}
