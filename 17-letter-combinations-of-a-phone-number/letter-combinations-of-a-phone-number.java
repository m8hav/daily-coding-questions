class Solution {
    private void solve(String digits, List<String> ans, Map<Character, String> keyMap, int idx, StringBuilder curr) {
        if (idx == digits.length()) {
            if (curr.length() > 0) ans.add(curr.toString());
            return;
        }

        for (char c : keyMap.get(digits.charAt(idx)).toCharArray()) {
            solve(digits, ans, keyMap, idx + 1, curr.append(c));
            curr.setLength(curr.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        Map<Character, String> keyMap = new HashMap<>();
        keyMap.put('2', "abc");
        keyMap.put('3', "def");
        keyMap.put('4', "ghi");
        keyMap.put('5', "jkl");
        keyMap.put('6', "mno");
        keyMap.put('7', "pqrs");
        keyMap.put('8', "tuv");
        keyMap.put('9', "wxyz");

        List<String> ans = new ArrayList<>();
        solve(digits, ans, keyMap, 0, new StringBuilder());

        return ans;
    }
}