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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode f = l1, s = l2;
        ListNode head = null, curr = head;
        int carry = 0;
        while (s != null && f != null) {
            carry = carry + s.val + f.val;
            ListNode p = new ListNode(carry%10);
            carry /= 10;
            if (head == null) {
                head = p;
                curr = p;
            } else {
                curr.next = p;
                curr = curr.next;
            }
            s = s.next;
            f = f.next;
        }


        while (s!=null) {
            carry = carry + s.val;
            ListNode p = new ListNode(carry%10);
            carry /= 10;
            if (head == null) {
                head = p;
                curr = p;
            } else {
                curr.next = p;
                curr = curr.next;
            }
            s = s.next;
        }

        while (f!=null) {
            carry = carry + f.val;
            ListNode p = new ListNode(carry%10);
            carry /= 10;
            if (head == null) {
                head = p;
                curr = p;
            } else {
                curr.next = p;
                curr = curr.next;
            }
            f = f.next;
        }

        while (carry>0) {
            ListNode p = new ListNode(carry%10);
            carry /= 10;
            if (head == null) {
                head = p;
                curr = p;
            } else {
                curr.next = p;
                curr = curr.next;
            }
        }

        return head;
    }
}