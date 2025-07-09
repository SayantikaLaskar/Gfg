class Solution {
    public int sumSubMins(int[] arr) {
        // code here
        int mod=1000000007;
        long c=0;
        int[] nextSm=nextSmaller(arr);
        int[] prevSm=prevSmaller(arr);
        for(int i=0; i<arr.length; i++){
            int f=i-prevSm[i];
            int s=nextSm[i]-i;
            long p=(f*s)%mod;
            p=(p*arr[i])%mod;
            c=(c%mod+p)%mod;
        }
        return (int)c;
    }
    private int[] nextSmaller(int[] arr){
        Stack<Integer> st=new Stack<>();
        int[] a=new int[arr.length];
        for(int i=arr.length-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                a[i]=arr.length;
            }else{
                a[i]=st.peek();
            }
            st.push(i);
        }
        return a;
    }
    private int[] prevSmaller(int[] arr){
        Stack<Integer> st=new Stack<>();
        int[] a=new int[arr.length];
        for(int i=0; i<arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                a[i]=-1;
            }else{
                a[i]=st.peek();
            }
            st.push(i);
        }
        return a;
    }
}
