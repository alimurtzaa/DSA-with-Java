import org.w3c.dom.Node;

import java.util.List;

public class LLQuestions {
    private int size = 0;

    // 1. LinkedList cycle (https://leetcode.com/problems/linked-list-cycle/)
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }

    // 2. Cycle length
    public int CycleLength(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                int count = 0;
                do {
                    slow = slow.next;
                    count++;
                } while (slow != fast);
                return count;
            }
        }

        return 0;
    }

    //3. LinkedList Cycle II (https://leetcode.com/problems/linked-list-cycle-ii/)
    public ListNode detectCycle(ListNode head) {
        int length = 0;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                do {
                    slow = slow.next;
                    length++;
                } while (slow != fast);
                break;
            }
        }
        if (length == 0) return null;

        ListNode f = head;
        ListNode s = head;
        for (int i = 1; i <= length; i++) {
            f = f.next;
        }

        while (f != s){
            f = f.next;
            s = s.next;
        }

        return s;
    }

    //4. Happy Number (https://leetcode.com/problems/happy-number/)
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while (slow != fast);

        if (slow == 1) return true;

        return false;
    }
    private int findSquare (int num){
        int ans = 0;
        while (num > 0){
            int digit = num % 10;
            ans += digit * digit;
            num /= 10;
        }
        return ans;
    }

    //5. Finding Middle Node
    public ListNode middleNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //6. Sort List (https://leetcode.com/problems/sort-list/)
    // merge sort
    public ListNode sortList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }
    private ListNode merge (ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
                tail.next = l2;
                l2 = l2.next;
            } else {
                tail.next = l1;
                l1 = l1.next;
            }
            tail = tail.next;
        }

        tail.next = (l1 != null) ? l1 : l2;
        return dummyHead.next;
    }
    private ListNode getMid (ListNode head){
        ListNode s = head;
        ListNode f = head;
        ListNode prev = null;
        while (f != null && f.next != null){
            prev = s;
            s = s.next;
            f = f.next.next;
        }
        prev.next = null; // breaking list
        return s;
    }

    //7. Inplace reversal (https://leetcode.com/problems/reverse-linked-list/)
    public ListNode reverse(ListNode head){
        if (head == null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode forward = curr.next;
        while (curr != null){
            curr.next = prev;
            prev = curr;
            curr = forward;
            if (forward != null){
                forward = forward.next;
            }
        }
        head = prev;
        return head;
    }

    //8. reverse linked list II ()
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;

        ListNode curr = head;
        ListNode prev = null;

        //move curr to left-1
        for (int i = 0; curr != null && i < left-1; i++) {
            prev = curr;
            curr = curr.next;
        }
        ListNode last = prev;
        ListNode newEnd = curr;

        // reversing
        ListNode forward = curr.next;
        for (int i = 0; curr != null && i < right - left + 1 ; i++) {
            curr.next = prev;
            prev = curr;
            curr = forward;
            if (forward != null){
                forward = forward.next;
            }
        }
        if (last != null){
            last.next = prev;
        }else{
            head = prev;
        }
        newEnd.next = curr;
        return head;
    }

    class ListNode {
      int val;
      ListNode next;

        public ListNode() {
        }

        ListNode(int x) {
          val = x;
          next = null;
      }
    }
}
