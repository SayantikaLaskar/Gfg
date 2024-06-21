//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    String compareFrac(String str) {
        // Code here
        String[] fractions = str.split(", ");
        String frac1 = fractions[0];
        String frac2 = fractions[1];
        
        // Split each fraction by "/" to get numerators and denominators
        String[] frac1Parts = frac1.split("/");
        String[] frac2Parts = frac2.split("/");
        
        int num1 = Integer.parseInt(frac1Parts[0]);
        int den1 = Integer.parseInt(frac1Parts[1]);
        int num2 = Integer.parseInt(frac2Parts[0]);
        int den2 = Integer.parseInt(frac2Parts[1]);
        
        // Compute the decimal values of the fractions
        double value1 = (double) num1 / den1;
        double value2 = (double) num2 / den2;
        
        // Compare the decimal values
        if (value1 > value2) {
            return frac1;
        } else if (value1 < value2) {
            return frac2;
        } else {
            return "equal";
        }
    }
}
