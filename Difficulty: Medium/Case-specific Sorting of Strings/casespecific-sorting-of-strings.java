class Solution {
    public static String caseSort(String s) {
        // code here
        ArrayList<Character> up=new ArrayList<>();
        ArrayList<Character> dow=new ArrayList<>();
        int n=s.length();
        for(int i=0; i<n; i++){
            char ch=s.charAt(i);
            if(ch>='a' && ch<='z'){
                dow.add(ch);
            }else{
                up.add(ch);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(s.charAt(i));
        }
        Collections.sort(up);
        Collections.sort(dow);
        int u=0, d=0;
        for(int i=0; i<n; i++){
            char ch=s.charAt(i);
            if(ch>='a' && ch<='z'){
                sb.setCharAt(i, dow.get(d++));
            }else{
                sb.setCharAt(i, up.get(u++));
            }
        }
        return sb.toString();
    }
}