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
        ListNode root = new ListNode();
        ListNode ans = root;
        int sum = l1.val + l2.val;
        l1 = l1.next;
        l2 = l2.next;
        while ((sum != 0 || l1 != null || l2 != null) || ans.next == null) {
            root.next = new ListNode(sum % 10);
            sum /= 10;
            root = root.next;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
        }
        return ans.next;
    }
}