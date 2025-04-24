//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSingle(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getSingle(int[] arr) {
        // code here
        int a=0;
        for(int i=0; i<32; i++){
            int c1=0, c2=0;
            for(int j=0; j<arr.length; j++){
                int b=((arr[j]>>i)&1);
                if(b==1){
                    c1++;
                }else{
                c2++;
                }
            }if(c2%3==0){
            a|=(1<<i);
            }
        }
        return a;
    }
}