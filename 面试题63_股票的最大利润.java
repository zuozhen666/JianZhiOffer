package zuozhen;

import org.junit.Test;

public class 面试题63_股票的最大利润 {
    /*
    假设把某股票的价格按照时间先后顺序存储在数组中，
    请问买卖股票一次可能获得的最大利润是多少？
    例如：
    {9,11,8,5,7,12,16,14}
    最大利润16-5=11;
     */
    /*
    注意：只有买入后才能卖出（有时间的先后顺序）
     */
    public int maxProfit(int[] prices) {
        /*
        遍历一遍，将每个位置作为卖出价格，但要记录在该位置前的最低买入价格
         */
        if (prices == null || prices.length == 0) return 0;
        int buyMin = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - buyMin);
            buyMin = Math.min(buyMin, prices[i]);
        }
        return maxProfit;
    }

    @Test
    public void test() {
        int[] arr = new int[]{9, 11, 8, 5, 7, 12, 16, 14};
        System.out.println(maxProfit(arr));
    }
}
