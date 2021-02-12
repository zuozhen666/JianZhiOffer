package zuozhen;

public class 面试题11_旋转数组的最小数字 {
    /*
    把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转；
    输入一个递增排序数组的一个旋转，输出旋转数组的最小元素。
     */
    /*
    牛客AC代码：
     */
    public int minNumberInRotateArray(int[] array) {
        /*
        思路：
        利用旋转数组的特性，二分查找
         */
        if (array.length == 0) return 0;
        int pre = 0, post = array.length - 1;
        while (pre < post - 1) {
            //pre总是在前半增序部分，post总是在后半增序部分
            int mid = (pre + post) >> 1;
            if (array[pre] == array[mid] && array[mid] == array[post]) {
                //特殊情况，答案在pre到post之间
                for (int i = pre; i < post; i++) {
                    if (array[i] > array[i + 1]) {
                        return array[i + 1];
                    }
                }
                return array[pre];
            } else if (array[mid] <= array[post]) {
                //这里只有这个唯一条件可用，很难受
                post = mid;
            } else {
                pre = mid;
            }
        }
        return array[post];
    }
}
