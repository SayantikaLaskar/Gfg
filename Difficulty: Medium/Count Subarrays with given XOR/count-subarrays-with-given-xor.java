//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s[] = br.readLine().split(" ");
            int arr[] = new int[s.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int k = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            System.out.println(obj.subarrayXor(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        long n=arr.length;
        long p=0;
        long c=0;
        HashMap<Long,Long> m=new HashMap<>();
        m.put(0L,1L);
        for(int i=0;i<n;i++){
            p^=arr[i];
            long t=p^k;
            c+=m.getOrDefault(t,0L);
            m.put(p,m.getOrDefault(p,0L)+1L);
        }
        return c;
    }
}