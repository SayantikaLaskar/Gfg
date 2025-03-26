//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String s = sc.nextLine();
            String line = sc.nextLine();
            String[] dictionary = line.split(" ");

            Solution obj = new Solution();
            if (obj.wordBreak(s, dictionary)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public boolean wordBreak(String s, String[] dictionary) {
        // code here
        int n=s.length();
        HashSet<String> h=new HashSet<>(Arrays.asList(dictionary));
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        int m=0;
            for(String w:dictionary){
                m=Math.max(m, w.length());
            }
            for(int i=1;i<=n; i++){
                for(int j=Math.max(i-m, 0);j<i;j++){
                   if(dp[j] && h.contains(s.substring(j, i))){
                    dp[i]=true;
                    break;
                } 
            }
        }
        return dp[n];
    }
}