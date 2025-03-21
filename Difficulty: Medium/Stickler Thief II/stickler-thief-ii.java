//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int n = s.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int[] arr = IntArray.input(br);

            Solution obj = new Solution();
            int res = obj.maxValue(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    int maxValue(int[] arr) {
        // code here
        int n=arr.length;
        if(n==1) return arr[0];
        if(n==2) return Math.max(arr[0], arr[1]);
        int[] d1=new int[n];
        int[] d2=new int[n];
        Arrays.fill(d1, -1);
        Arrays.fill(d2, -1);
        int s1=s(arr, 0, n-1, d1);
        int s2=s(arr, 1, n, d2);
        return Math.max(s1, s2);
    }
    public static int s(int[] a, int i, int n, int[] d){
        if(i>=n) return 0;
        if(d[i]!=-1) return d[i];
        int t=s(a, i+2, n, d)+a[i];
        int nt=s(a, i+1, n, d);
        return d[i]=Math.max(t, nt);
    }
}
