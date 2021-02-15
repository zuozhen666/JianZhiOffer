package zuozhen;

import java.util.HashMap;
import java.util.Map;

public class 面试题23_链表中环的入口结点 {
    /*
    如果一个链表中包含环，如何找出环的入口节点。
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        /*
        最简单：哈希表，但是空间复杂度O(n)
        */
//        if (pHead == null) return null;
//        Map map = new HashMap<ListNode, Integer>();
//        ListNode p = pHead;
//        while (p != null) {
//            if (map.containsKey(p)) return p;
//            map.put(p, 1);
//            p = p.next;
//        }
//        return null;
        /*
        进阶：双指针
        思路：一快一慢指针一定相遇在环内，相遇后将快指针指向头指针然后慢速移动，再次相遇即为所求；
        */
        if (pHead == null || pHead.next == null) return null;
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (slow == fast && slow != null) {
            fast = pHead;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
        return null;
    }
    /*
    另一思路：先求出环的长度（快慢指针相遇点）
    然后可利用如下规律：
    慢指针先走环的长度步数，快指针不动，然后同时开始，相遇节点即为所求。
     */
}
