class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        ArrayList<Integer> al=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int j=0;
        while(j<n){
            while(!st.isEmpty() && arr[st.peek()]<=arr[j]){
                st.pop();
            }
            if(st.isEmpty()){
                al.add(j+1);
            }else{
                al.add(j-st.peek());
            }
            st.push(j);
            j++;
        }
        return al;
    }
}