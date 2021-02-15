package zuozhen;

public class 面试题20_表示数值的字符串 {
    /*
    请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
     */
    /*
    思路：
    正则表达式匹配：
    []：字符集合
    ()：分组
    ?：重复0~1次
    +：重复1~n次
    *：重复0~n次
    .：任意字符
    \\.：转义后的.
    \\d：数字
     */
    /*
    牛客AC代码
     */
    public boolean isNumeric(char[] str) {
        if (str.length == 0) {
            return false;
        }
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }
}
