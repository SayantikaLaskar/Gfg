//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    private static boolean isPossible(int[] stalls, int k, int minDist) {
        // code here
        int countCows = 1; // Place the first cow

        int lastPosition = stalls[0]; // First cow at the first stall

 

        for (int i = 1; i < stalls.length; i++) {

            if (stalls[i] - lastPosition >= minDist) {

                countCows++; // Place next cow

                lastPosition = stalls[i];

            }

            if (countCows >= k) { // If all cows are placed successfully

                return true;

            }

        }

        return false;

    }

 

    // Function to find the largest minimum distance

    public static int aggressiveCows(int[] stalls, int k) {

        Arrays.sort(stalls); // Sort the stall positions

        

        int low = 1; // Minimum possible distance

        int high = stalls[stalls.length - 1] - stalls[0]; // Maximum possible distance

        int result = 0;

 

        while (low <= high) {

            int mid = (low + high) / 2; // Middle of the range

            if (isPossible(stalls, k, mid)) {

                result = mid; // Update result and try for a larger distance

                low = mid + 1;

            } else {

                high = mid - 1;

            }

        }

        return result;
    }
}