class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int sum = 0;
        while (i < a.length() || i < b.length() || sum > 0) {
            if (a.length() - i - 1 >= 0)
                if (a.charAt(a.length() - i - 1) == '1')
                    sum++;
            if (b.length() - i - 1 >= 0)
                if (b.charAt(b.length() - i - 1) == '1')
                    sum++;
            sb.append(sum % 2);
            sum /= 2;
            i++;
        }
        return sb.reverse().toString();
    }
}