package zuozhen;

import java.util.Arrays;
import java.util.Comparator;

public class 面试题45_把数组排成最小的数 {
    /*
    输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
    打印能拼接的所有数字中最小的一个。
     */
    /*
    贪心
     */
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return "";
        int n = numbers.length;
        String[] nums = new String[n];
        for (int i = 0; i < n; i++)
            nums[i] = numbers[i] + "";
        //Arrays.sort(nums, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s1.compareTo(s2);
            }
        });
        String ret = "";
        for (String str : nums)
            ret += str;
        return ret;
    }
}
