//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.armstrongNumber(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static String armstrongNumber(int n){
        // code here
        int sum=0;int val=0;
        String s=Integer.toString(n);
        int len=s.length();
        for(int i=0;i<len;i++)
        {   
            int num=Integer.parseInt(String.valueOf(s.charAt(i)));
            val=(int)Math.pow(num,len);
            sum=sum+val;
        }
        if(sum==n)
        {
            return "Yes";
        }
        else
        {
            return "No";
        }
    }
}