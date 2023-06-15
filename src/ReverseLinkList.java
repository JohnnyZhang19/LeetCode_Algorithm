import java.util.Stack;

public class ReverseLinkList {
    public ListNode reverseList(ListNode head) {
        return reverse(head,null) ;
    }

    public ListNode reverse(ListNode head, ListNode newHead){
        //base or break condition
        if(head==null){
            return newHead;
        }
        ListNode next = head.next;
        head.next=newHead;
        newHead=head;
        head=next;
        return reverse(head,newHead);
    }
}
