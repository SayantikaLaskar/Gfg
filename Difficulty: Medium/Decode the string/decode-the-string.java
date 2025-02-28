//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s = in.readLine();

            Solution ob = new Solution();
            out.println(ob.decodeString(s));

            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends



class Solution {
    static String decodeString(String s) {
        // code here
         Stack<String> stackStr = new Stack<>();
        Stack<Integer> stackNum = new Stack<>(); 
        String ans="";
        int num = 0;
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                num = num*10 + (ch -'0');
            }
            else if(ch == '['){
                stackNum.push(num);
                stackStr.push(ans);
                ans="";
                num=0;
            }
            else if(ch == ']'){
                StringBuilder temp = new StringBuilder(stackStr.pop());
                int repeats = stackNum.pop();
                for(int i=0 ; i<repeats ; i++){
                    temp.append(ans);
                }
                ans = temp.toString();
            }
            else{
                ans += ch;
            }
        }
        return ans;
    }
}