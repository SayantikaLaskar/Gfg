class Solution {
    public ArrayList<Integer> findGreater(int[] arr) {
        // code here
        HashMap<Integer,Integer>hm=new HashMap<>();
        ArrayList<Integer>res=new ArrayList<>();
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        Stack<int []>st=new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && st.peek()[1]<=hm.get(arr[i]))
            st.pop();
            if(st.isEmpty())
            res.add(-1);
            else
            res.add(st.peek()[0]);
            st.push(new int[]{arr[i],hm.get(arr[i])});
        }
        Collections.reverse(res);
        return res;
    }
}