class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        // Code here
        int[] p=new int[pat.length()+1];
        for(int i=1, s=0; i<pat.length();){
            if(pat.charAt(i)==pat.charAt(s)){
                p[i]=++s;
                i++;
            }else if(s>0) s=p[s-1];
            else i++;
        }
        ArrayList<Integer> l=new ArrayList<>();
        for(int i=0, s=0; i<txt.length();i++){
            if(txt.charAt(i)==pat.charAt(s)) s++;
            else{
                while(s>0){
                    s=p[s-1];
                    if(txt.charAt(i)==pat.charAt(s)){
                        s++;
                        break;
                    }
                }
            }
            if(s==pat.length()){
                l.add(i-s+2);
                s=p[s-1];
            }
        }
        return l;
    }
}