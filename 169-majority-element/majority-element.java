class Solution {
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (major == nums[i]) count++;
            else if (major != nums[i] && count > 1) count--;
            else {
                major = nums[i];
            }
        }
        return major;
    }
}