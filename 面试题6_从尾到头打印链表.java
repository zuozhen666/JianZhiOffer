package zuozhen;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class 面试题6_从尾到头打印链表 {
    /*
    输入一个链表的头节点，从尾到头反过来打印出每个节点的值
     */
    /*
    牛客AC代码：
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        /*
        思路一：利用ArrayList里的add方法，遍历链表，每次将节点的值插入集合第0位
            其实就是一个栈的思想
         */
//        ArrayList<Integer> ans = new ArrayList<Integer>();
//        if (listNode == null) return ans;
//        ListNode p = listNode;
//        while (p != null) {
//            ans.add(0, p.val);
//            p = p.next;
//        }
//        return ans;
        /*
        思路二：既然用到栈的思想，那么递归也可
         */
        ArrayList<Integer> ans = new ArrayList<>();
        if (listNode != null) {
            ans.addAll(printListFromTailToHead(listNode.next));
            ans.add(listNode.val);
        }
        return ans;
        /*
        其他思路：直接利用栈结构，使用头插法构建新的链表等等
         */
    }
}
