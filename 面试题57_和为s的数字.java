package zuozhen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class 面试题57_和为s的数字 {
    /*
    题目一：
    输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好等于s。
    如果有多对，输出一对即可。
     */
    /*
    牛客AC代码（输出两个数的乘积最小的）
    对应每个测试案例，输出两个数，小的先输出。
     */
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        /*
        双指针
         */
        if (array.length == 0) return new ArrayList<Integer>();
        ArrayList ret = new ArrayList<Integer>();
        int pre = 0;
        int post = array.length - 1;
        while (pre < post) {
            int temp = array[pre] + array[post];
            if (temp == sum) {
                if (ret.size() == 0) {
                    ret.add(array[pre]);
                    ret.add(array[post]);
                } else {
                    if (array[pre] * array[post] < (int) ret.get(0) * (int) ret.get(1)) {
                        ret.remove(0);
                        ret.remove(1);
                        ret.add(array[pre]);
                        ret.add(array[post]);
                    }
                }
                pre++;
                post--;
            } else if (temp > sum) {
                post--;
            } else {
                pre++;
            }
        }
        return ret;
    }

    /*
    题目二：和为s的连续正数序列
    输入一个正数s，打印出所有和为连续正数序列（至少还有两个数）。
     */
    /*
    双指针：
    pre初始化为1，post初始化为2；
    pre到达(s+1)/2为止
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if (sum <= 2) return new ArrayList<ArrayList<Integer>>();
        ArrayList ret = new ArrayList<ArrayList<Integer>>();
        int pre = 1;
        int post = 2;
        while (pre != (sum + 1) / 2) {
            int s = CalculateSum(pre, post);
            if (s == sum) {
                ArrayList temp = new ArrayList<Integer>();
                for (int i = pre; i <= post; i++) {
                    temp.add(i);
                }
                ret.add(temp);
                post++;
            } else if (s > sum) {
                pre++;
            } else {
                post++;
            }
        }
        return ret;
    }

    public int CalculateSum(int pre, int post) {
        return (pre + post) * (post - pre + 1) / 2;
    }
}
