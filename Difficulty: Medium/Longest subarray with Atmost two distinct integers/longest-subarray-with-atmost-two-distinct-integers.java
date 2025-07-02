class Solution {
    public int totalElements(int[] arr) {
        // code here
        int l=0, m=0;
        HashMap<Integer, Integer> mp=new HashMap<>();
        for(int i=0; i<arr.length; i++){
            mp.put(arr[i], mp.getOrDefault(arr[i], 0)+1);
            while(mp.size()>2){
                mp.put(arr[l], mp.get(arr[l])-1);
                if(mp.get(arr[l])==0){
                    mp.remove(arr[l]);
                }
                l++;
            }
            m=Math.max(m, i-l+1);
        }
        return m;
    }
}