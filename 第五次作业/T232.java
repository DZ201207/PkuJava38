class MyQueue {
    //两个栈就可以模拟一个队列，基本思路是两次后进先出 = 先进先出，元素入队列总是入A栈，元素出队列如果B栈不为空直接弹出B栈头元素如果B栈为空就把A栈元素出栈全部压入B栈，再弹出B栈头，这样就模拟出了一个队列。核心就是保证每个元素出栈时都经过了A，B两个栈，这样就实现了两次后进先出=先进先出。
    
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    // Push element x to the back of queue.
    public void push(int x) {
         s1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        //如果s2不为空，则直接出栈s2的栈顶
        if(!s2.isEmpty()) s2.pop();
        //否则就把A栈全部出栈压入B栈，在把s2栈顶出栈
        else {
            while(!s1.isEmpty()) s2.push(s1.pop());
            s2.pop();
        }
    }

    // Get the front element.
    public int peek() {
        if(!s2.isEmpty()) return s2.peek();
        else {
            while(!s1.isEmpty()) s2.push(s1.pop());
            return s2.peek();
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}