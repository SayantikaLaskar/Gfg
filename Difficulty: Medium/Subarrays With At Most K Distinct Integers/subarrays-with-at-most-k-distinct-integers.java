class Solution {
    public int countAtMostK(int arr[], int k) {
        // code here
        HashMap<Integer, Integer> m=new HashMap<>();
        int i=0, j=0, a=0, n=arr.length;
        while(j<n){
            m.put(arr[j], m.getOrDefault(arr[j], 0)+1);
            while(i<=j && m.size()>k){
                m.put(arr[i], m.get(arr[i])-1);
                if(m.get(arr[i])==0) m.remove(arr[i]);
                i++;
            }
            a+=j-i+1;
            j++;
        }
        return a;
    }
}
