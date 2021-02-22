package zuozhen;

import java.util.logging.Level;

public class 面试题58_翻转字符串 {
    /*
    题目一：翻转单词顺序
    翻转句子里的单词，标点符号当作字符来处理。
    如"i am a student."->"student. a am i"
     */
    /*
    思路：先翻转字符串，然后翻转每个单词；
    或者：先翻转每个单词，再翻转字符串。
     */
    public String ReverseSentence(String str) {
        /*
        先翻转单词，再翻转字符串
         */
        if (str == null) return null;
        if (str.length() == 0) return str;
        char[] chars = str.toCharArray();
        int i = 0, j = 0;
        while (j <= str.length()) {
            if (j == str.length() || chars[j] == ' ') {
                Reverse(chars, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        Reverse(chars, 0, str.length() - 1);
        return new String(chars);
    }

    /**
     * 翻转char数组某一段序列
     *
     * @param chars
     * @param start
     * @param end
     */
    public void Reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    /*
    题目二：左旋转字符串
    字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
    请定义一个函数实现字符串左旋转操作的功能。
     */
    public String LeftRotateString(String str, int n) {
        /*
        利用String的api
         */
//        if (n == 0) return str;
//        int len = str.length();
//        if (len == 0) return str;
//        n = n % len;
//        return str.substring(n) + str.substring(0, n);
        /*
        利用Reverse函数
         */
        if (str == null) return null;
        int len = str.length();
        if (len == 0) return "";
        n = n % len;
        char[] chars = str.toCharArray();
        Reverse(chars, 0, n - 1);
        Reverse(chars, n, len - 1);
        Reverse(chars, 0, len - 1);
        return new String(chars);
    }
}
