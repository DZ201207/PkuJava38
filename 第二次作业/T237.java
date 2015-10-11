package excise;

public class T237 {
	
	  public class ListNode {
	     int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	 
	public static void deleteNode(ListNode node) {
        if (node==null) 
			return;
        node.val = node.next.val;
        node.next = node.next.next;
        
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
