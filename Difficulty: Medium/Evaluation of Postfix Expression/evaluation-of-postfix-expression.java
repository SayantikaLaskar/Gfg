//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends


class Solution {
    public int evaluate(String[] arr) {
        // code here
        Deque<Integer> o=new ArrayDeque<>();
        int n1=0, n2=0;
        for(String e:arr){
            if(e.equals("+")||e.equals("-")||e.equals("*")||e.equals("/")){
                n2=o.pop();
                n1=o.pop();
            }
            if(e.equals("+")){
                o.push(n1+n2);
            }else if(e.equals("-")){
                o.push(n1-n2);
            }else if(e.equals("*")){
                o.push(n1*n2);
            }else if (e.equals("/")){
                o.push(n1/n2);
            }else{
                o.push(Integer.parseInt(e));
            }
        }
        return o.peek();
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int t = Integer.parseInt(line);
        while (t-- > 0) {
            line = reader.readLine();
            String[] arr = line.split(" ");
            Solution solution = new Solution();
            System.out.println(solution.evaluate(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends