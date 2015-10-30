class MyQueue {
    //����ջ�Ϳ���ģ��һ�����У�����˼·�����κ���ȳ� = �Ƚ��ȳ���Ԫ�������������Aջ��Ԫ�س��������Bջ��Ϊ��ֱ�ӵ���BջͷԪ�����BջΪ�վͰ�AջԪ�س�ջȫ��ѹ��Bջ���ٵ���Bջͷ��������ģ�����һ�����С����ľ��Ǳ�֤ÿ��Ԫ�س�ջʱ��������A��B����ջ��������ʵ�������κ���ȳ�=�Ƚ��ȳ���
    
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    // Push element x to the back of queue.
    public void push(int x) {
         s1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        //���s2��Ϊ�գ���ֱ�ӳ�ջs2��ջ��
        if(!s2.isEmpty()) s2.pop();
        //����Ͱ�Aջȫ����ջѹ��Bջ���ڰ�s2ջ����ջ
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