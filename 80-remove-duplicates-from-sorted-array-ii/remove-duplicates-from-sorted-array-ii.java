class Solution {
    public int removeDuplicates(int[] nums) {
        /*
        brute force solution - O(n log(n))

        1. mark all numbers repeated more than 2 times as Integer.MAX_VALUE
        1.5 count distinct numbers upto 2 times in separate variable k
        2. sort array
        3. return k

        */
        int count = 1;
        int last = nums[0];
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != last) {
                count = 1;
                last = nums[i];
                k++;
            }
            else if (count == 2) nums[i] = Integer.MAX_VALUE;
            else {
                count++;
                k++;
            }
        }
        Arrays.sort(nums);
        return k;
    }
}