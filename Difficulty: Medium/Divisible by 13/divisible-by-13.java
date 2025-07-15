import java.math.BigInteger;
class Solution {
    public boolean divby13(String s) {
        // code here
         int n=s.length();
        if(n<2){
            return false;
        }
        int pre=0;
        int it=n;
         int num=0;
        while(it>0){
          
            if(num<13){
                
               int val=s.charAt(n-it)-'0';
               it--;
               num=(num*10)+val;
             
               continue;
            }
             num=num%13;
             
        }
        
        if(num%13==0){
            return true;
            
        }
        return false;
    }
}