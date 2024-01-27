class Solution {
    public int removeDuplicates(int[] nums) {
        /*
        best solution - O(n)

        Two Pointer Approach:
        - first pointer to place numbers
            - starts from beginning
        - second pointer to traverse and swap with first when number found that isn't equal to number 2 indexes to the left of first pointer
            - also starts from beginning
        - return first pointer's position

        */

        int i = 2;
        for (int j = 2; j < nums.length; j++) {
            if (nums[j] != nums[i - 2])
                nums[i++] = nums[j];
        }
        return i;
    }
}