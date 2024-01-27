class Solution {
    public int climbStairs(int n) {
        /*
            Tabulation Method - Space Optimised with only 2 variables
            - Love Babbar's Method
        */
        int prev2 = 0;
        int prev1 = 1;
        for (int i = 1, ans; i <= n; i++) {
            ans = prev1 + prev2;
            prev2 = prev1;
            prev1 = ans;
        }
        return prev1;
    }
}