import java.util.Stack;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
//        Stack<ListNode> stack = new Stack<ListNode> ();
//        ListNode current = head;
//        while (current != null){
//            stack.push (current);
//            current = current.next;
//        }
//        while (head != null){
//            if (head.val != stack.pop ().val){
//                return false;
//            }
//            head = head.next;
//        }
//        return true;
        if (head == null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        ListNode temp = null;
        while (fast != null){
            temp = fast.next;
            fast.next = slow;
            slow = fast;
            fast = temp;
        }
        temp = slow;
        fast = head;
        boolean res = true;
        while (slow != null && fast != null){
            if (slow.val != fast.val) {
                res = false;
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        slow = temp.next;
        temp.next = null;
        while (slow != null){
            fast = slow.next;
            slow.next = temp;
            temp = slow;
            slow = fast;
        }
        return res;
    }
}










