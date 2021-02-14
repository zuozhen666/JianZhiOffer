package zuozhen;

public class 面试题19_正则表达式匹配 {
    /*
    请实现一个函数用来匹配包含'.'和'*'的正则表达式。
    '.'表示任意一个字符
    '*'表示它前面的字符可以出现任意次（含0次）
     */
    /*
    牛客AC代码
     */
    public boolean match(char[] str, char[] pattern) {
        return matchStr(str, 0, pattern, 0);
    }

    public boolean matchStr(char[] str, int i, char[] pattern, int j) {
        if (i == str.length && j == pattern.length) {
            return true;
        } else if (j == pattern.length) {
            return false;
        }
        boolean next = j + 1 < pattern.length && pattern[j + 1] == '*';//判断正则表达式下一个字符是否为'*'
        if (next) {
            if (i < str.length && (pattern[j] == '.' || str[i] == pattern[j])) {
                return matchStr(str, i, pattern, j + 2) || matchStr(str, i + 1, pattern, j);
            } else {
                return matchStr(str, i, pattern, j + 2);//说明'*'前的字符出现了0次
            }
        } else {
            if (i < str.length && (pattern[j] == '.' || str[i] == pattern[j])) {
                return matchStr(str, i + 1, pattern, j + 1);
            } else {
                return false;
            }
        }
    }
}
