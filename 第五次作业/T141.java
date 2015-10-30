/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;//从Head节点开始
        ListNode fast = head;//从Head节点开始
        //Fast，Slow如果会相遇，则说明有环
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;//slow两倍的速度
            if(slow == fast)
                return true;
        }
        return false;
    }
}