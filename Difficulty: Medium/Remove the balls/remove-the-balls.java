class Solution {
    public int findLength(int[] color, int[] radius) {
        // code here
        Stack<Integer> s=new Stack<>();
        int n=color.length;
        for(int i=0; i<n; i++){
            if(!s.isEmpty()){
                if(color[i]==color[s.peek()] && radius[i]==radius[s.peek()]){
                    s.pop();
                }else{
                    s.push(i);
                }
            }else{
                s.push(i);
            }
        }
        return s.size();
    }
}