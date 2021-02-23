package zuozhen;

public class 面试题_把字符串转换成整数 {
    /*
    将一个字符串转换成一个整数，
    要求不能使用字符串转换整数的库函数。
    数值为0或者字符串不是一个合法的数值则返回0
     */
    /*
    输入描述：
    输入一个字符串,包括数字字母符号,可以为空
     */
    /*
    返回值描述：
    如果是合法的数值表达则返回该数字，否则返回0
     */
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) return 0;
        boolean isNegative = str.charAt(0) == '-';
        int ret = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '-' || c == '+'))
                continue;
            if (c < '0' || c > '9')
                return 0;
            ret = ret * 10 + (c - '0');
        }
        return isNegative ? -ret : ret;
    }
}
