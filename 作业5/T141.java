package excise;

import excise.T237.ListNode;

public class T141 {
	 public static boolean hasCycle(ListNode head) {
		   ListNode p1 = head;
		   ListNode p2 = head;
		   if (head ==null) return false;
		   while (p2!=null) 
		   {
			   p1=p1.next;
			   p2=p2.next;
			   if (p2==null) {
				 return false;
			   }
			   p2 = p2.next;
			   if (p1==p2) {
				   return true;
			   }
			
		   }
		   return false;
		 }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}

//  class ListNode {
//       int val;
//       ListNode next;
//       ListNode(int x) {
//          val = x;
//          next = null;
//      }
//  }
