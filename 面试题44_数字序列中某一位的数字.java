package zuozhen;

import org.junit.Test;

public class 面试题44_数字序列中某一位的数字 {
    /*
    数字以0123456789101112131415...的格式序列化到一个字符序列中。在这个序列中：
    第五位是5，第十三位是1，第十九位是4...请写一个函数，求任意第n位对应的数字。
     */
    /*
    按照十进制位数规律按顺序找，
    如：一位：0~9：10*1 = 10
        二位：10~99：90*2 = 180
        三位：100~999：900*3 = 2700
        四位：1000~9999：9000*4 = 36000
        ...
     */
    public int getDigitAtIndex(int index) {
        if (index < 0) {
            return -1;
        }
        int place = 1;//位数
        while (true) {
            int amount = getAmountOfPlace(place);
            if (index < amount) {
                return getDigitAtIndex(index, place);
            }
            index -= amount;
            place++;
        }
    }

    public int getAmountOfPlace(int place) {
        if (place == 1) return 10;
        else {
            return ((int) Math.pow(10, place - 1)) * 9 * place;
        }
    }

    public int getBeginNumOfPlace(int place) {
        if (place == 1) return 0;
        else {
            return (int) Math.pow(10, place - 1);
        }
    }

    public int getDigitAtIndex(int index, int place) {
        int beginNum = getBeginNumOfPlace(place);
        int step = index / place;
        String number = (beginNum + step) + "";
        return number.charAt(index % place) - '0';
    }

    @Test
    public void test() {
        System.out.println(getDigitAtIndex(1001));
    }
}
