class Solution {

    /**
    BackTracking solution

    Recursively fix each previous position,
    then iteratively swap current index with every remaining index
    so each remaining element can be placed at the position
    and make a recursive call for the array with swapped elements.

    BackTrack i.e. swap positions again after recursive call is done
    so the relative positions of elements can be maintained
    for next recursive call in the parent call.

    When index reaches the end of array,
    add a copy of the array to the answer nested array.
     */

    private void swap(List<Integer> arr, int a, int b) {
        int temp = arr.get(a);
        arr.set(a, arr.get(b));
        arr.set(b, temp);
    }

    private void solve(List<Integer> nums, List<List<Integer>> ans, int idx) {
        if (idx == nums.size()) {
            // add a copy of current state of nums
            // if end of array reached for current permutation
            ans.add(new ArrayList<>(nums));
            return;
        }

        // make recursive call by leaving current arrangement for default position
        solve(nums, ans, idx + 1);
        // make recursive calls by swapping elements with each remaining position
        for (int i = idx + 1; i < nums.size(); i++) {
            swap(nums, i, idx);
            solve(nums, ans, idx + 1);
            swap(nums, i, idx);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> input = new ArrayList<>();
        for (int num : nums) input.add(num);

        solve(input, ans, 0);

        return ans;
    }
}