class Solution {
    public int trailingZeroes(int n) {
        /*
            In factorials,
            trailing zeros are made of following pairs of factors:
            - 5 and 2
            - 5 and 4
            - 5 and 6
            - 5 and 8
            - 5 and 10
            ...
            - 25 and 2
            - 25 and 4
            ...
            - 125 and 2
            - 125 and 4
            ...
            - 625 and 2
            - 625 and 4
            ...

            Here, for any pair, 5 is required with any multiple of 2.
            We have many more 2 than 5, so we just count the number of 5s.
            
            But for numbers of the form 5^n where n > 1
            there are multiple 5s as factors, which need to be counted.
            So we run the function recursively on n / 5 to get all 5s.
        */
        
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}