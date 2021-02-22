package zuozhen;

import org.junit.Test;

public class 面试题46_把数字翻译成字符串 {
    /*
    翻译规则：0->"a",1->"b",2->"c",...25->"z"
    一个数字可能有多个翻译，请实现一个函数，来计算一个数字有多少种翻译方法。
     */
    /*
    dp：
    不妨设dp[i]为substring(0,i+1)的翻译方法数；
    dp[i+2]={
        if(序号i+1,i+2对应字符组成的数字<10或者>25) dp[i+1];
        else dp[i+1]+dp[i];
    }
     */
    public int numDecodingsMy(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int len = s.length();
        int[] dp = new int[len];
        dp[0] = 1;
        if (len == 1) return dp[0];
        if (check(s.substring(0, 2)))
            dp[1] = 2;
        else dp[1] = 1;
        for (int i = 2; i < len; i++) {
            if (check(s.substring(i - 1, i + 1)))
                dp[i] = dp[i - 1] + dp[i - 2];
            else
                dp[i] = dp[i - 1];
        }
        return dp[len - 1];
    }

    public boolean check(String str) {
        int val = Integer.valueOf(str);
        if (val >= 10 && val <= 25)
            return true;
        else return false;
    }

    @Test
    public void test() {
        System.out.println(numDecodingsMy("12345672121345"));
        System.out.println(numDecodingsMy("12258"));
    }
}
