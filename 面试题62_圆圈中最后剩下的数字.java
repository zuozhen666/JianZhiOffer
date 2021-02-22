package zuozhen;

public class 面试题62_圆圈中最后剩下的数字 {
    /*
    0、1、2、...n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里
    删除第m个数字。求出这个圆圈里剩下的最后一个数字。
     */
    /*
    牛客AC代码（环形链表）
     */
    class Node {
        int val;
        Node next = null;

        Node(int val) {
            this.val = val;
        }
    }

    public class Solution {
        public int LastRemaining_Solution(int n, int m) {
//            if (n <= 0 || m <= 0) return -1;
//            Node head = new Node(0);
//            Node p = head;
//            for (int i = 1; i < n; i++) {
//                Node node = new Node(i);
//                p.next = node;
//                p = node;
//            }
//            p.next = head;
//            Node q = head;
//            while (q != p) {
//                for (int i = 1; i < m; i++) {
//                    q = q.next;
//                    p = p.next;
//                }
//                p.next = q.next;
//                q = p.next;
//            }
//            return q.val;
            /*
            （更优解）思路2：
            //
            要得到n个数字的序列中最后剩下的数字，
            只需要得到n-1个数字的序列中最后剩下的数字。。。
            //
            f(n,m)表示每次在n个数字0,1,2,...n-1中删除第m个数字最后剩下的数字。
            第一个删除数字k = (m-1)%n
            删除后的序列：
            k+1,k+2,...n-1,0,1,...k-1
            求映射
            (x-k-1)%n
            映射的反函数
            (x+k+1)%n
            所以f(n,m)=(f(n-1,m)+k+1)%n
            将公式（1）代入得：
            f(n,m)={
                0 if n = 1
                [f(n-1,m)+m]%n if n > 1
            }
             */
            if (n <= 0 || m <= 0) {
                return -1;
            }
            int last = 0;
            for (int i = 2; i <= n; i++) {
                last = (last + m) % i;
            }
            return last;
        }
    }
}
