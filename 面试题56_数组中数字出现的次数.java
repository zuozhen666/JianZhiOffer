package zuozhen;

import java.util.HashMap;
import java.util.Map;

public class 面试题56_数组中数字出现的次数 {
    /*
    题目一：数组中只出现一次的两个数字
    一个整型数组里除了两个数字之外，其他数字都出现了两次。
    找出这两个只出现一次的数字。时间复杂度O(n)，空间复杂度O(1)
     */
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        /*经典哈希*/
//        Map map = new HashMap<Integer, Integer>();
//        for (int i = 0; i < array.length; i++) {
//            if (map.containsKey(array[i])) {
//                map.put(array[i], 2);
//            } else map.put(array[i], 1);
//        }
//        double[] ans = new double[]{0.1, 0.1};
//        int pre = 0;
//        for (int i = 0; i < array.length; i++) {
//            if ((int) map.get(array[i]) == 1) {
//                ans[pre] = array[i];
//                pre++;
//            }
//            if (ans[0] != 0.1 && ans[1] != 0.1) break;
//        }
//        num1[0] = (int) ans[0];
//        num2[0] = (int) ans[1];
        /*
        位运算（nb）
        首先：将数组所有元素全部异或，得到的值是目标两个结果的异或值；
        思路就是用一个巧妙的方式将这两个目标结果分开，然后在原数组中进行异或操作；
        找到异或结果里其中的一个1位置，这个地方就是两个目标结果二进制中取值不同的位之一，
        通过这个位用与操作能过滤掉一些数据，达到要求；
        */
        int ret = 0;
        for (int i = 0; i < array.length; i++) {
            ret ^= array[i];
        }
        int index = 1;
        while ((index & ret) == 0) {
            index <<= 1;
        }
        num1[0] = 0;
        num2[0] = 0;
        for (int i = 0; i < array.length; i++) {
            if ((index & array[i]) == 0)
                num1[0] ^= array[i];
            else num2[0] ^= array[i];
        }
    }
    /*
    延伸：
    题目二：在一个数组中出一个数字只出现一次之外，其他数字都出现了三次，请找出那个只出现一次的数字。
    思路：将所有数字的二进制表示的每一位加起来%3（结果为0或1），最终结果即为只出现一次的数字。
    需要一个额外的32位辅助数组。
     */
}
