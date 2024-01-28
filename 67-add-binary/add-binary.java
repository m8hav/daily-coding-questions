class Solution {
    public String addBinary(String a, String b) {
        String ans = "";
        int i = 0;
        int sum = 0;
        while (i < a.length() || i < b.length() || sum > 0) {
            if (a.length() - i - 1 >= 0)
                sum += a.charAt(a.length() - i - 1) == '1' ? 1 : 0;
            if (b.length() - i - 1 >= 0)
                sum += b.charAt(b.length() - i - 1) == '1' ? 1 : 0;
            ans = (sum % 2) + ans;
            sum /= 2;
            i++;
        }
        return ans;
    }
}