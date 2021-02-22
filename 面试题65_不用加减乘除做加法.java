package zuozhen;

public class 面试题65_不用加减乘除做加法 {
    public int Add(int num1, int num2) {
        /*
        不考虑进位的话，num1^num2即为所求；
        考虑进位，即用(num1&num2)<<1来求得进位位置
        */
        int sum;
        int carry;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);
        return sum;
    }
}
