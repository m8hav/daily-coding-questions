class Solution {
    public int majorityElement(int[] nums) {
        /*
        Modified solution from Solutions tab - Super Optimised
            Time: O(n), n - length of nums
            Space: O(1)

        Intuition:
            Array length is always odd for there to be majority element.

            You can start counting major element from start of array
            and decrease count of major whenever current element isn't equal to major.

            If count goes 0, you replace the element with current element
            and make count 1 again.

            Since major element exists more than n/2 times,
            even if its count gets reduced over and over,
            it'll still remain as the major with count >= 1 at end.

            This is because major's count is >= (n/2 + 1),
            and other elements count is <= (n/2)
            and even if it's worst case scenario
            with majority element being exactly (n/2 + 1) times,
            the deductions would still leave major with count 1
            as (n/2 + 1) - (n/2) = 1

        Approach:
            - you start counting major element from each position in array
            - if current element is same as major, you increase count
            - if current element isn't same as major, you decrease count
            - if count reaches 0, you replace major and set count to 1 again

        Examples:
            2 will be majority element in all of the following:
            - [2, 2, 2, 1, 1]
            - [2, 1, 2, 1, 2]
            - [2, 2, 1, 1, 2]
            - [2, 2, 1, 2, 1]
            - [1, 1, 2, 2, 2]
            - [1, 2, 2, 1, 2]
            - [1, 2, 1, 2, 2]
        */
        
        int major = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (major == nums[i]) count++;
            else count--;
            if (count == 0) {
                major = nums[i];
                count++;
            }
        }
        return major;
    }
}