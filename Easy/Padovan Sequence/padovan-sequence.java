//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.padovanSequence(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
  public int padovanSequence(int n)
    {
        //code here.
        int[] arr={1,1,1,1};
        int mod=(int) (1e9+7);
        for(int i=0;i<=n-3;i++){
            arr[3]=(arr[1]+arr[0])%mod;
            arr[0]=arr[1];
            arr[1]=arr[2];
            arr[2]=arr[3];
        }
        
        return arr[3];
    }
    
}
