package zuozhen;

public class 面试题25_合并两个排序的链表 {
    /*
    输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍是递增排序的。
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
        /*
        简单思路：递归
         */
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list2.next, list1);
            return list2;
        }
    }
}
