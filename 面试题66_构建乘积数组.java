package zuozhen;

public class 面试题66_构建乘积数组 {
    /*
    给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
    其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
    （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，
    B[n-1] = A[0] * A[1] * ... * A[n-2];）
    对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
     */
    public int[] multiply(int[] A) {
        /*
        直接算的话，时间复杂度高
        */
//         int[] B = new int[A.length];
//         for(int i=0;i<A.length;i++){
//             B[i] = 1;
//             for(int j = 0;j<A.length;j++){
//                 if(j!=i)
//                     B[i] *= A[j];
//             }
//         }
//         return B;
        /*
        可以提前算出B[i]对应的left[i](A[0]*...A[i-1]),right[i](A[i+1]*...A[n-1])
        易知
        left[i+1]=left[i]*A[i](left[0]=1)
        right[i]=right[i+1]*A[i+1](right[n-1]=1)
        时间复杂度降低为n
        */
//         int len = A.length;
//         int[] B = new int[len];
//         int[] left = new int[len];
//         int[] right = new int[len];
//         left[0] = 1;
//         right[len-1]=1;
//         for(int i = 1; i<len;i++){
//             left[i] = left[i-1]*A[i-1];
//             right[len-i-1]=right[len-i]*A[len-i];
//         }
//         for(int i=0;i<len;i++){
//             B[i]=left[i]*right[i];
//         }
//         return B;
        /*
        优化空间复杂度
        */
        int[] B = new int[A.length];
        B[0] = 1;
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int tmp = 1;
        for (int i = 0; i < A.length; i++) {
            B[A.length - i - 1] *= tmp;
            tmp *= A[A.length - i - 1];
        }
        return B;
    }
}
