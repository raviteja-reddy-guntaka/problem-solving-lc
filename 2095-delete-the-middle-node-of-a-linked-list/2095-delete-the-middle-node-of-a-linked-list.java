/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        
        if ((head == null) || (head.next == null))
            return null;
        
        ListNode s = head, f = head, prev = s;
        while(f.next != null && f.next.next != null) {
            prev = s;
            s = s.next;
            f = f.next.next;
        }
        
        if (f.next == null) {
            prev.next = s.next;
            s.next = null;
            return head;
        }
        
        s.next = s.next.next;
        return head;
        
    }
}