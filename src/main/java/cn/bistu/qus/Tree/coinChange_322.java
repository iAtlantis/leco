package cn.bistu.qus.Tree;

import java.lang.reflect.Array;
import java.util.Arrays;

public class coinChange_322 {
    // 记录相同amount下的最优结果
    public int[] memo;

    // ===========自顶向下
    public int coinChange(int[] coins, int amount){
        memo = new int[amount+1];
        // 设置空位
        Arrays.fill(memo,-666);
        return dp(coins, amount);
    }

    /**
      * @Description:返回amount下，至少硬币数
      * @Param: [coins, amount]
      * @return: int
      * @Author: Alon
      * @Date: 2022/10/17
      * @Time:
    **/
    private int dp(int[] coins, int amount) {
        if (amount == 0)    return 0;
        if (amount < 0)    return -1;
        if (memo[amount]!=-666) {
//            System.out.printf("使用memo%d",amount);
            return memo[amount];
        }

        int res = Integer.MAX_VALUE;

        for (int coin : coins) {
            int sub = dp(coins,amount-coin);
            // 如果没有子问题则
            if(sub == -1)    continue;
            res = Math.min(res,sub+1);
        }
        // 看有没有子节点
        // 不能放在上面的原因是：造成忽略无解的情况，使得重复计算无解情况
        memo[amount] = res==Integer.MAX_VALUE?-1:res;
        return memo[amount];
    }

    // 自底向上写法
    public int coinChange2(int[] coins, int amount){
        // dp定义为对于i金额至少需要dp[i]枚硬币
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        // base case
        dp[0] = 0;
        // 外层循环遍历所有情况
        for(int i = 0;i<dp.length;i++){
            // 内层循环找当前所有情况
            for (int coin : coins) {
                // 无解情况
                if(i-coin<0)    continue;
                dp[i] = Math.min(dp[i],1+(dp[i-coin]));
            }
        }

        return dp[amount] == amount+1?-1:dp[amount];
    }

    public static void main(String[] args) {
        int[] coin = {186,419,83,408};
        coinChange_322 solution = new coinChange_322();
        System.out.println(solution.coinChange2(coin,6249));
    }
}



