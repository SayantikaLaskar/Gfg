//{ Driver Code Starts
import java.io.*;
import java.util.*;

// Driver class

// } Driver Code Ends
// User function Template for Java

class Solution {
    public long maxSum(Long[] arr) {
        // code here
        int i=0, n=arr.length, j=n;
        long sum=0;
        Arrays.sort(arr);
        int it=1;
        while(it<n){
            if((it&1)==1){
                j-=1;
                sum+=Math.abs(arr[i]-arr[j]);
            } else{
                i+=1;
                sum+=Math.abs(arr[j]-arr[i]);
            }
            it++;
        }
        if((n&1)==1){
            sum+=Math.abs(arr[i]-arr[0]);
        }
        else{
            sum+=Math.abs(arr[j]-arr[0]);
        }
        return sum;
    }
}


//{ Driver Code Starts.
class Main {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the Long integers
            ArrayList<Long> array = new ArrayList<>();

            // Parse the tokens into Long integers and add to the array
            for (String token : tokens) {
                array.add(Long.parseLong(token));
            }

            // Convert ArrayList to array
            Long[] arr = new Long[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call maxSum method and print result
            long ans = ob.maxSum(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends