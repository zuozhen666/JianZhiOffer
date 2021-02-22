package zuozhen;

import org.junit.Test;

import java.util.Arrays;

public class 面试题61_扑克牌中的顺子 {
    /*
    从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
    2~10为数字本身，A为1，J为11，Q为12，K为13，而大小王可以看成任意数字。
     */
    /*
    牛客题目描述：
    LL今天心情特别好,因为他去买了一副扑克牌,
    发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
    他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,
    如果抽到的话,他决定去买体育彩票,嘿嘿！！
    “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”
    不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,
    并且A看作1,J为11,Q为12,K为13。
    上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
    LL决定去买体育彩票啦。
     现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
     如果牌能组成顺子就输出true，否则就输出false。
     为了方便起见,你可以认为大小王是0。
     */
    public boolean IsContinuous(int[] numbers) {
        if (numbers.length != 5) return false;
        Arrays.sort(numbers);
        int start = 0;
        for (; start < 5; start++) {
            if (numbers[start] != 0) break;
        }
        if (start == 4) return true;//存在四张及以上大小王
        int need = 0;
        for (int i = start; i < 4; i++) {
            if (numbers[i + 1] == numbers[i]) return false;//相等直接返回false
            if (numbers[i + 1] - numbers[i] != 1) {
                need += numbers[i + 1] - numbers[i] - 1;
            }
        }
        return need == 0 || start >= need;//判断大小王能否填满空缺
    }
    @Test
    public void test() {
        System.out.println(IsContinuous(new int[]{0, 3, 2, 6, 4}));
    }
}
