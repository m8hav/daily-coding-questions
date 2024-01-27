class Solution {

    public int solveRec(int[] nums, int idx) {
        /*
            Recursion method - slow AF
            - Gives TLE

            Two cases - you include a house, or you don't:
            1. You include a house - you can't add money of last house.
                - You add money of current house.
                - You can only add money from the house before the last house.
            2. You don't include a house - you can add money from last house.
                - You can't add money of current house.
        */

        // Base Condition
        if (idx >= nums.length) return 0;

        // Recursive Condition
        int incl = nums[idx] + solveRec(nums, idx + 2);
        int excl = solveRec(nums, idx + 1);

        // Returning best result
        return Math.max(incl, excl);
    }

    public int solveMem(int[] nums, int idx, int[] dp) {
        /*
            DP Memoization - saving results recursively to DP array
        */
        // Base Condition
        if (idx >= nums.length) return 0;

        // Checking if value already exists in DP array
        if (dp[idx] != -1) return dp[idx];

        // Recursive Condition
        int incl = nums[idx] + solveMem(nums, idx + 2, dp);
        int excl = solveMem(nums, idx + 1, dp);

        // Saving best result to DP array
        dp[idx] = Math.max(incl, excl);

        // Returning best result
        return dp[idx];
    }

    public int solveTabSpaceOp(int[] nums) {
        /*
            DP Tabulation method - Space Optimized
            - using just last 2 variables
            - FASTEST

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

    public int rob(int[] nums) {
        // Creating DP array
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            dp[i] = -1;

        // return solveRec(nums, 0);    // Gives TLE
        // return solveMem(nums, 0, dp);
        return solveTabSpaceOp(nums);
    }
}