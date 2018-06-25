package interview;

public class QLinkedLists {

    public static void main(String [ ] args){

    }

    //Question: Given a singly linked list, determine if it is a palindrome.
    //
    //This can be solved by reversing the 2nd half and compare the two halves. Let's start with an example [1, 1, 2, 1].
    //In the beginning, set two pointers fast and slow starting at the head.
    //(1) Move: fast pointer goes to the end, and slow goes to the middle.
    //(2) Reverse: the right half is reversed, and slow pointer becomes the 2nd head.
    //(3) Compare: run the two pointers head and slow together and compare.
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    //Question: Reverse a singly linked list.
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        while( curr!=null){
            ListNode next = curr.next;
            curr.next= prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }



    //Question: Given a linked list, remove the n-th node from the end of list and return its head.
    //
    //A one pass solution can be done using pointers. Move one pointer fast --> n+1 places forward,
    // to maintain a gap of n between the two pointers and then move both at the same speed. Finally,
    // when the fast pointer reaches the end, the slow pointer will be n+1 places behind - just the right spot for it to be able to skip the next node.
    //
    //Since the question gives that n is valid, not too many checks have to be put in place. Otherwise,
    // this would be necessary.
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }

    public class ListNode {
        int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

}
