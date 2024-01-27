class Solution {
    public int rob(int[] nums) {
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