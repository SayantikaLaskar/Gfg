class Solution {
    public int minParentheses(String s) {
        // code here
        Stack<Character> st=new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            if(st.size()>=1){
                if(st.peek()=='(' && c==')'){
                    st.pop();
                }else{
                    st.add(c);
                }
            }else{
                st.add(c);
            }
        }
        return st.size();
    }
}
