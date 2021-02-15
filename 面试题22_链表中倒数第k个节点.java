package zuozhen;

public class 面试题22_链表中倒数第k个节点 {
    /*
    输入一个链表，输出链表中倒数第k个节点。（最后一个节点为倒数第1个节点）
    /*
    牛客AC代码
     */
    /*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
//    public ListNode FindKthToTail(ListNode head, int k) {
//        /*
//        直观思路，但是需要遍历两次
//         */
//        if (head == null) return null;
//        ListNode p = head;
//        int length = 0;
//        while (p != null) {
//            p = p.next;
//            length++;
//        }
//        if (length < k) return null;
//        p = head;
//        for (int i = 0; i < length - k; i++) {
//            p = p.next;
//        }
//        return p;
//    }

    public ListNode FindKthToTail(ListNode head, int k) {
        /*
        只遍历一次，双指针
         */
        if (head == null || k == 0) return null;
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 0; i < k - 1; i++) {
            if (p1.next != null) {
                p1 = p1.next;
            } else {
                return null;
            }
        }
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
