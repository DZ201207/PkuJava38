class MyStack {
    
    //����������q1��q2ʵ��һ��ջ��pushʱ����Ԫ����ӵ�q1�Ķ�β��popʱ��q1�г����һ��Ԫ���������ӵ�q2�У�Ȼ��pop��q1�е����һ��Ԫ�أ�Ȼ��ע��ǵ�q1��q2���Ա�֤�������Ԫ��ʱʼ����q1����ӡ�top�ĵ������ơ�
    
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
            //������һ��Ԫ��ȫ����q1���Ƴ�������q2��
            q2.offer(q1.poll());
        }
        //q1�����һ��Ԫ���Ƴ�
        q1.poll();
        //��q2��q1��q2��Ϊ��
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
        //�ٰ�x����q2
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