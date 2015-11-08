/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 public class Solution { 
        public ListNode deleteDuplicates(ListNode head) { 
            if (head == null) 
                return null; 

            for (ListNode pre = head, node = head.next; node != null;) { 
                if (node.val == pre.val) { 
                    pre.next = node.next; 
                    node = node.next; 
                    continue; 
                } 
                pre = node; 
                node = node.next; 
            } 
            return head; 
        } 
    } 
