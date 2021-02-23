package zuozhen;

public class 面试题51_数组中的逆序对 {
    /*
    在数组中的两个数字，如果前面一个数字大于后面的数字，
    则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
     */
    /*
    牛客题目描述：
    在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
    输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
    即输出P%1000000007
        对于50%的数据,size ≤ 0^4
        对于75%的数据,size ≤ 10^5
        对于100%的数据,size ≤ 10^5
    题目保证输入的数组中没有的相同的数字
     */
    /*
    归并排序的思想
     */
    /*
    未AC
    报错：java.lang.NumberFormatException: For input string: "1534499826491"
    感觉自己没什么错。。。
     */
    private int count = 0;

    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) return 0;
        mergeSort(array, 0, array.length - 1);
        return count % 1000000007;
    }

    public void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) >> 1;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;//leftArr index
        int j = mid + 1;//RightArr index
        int k = 0;//temp index
        while (i <= mid && j <= right) {
            if (arr[i] > arr[j]) {
                count += mid - i + 1;
                count %= 1000000007;
                temp[k++] = arr[j++];
            } else {
                temp[k++] = arr[i++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        k = 0;
        for (int l = left; l <= right; l++) {
            arr[l] = temp[k++];
        }
    }
}
