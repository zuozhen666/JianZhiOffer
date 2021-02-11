package zuozhen;

import java.util.ArrayList;

public class 面试题5_替换空格 {
    /*
    实现一个函数，把字符串中每个空格替换成"%20"
     */
    /*
    牛客AC代码
     */
    public static String replaceSpace(StringBuffer str) {
        /*
        思路1：利用indexOf方法记录空格位置，然后替换即可（有点太过简单了）
         */
//        if (str == null) return null;
//        ArrayList list = new ArrayList<Integer>();
//        ArrayList strs = new ArrayList<String>();
//        int index = 0;
//        while ((index = str.indexOf(" ", index)) != -1) {
//            list.add(index);
//            index++;
//        }
//        if (list.isEmpty()) return new String(str);
//        strs.add(str.substring(0, (int) list.get(0)));
//        for (int i = 1; i < list.size(); i++) {
//            strs.add(str.substring((int) list.get(i - 1) + 1, (int) list.get(i)));
//        }
//        strs.add(str.substring((int) list.get(list.size() - 1) + 1));
//        StringBuffer ans = new StringBuffer();
//        for (int i = 0; i < strs.size(); i++) {
//            ans.append(strs.get(i));
//            if (i != strs.size() - 1) {
//                ans.append("%20");
//            }
//        }
//        return new String(ans);
        //思路二：先计算出要添加的字符串长度然后使用双指针遍历一遍即可
        int P1 = str.length() - 1;//指针1
        for (int i = 0; i <= P1; i++) {
            if (str.charAt(i) == ' ')
                str.append("  ");//分析得，替换一个空格需要额外增加两个字符
        }
        int P2 = str.length() - 1;//指针2
        if (str.length() - 1 == P1) return str.toString();
        while (P1 >= 0) {//从后向前遍历
            char c = str.charAt(P1--);
            if (c == ' ') {
                str.setCharAt(P2--, '0');
                str.setCharAt(P2--, '2');
                str.setCharAt(P2--, '%');
            } else {
                str.setCharAt(P2--, c);
            }
        }
        return str.toString();
    }
<<<<<<< Updated upstream
        /*
=======
    /*
>>>>>>> Stashed changes
    题目延伸：
    合并排序数组时也可以考虑从后往前，从而减少移动次数
     */

    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("We are happy")));
    }
}
