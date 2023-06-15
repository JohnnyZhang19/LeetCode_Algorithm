public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(0, head);
        ListNode fast = newHead, slow = newHead;
        for(int i=1; i<=n; i++){
            fast = fast.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return newHead.next;
    }
}
