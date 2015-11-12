package excise;

public class T83 {
	    public static ListNode deleteDuplicates(ListNode head) {
	    	if (head==null || head.next==null)
				return head;
			
	    	ListNode p1 =head;
	    	ListNode p2=head.next;
	    	while (p2!=null) {
	    		if (p2.val==p1.val) {
					p1.next=p2.next;
					p2=p2.next;
				}else {
					p2=p2.next;
					p1=p1.next;
				}
			}
//	    	for (p1 = head; p1!=null; p1=p1.next) {
//				System.out.println(p1.val);
//			}
	        return head;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode p1 = new ListNode(1);
		p1.next = new ListNode(1);
		p1.next.next = new ListNode(2);
		p1.next.next.next=null;
		deleteDuplicates(p1);
	}

}
