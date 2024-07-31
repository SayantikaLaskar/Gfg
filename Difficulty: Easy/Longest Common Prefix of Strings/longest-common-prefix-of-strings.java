//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String longestCommonPrefix(String arr[]) {
        int min=Integer.MAX_VALUE,end=-1;
        for(String x:arr){
            if(x.length()<min) min=x.length();
        }
        int low=0,high=min-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(solve(mid,arr)){
                end=mid;
                low=mid+1;
            } else high=mid-1;
        }
        if(end==-1) return String.valueOf(end);
        return arr[0].substring(0,end+1);
    }
    private boolean solve(int ind,String arr[]){
        String curr=arr[0].substring(0,ind+1);
        for(int i=1;i<arr.length;i++){
            if(!arr[i].startsWith(curr)) return false;
        }
        return true;
    }
}