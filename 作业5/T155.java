package excise;

import java.util.Stack;

public class T155 {
		private Stack<Integer> stack = new Stack<Integer>();
		private Stack<Integer> min_stack = new Stack<Integer>();
	 	public void push(int x) {
	        if (min_stack.isEmpty() || min_stack.peek()>=x) {
				min_stack.push(x);
			}
	        stack.push(x);
	    }

	    public void pop() {
	        int item = stack.pop();
	        if (min_stack.peek()==item) {
				min_stack.pop();
			}
	    }

	    public int top() {
	        return stack.peek();
	    }

	    public int getMin() {
	        return min_stack.peek();
	    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
