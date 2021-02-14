package zuozhen;

public class 面试题18_删除链表的节点 {
    /*
    在O(1)时间内删除链表节点
    (给定头节点和目标节点)
     */
    /*
    思路：替换值的思想：
    将目标节点next节点的值赋给自己然后删除next节点；
    如果是尾节点就遍历到尾节点前节点处理；
    如果只有一个节点。head直接赋为null
     */
    public ListNode deleteNode(ListNode head, ListNode targetNode) {
        if (head == null || targetNode == null) {
            return null;
        }
        if (targetNode.next != null) {
            targetNode.val = targetNode.next.val;
            targetNode.next = targetNode.next.next;
        } else if (head == targetNode) {
            head = null;
        } else {
            ListNode p = head;
            while (p.next != targetNode) {
                p = p.next;
            }
            p.next = null;
        }
        return head;
    }

    /*
    题目二：删除链表中重复的节点
    在一个排序的链表中，如何删除重复的节点
     */
    /*
    牛客AC代码
     */
    public ListNode deleteDuplication(ListNode pHead) {
        /*
        思路比较简单，遍历即可
         */
        if (pHead == null || pHead.next == null) return pHead;
        ListNode preHead = new ListNode(-1);
        preHead.next = pHead;
        ListNode p = preHead;
        ListNode q = p.next;
        while (true) {
            if (q.next != null && q.val == q.next.val) {
                while (q.next != null && q.val == q.next.val) {
                    q = q.next;
                }
                p.next = q.next;
                q = q.next;
            } else {
                p = q;
                q = q.next;
            }
            if (q == null) break;
        }
        return preHead.next;
    }

    /*
    思路二：递归
     */
    public ListNode deleteDuplication2(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode next = pHead.next;
        if (pHead.val == next.val) {
            while (next != null && pHead.val == next.val)
                next = next.next;
            return deleteDuplication2(next);
        } else {
            pHead.next = deleteDuplication2(pHead.next);
            return pHead;
        }
    }
}