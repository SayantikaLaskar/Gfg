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
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[]) {
        // code here
        TreeMap<Integer,Integer>mp=new TreeMap<>();
        int a=0;
        int b=0;
        for(int i=0;i<arr.length;i++){
            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
        }
        
        for(Map.Entry<Integer,Integer>i:mp.entrySet()){
            if(i.getValue()==2){
                b=i.getKey();
                break;
            }
        }
      int cnt=1;
        for(Map.Entry<Integer,Integer>i:mp.entrySet()){
            if(cnt!=i.getKey()){
                a=cnt;
                break;
            }
            cnt++;
        }
        if(a==0)
        a=arr.length;
        int res[]=new int[2];
        res[0]=b;
        res[1]=a;
        return res;
    }
}