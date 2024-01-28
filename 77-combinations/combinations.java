class Solution {
    private void solve(int start, int end, int k, List<List<Integer>> ans, List<Integer> curr) {
        if (curr.size() == k) {
            ans.add(new ArrayList(curr));
            return;
        }

        for (; start <= end; start++) {
            curr.add(start);
            solve(start + 1, end, k, ans, curr);
            curr.remove(curr.size() - 1);
        }
    }
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        solve(1, n, k, ans, new ArrayList<>());
    
        return ans;
    }
}