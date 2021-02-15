package zuozhen;

public class 面试题24_反转链表 {
    /*
    定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点；
     */
    public ListNode ReverseList(ListNode head) {
        /*
        经典解法
        重开一个链表，遍历原链表，每次将节点插入头部
         */
//        ListNode reverse = new ListNode(-1);
//        ListNode p = head;
//        while (p != null) {
//            ListNode cur = new ListNode(p.val);
//            cur.next = reverse.next;
//            reverse.next = cur;
//            p = p.next;
//        }
//        return reverse.next;
        //尝试不重新new节点
        ListNode reverse = null;
        ListNode p = head;
        ListNode pre = null;
        while (p != null) {
            ListNode next = p.next;
            if (next == null)//尾节点即为头节点
                reverse = p;
            p.next = pre;
            pre = p;
            p = next;
        }
        return reverse;
    }
}
