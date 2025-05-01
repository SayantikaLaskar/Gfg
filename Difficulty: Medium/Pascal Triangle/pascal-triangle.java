//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            ArrayList<Integer> ans = new Solution().nthRowOfPascalTriangle(n);
            printAns(ans);

            System.out.println("~");
        }
    }

    public static void printAns(ArrayList<Integer> ans) {
        for (Integer x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        // code here
         ArrayList<Integer> list = new ArrayList<>();
        if(n==0) return new ArrayList<Integer>();
        
        list.add(1);
        if(n==1) { return list; }
        
        list.add(1);
        if(n==2) return list;
       
        for(int k=2;k<n;k++){
            ArrayList<Integer> mainList = new ArrayList<>();
            
            mainList.add(1);
            for(int i=1;i<list.size();i++){
                mainList.add(list.get(i)+list.get(i-1));
            }
            mainList.add(1);
            list=mainList;
        }
        return list;  
    }
}