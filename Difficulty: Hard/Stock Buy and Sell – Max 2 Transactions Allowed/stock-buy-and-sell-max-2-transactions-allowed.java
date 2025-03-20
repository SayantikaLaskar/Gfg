//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxProfit(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int maxProfit(int[] prices) {
        // code here
        int b1=Integer.MIN_VALUE, b2=Integer.MIN_VALUE;
        int s1=0, s2=0;
        for(int p:prices){
            b1=Math.max(b1, -p);
            s1=Math.max(s1, b1+p);
            b2=Math.max(b2, s1-p);
            s2=Math.max(s2, b2+p);
        }
        return s2;
    }
}
