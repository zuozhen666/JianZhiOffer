package zuozhen;

import java.util.HashMap;
import java.util.Map;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class 面试题35_复杂链表的复制 {
    /*
    输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
    另一个特殊指针random指向一个随机节点），请对此链表进行深拷贝，并返回拷贝后的头结点。
    （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     */
    public RandomListNode Clone(RandomListNode pHead) {
        /*
        方法一：
        先按照next顺序复制链表，然后让原节点与对应新节点组成哈希表；
        根据哈希表完善random指针。空间换时间
         */
//        if (pHead == null) return null;
//        Map<RandomListNode, RandomListNode> map = new HashMap<>();
//        RandomListNode p = pHead;
//        RandomListNode q = new RandomListNode(p.label);
//        map.put(p, q);
//        p = p.next;
//        while (p != null) {
//            RandomListNode cur = new RandomListNode(p.label);
//            map.put(p, cur);
//            q.next = cur;
//            q = cur;
//            p = p.next;
//        }
//        p = pHead;
//        q = map.get(p);
//        while (p != null) {
//            q.random = map.get(p.random);
//            q = q.next;
//            p = p.next;
//        }
//        return map.get(pHead);
        /*
        方法二：不需要额外空间
        按照next顺序复制每个节点然后将复制的节点插到原节点后面；
        这样就可以找到random节点了，
        然后把偶数节点连接起来即可。
         */
        if (pHead == null) return null;
        RandomListNode p = pHead;
        while (p != null) {//next
            RandomListNode cur = new RandomListNode(p.label);
            cur.next = p.next;
            p.next = cur;
            p = cur.next;
        }
        p = pHead;
        while (p != null) {//random
            RandomListNode cur = p.next;
            if (p.random != null) {
                cur.random = p.random.next;
            }
            p = cur.next;
        }
        p = pHead;
        RandomListNode copyHead = p.next;
        while (p.next != null) {//divide(分离时每个节点都要考虑到)
            RandomListNode cur = p.next;
            p.next = cur.next;
            p = cur;
        }
        return copyHead;
    }
}
