package zuozhen;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class 面试题38_字符串的排列 {
    /*
    输入一个字符串，打印出该字符串中字符的所有排列。
     */
    /*
    牛客AC代码（按照字典序）
     */
    /*
    回溯
     */
    private ArrayList<String> ret = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if (str.length() == 0) return ret;
        char[] strChar = str.toCharArray();
        Arrays.sort(strChar);
        solution(strChar, new boolean[strChar.length], new StringBuilder());
        return ret;
    }

    public void solution(char[] strChar, boolean[] marked, StringBuilder str) {
        if (str.length() == strChar.length) {
            ret.add(new String(str));
            return;
        }
        for (int i = 0; i < strChar.length; i++) {
            if (marked[i] == true) {
                continue;
            }
            if (i != 0 && strChar[i] == strChar[i - 1] && marked[i - 1] == false) {
                //防止重复
                continue;
            }
            marked[i] = true;
            str.append(strChar[i]);
            solution(strChar, marked, str);
            str.deleteCharAt(str.length() - 1);
            marked[i] = false;
        }
    }

    //剑指的思路（不考虑字典序）
    /*
    将字符串分为两部分，第一个字符和后面所有字符，使用第一个字符与后面所有字符交换来实现第一个位置的所有字符情况（后半部分同理）
    动态规划的递归式实现。
     */

    @Test
    public void test() {
        ArrayList<String> ans = Permutation("abb");
        Iterator it = ans.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
