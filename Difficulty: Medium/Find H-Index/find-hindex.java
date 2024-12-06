//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_cases = Integer.parseInt(br.readLine().trim());

        while (test_cases-- > 0) {
            // Read the array from input line
            String[] input = br.readLine().trim().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            // Solution instance to invoke the function
            Solution ob = new Solution();
            int result = ob.hIndex(arr);

            System.out.println(result);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to find hIndex
    public int hIndex(int[] citations) {
        // code here
        int n=citations.length;
        int m=0;
        for(int citation:citations){
            m=Math.max(m, citation);
        }
        int[] c=new int[m+2];
        for(int citation:citations){
            c[0]++;
            c[citation+1]--;
        }
        for(int i=1; i<c.length; i++){
            c[i]+=c[i-1];
        }
        for(int i=c.length-1; i>=0; i--){
            if(c[i]>=i){
                return i;
            }
        }
        return 0;
    }
}