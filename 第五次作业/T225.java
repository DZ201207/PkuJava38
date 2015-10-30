class MyStack {
    
    //用两个队列q1，q2实现一个栈。push时把新元素添加到q1的队尾。pop时把q1中除最后一个元素外逐个添加到q2中，然后pop掉q1中的最后一个元素，然后注意记得q1和q2，以保证我们添加元素时始终向q1中添加。top的道理类似。
    
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
         q1.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        
        while(q1.size()>1) 
        {
            //除最后的一个元素全都从q1中移除，插入q2中
            q2.offer(q1.poll());
        }
        //q1的最后一个元素移除
        q1.poll();
        //把q2给q1，q2又为空
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }

    // Get the top element.
    public int top() {
        while(q1.size()>1) {
            q2.offer(q1.poll());
        }
        
        int x = q1.poll();
        //再把x插入q2
        q2.offer(x);
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
        return x;
    }

    // Return whether the stack is empty.
    public boolean empty() {
         return q1.isEmpty();
    }
}