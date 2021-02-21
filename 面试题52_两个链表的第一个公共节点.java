package zuozhen;

public class 面试题52_两个链表的第一个公共节点 {
    /*
    牛客AC代码
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        /*
        例如1，2，3，4，null
        5，3，4，null
        两个链表并在一起看：
        1，2，3，4，null，5，3，4，null
        5，3，4，null，1，2，3，4，null
        易知
        */
        if (pHead1 == null || pHead2 == null) return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }
        return p1;
    }
}
