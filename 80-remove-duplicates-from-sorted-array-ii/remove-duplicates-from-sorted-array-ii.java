class Solution {
    public int removeDuplicates(int[] nums) {
        /*
        optimised solution - O(n)

        1. mark all numbers repeated more than 2 times as Integer.MAX_VALUE
        1.5 count distinct numbers upto 2 times in separate variable k
        2. move Integer.MAX_VALUE numbers to end with sliding window
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
        
        // moving Integer.MAX_VALUE to end using sliding window
        int ws = 0;     // window size at start
        int temp;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == Integer.MAX_VALUE) ws++;
            else {
                temp = nums[i];
                nums[i] = nums[i - ws];
                nums[i - ws] = temp;
            }
        }

        return k;
    }
}