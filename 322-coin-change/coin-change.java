class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        for (int value = 1; value < amount + 1; value++)
            dp[value] = Integer.MAX_VALUE;
        dp[0] = 0;

        for (int coin : coins) {
            for (int value = 1; value <= amount; value++) {
                if (value - coin < 0 || dp[value - coin] == Integer.MAX_VALUE)
                    continue;
                dp[value] = Math.min(dp[value], 1 + dp[value - coin]);
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}