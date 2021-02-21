package zuozhen;

public class 面试题53_在排序数组中查找数字 {
    /*
    题目1：数字在排序数组中出现的次数。
     */
    public int GetNumberOfK(int[] array, int k) {
        /*
        先用二分找到k的位置，然后在前后搜索计数。
        搜索计数时仍然需要O(n);
        优化方向：通过二分搜索直接找到第一个k和最后一个k的索引（O(lgn)）
         */
//        if (array.length == 0) return 0;
////        int right = array.length - 1;
////        int left = 0;
////        int count = 0;
////        while (left <= right) {
////            int mid = (right + left) >> 1;
////            if (array[mid] == k) {
////                count++;
////                for (int i = 1; i <= mid - left; i++) {
////                    if (array[mid - i] == k) count++;
////                    else break;
////                }
////                for (int i = 1; i <= right - mid; i++) {
////                    if (array[mid + i] == k) count++;
////                    else break;
////                }
////                break;
////            } else if (array[mid] > k) {
////                right = mid - 1;
////            } else {
////                left = mid + 1;
////            }
////        }
////        return count;
        //优化方案实现
        if (array.length == 0) return 0;
        int index0 = GetFirstK(array, k, 0, array.length - 1);
        int index1 = GetLastK(array, k, 0, array.length - 1);
        if (index0 > -1 && index1 > -1) return index1 - index0 + 1;
        else return 0;
    }

    public int GetFirstK(int[] array, int k, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) >> 1;
        int val = array[mid];
        if (val == k) {
            if (mid == 0 || (mid > 0 && array[mid - 1] != k))
                return mid;
            end = mid - 1;
        } else if (val > k) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
        return GetFirstK(array, k, start, end);
    }

    public int GetLastK(int[] array, int k, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) >> 1;
        int val = array[mid];
        if (val == k) {
            if (mid == array.length - 1 || (mid < array.length - 1 && array[mid + 1] != k))
                return mid;
            start = mid + 1;
        } else if (val > k) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
        return GetLastK(array, k, start, end);
    }

    /*
    题目延伸：
    题目二：0~n-1中缺失的数字。
    一个长度为n-1的递增排序数组中的所有数字都是唯一的，且每个数字都在0~n-1范围内。
    找出唯一一个不在此排序数组中的数字。
    问题转化：在排序数组中找到第一个下标与数值不相同的元素。（二分即可）
    题目三：数组中数值和下标相等的元素。（递增排序数组）
    （二分即可）
    总结：看到排序数组，第一想法：二分！！！
     */
}
