class Solution {
    public boolean isPalindrome(int x) {
        return
            new StringBuilder(String.valueOf(x)).toString()
            .equals(new StringBuilder(String.valueOf(x)).reverse().toString());
    }
}