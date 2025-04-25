//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().majorityElement(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int majorityElement(int arr[]) {
        // code here
        int n=arr.length, l=n/2;
        Map<Integer, Integer> m=new HashMap<>();
        for(int i=0; i<n; i++){
            if(m.getOrDefault(arr[i], 0)<l){
                m.put(arr[i], m.getOrDefault(arr[i], 0)+1);
            }else{
                return arr[i];
            }
        }
        return -1;
    }
}