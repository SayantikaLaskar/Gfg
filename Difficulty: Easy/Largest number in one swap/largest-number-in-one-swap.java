class Solution {
    public String largestSwap(String s) {
        // code here
        char m='0';
        int v=-1;
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            if(c>=m){
                m=c;
                v=i;
            }
        }
        StringBuilder r=new StringBuilder(s);
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            if(i!=v && m!=c){
                char d=r.charAt(i);
                r.setCharAt(i, m);
                r.setCharAt(v, d);
                break;
            }
        }
        return r.toString().compareTo(s)>=0?r.toString():s;
    }
}