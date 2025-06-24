class Solution {
    public static String maxSubseq(String s, int k) {
        // code here
        int n = s.length();
        int res_len = n - k;
        StringBuilder res = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            char currentChar = s.charAt(i);
            while (res.length() > 0 && res.charAt(res.length() - 1) < currentChar && k > 0) {
                res.deleteCharAt(res.length() - 1);
                k--;
            }
            res.append(currentChar);
        }
        
        // If there are remaining k characters to remove, remove them from the end
        if (k > 0) {
            res.setLength(res.length() - k);
        }
        
        return res.substring(0, res_len);
    }
}