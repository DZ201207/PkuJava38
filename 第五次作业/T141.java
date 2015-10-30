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
        ListNode slow = head;//��Head�ڵ㿪ʼ
        ListNode fast = head;//��Head�ڵ㿪ʼ
        //Fast��Slow�������������˵���л�
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;//slow�������ٶ�
            if(slow == fast)
                return true;
        }
        return false;
    }
}