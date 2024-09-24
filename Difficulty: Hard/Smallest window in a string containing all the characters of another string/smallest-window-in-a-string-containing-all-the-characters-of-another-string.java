//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        // Your code here
        int n1=s.length(),n2=p.length();
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        
        for(int i=0;i<n2;i++){
            map1[p.charAt(i)-'a']++;
        }
        
        int min=Integer.MAX_VALUE;
        String str="";
        int i=0;
        for(int j=0;j<n1;j++){
            map2[s.charAt(j)-'a']++;
            while(i<=j&&check(map1,map2)){
                if((j-i)<min){
                    min=j-i;
                    str=s.substring(i,j+1);
                }
                map2[s.charAt(i)-'a']--;
                i++;
            }
        }
        return str.length()==0?"-1":str;
    }
    public static boolean check(int[] map1,int[] map2){
        for(int i=0;i<26;i++){
            if(map1[i]!=0&&map1[i]>map2[i]) return false;
        }
        return true;
    }
}