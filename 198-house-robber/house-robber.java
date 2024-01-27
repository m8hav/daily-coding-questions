class Solution {
    public int rob(int[] nums) {
        /*
            DP Tabulation method - using just last 2 variables

            Two cases - you include a house, or you don't:
            1. You include a house - you can't add money of last house.
                - You add money of current house.
                - You can only add money from the house before the last house.
            2. You don't include a house - you can add money from last house.
                - You can't add money of current house.
        */

        int prev2 = 0;
        int prev1 = nums[0];
        for (int i = 1, ans; i < nums.length; i++) {
            ans = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = ans;
        }
        return prev1;
    }
}