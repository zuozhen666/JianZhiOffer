package zuozhen;

import org.junit.Test;

import java.util.Arrays;

public class 面试题48_最长不含重复字符的子字符串 {
    /*
    dp：
    f(i)以序号i结尾的字符串所含的最长不含重复字符的字符串。
    //
    如果第i个字符没有出现过，f(i)=f(i-1)+1;
    如果第i个字符之前出现过，且之前出现位置与当前位置距离d小于f(i-1)，f(i)=d;
    否则：f(i)=f(i-1)+1;
     */
    public int solution(String str) {
        if (str == null || str.length() == 0) return 0;
        int[] dp = new int[str.length()];
        dp[0] = 1;
        int[] preIndex = new int[26];//记录字符之前出现的位置
        Arrays.fill(preIndex, -1);
        int maxLength = 1;
        preIndex[str.charAt(0) - 'a'] = 0;
        for (int i = 1; i < str.length(); i++) {
            int c = str.charAt(i) - 'a';
            if (preIndex[c] == -1 || i - preIndex[c] > dp[i - 1])
                dp[i] = dp[i - 1] + 1;
            else dp[i] = i - preIndex[c];
            maxLength = Math.max(maxLength, dp[i]);
            preIndex[c] = i;
        }
        return maxLength;
    }

    @Test
    public void test() {
        System.out.println(solution("arabcacfr"));
        //1,2,2,3,4,3,2,3,4
    }
}
