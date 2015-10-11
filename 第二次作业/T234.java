package excise;

public class T234 {
	 
	 
		public static boolean isPalindrome(ListNode head) {
			if (head==null) {
				return true;
			}
			int n = 0;
			for (ListNode i = head; i!=null; i=i.next)
				n++;
			//System.out.println("n="+n);
			int k =n;
			n = (n%2==1)?n/2+1:n/2;//判断n奇偶
			
	        ListNode medium = head;
	        for (int i = 0; i <n-1; i++) {
				medium = medium.next;
			}
	        if (k>3) {
				ListNode temp = medium.next.next;
		        ListNode tail = medium.next;
		        tail.next=null;
		        
		        while(temp!=null){
					tail=temp;
					temp=temp.next;
					tail.next=medium.next;
					medium.next = tail;
				}
		        
			}
//	        for(ListNode p =head;p!=null;p=p.next)
//	        	System.out.println("p= "+p.val);
	        
	        medium=medium.next;
//	        System.out.println("medium="+medium.val);
	        ListNode first = head;
	        for (; medium!=null; ) {
				if (first.val!=medium.val) {
					return false;
				}
				first=first.next;
				medium = medium.next;
			}
	        return true;
	    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode listNode = new ListNode(1);
		listNode.next = new ListNode(2);
		listNode.next.next = new ListNode(3);
		listNode.next.next.next = new ListNode(2);
		listNode.next.next.next.next = new ListNode(1);
		System.out.println(isPalindrome(listNode));
		
	}

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
