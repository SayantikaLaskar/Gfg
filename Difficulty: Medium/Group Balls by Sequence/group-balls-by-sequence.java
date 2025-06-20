class Solution {
    public boolean validgroup(int[] arr, int k) {
        // code here
        int n=arr.length;
        if(n%k!=0) return false;
        TreeMap<Integer, Integer> cm=new TreeMap<>();
        for(int num:arr){
            cm.put(num, cm.getOrDefault(num, 0)+1);
        }
        while(!cm.isEmpty()){
            int f=cm.firstKey();
            for(int i=0; i<k; i++){
                int nm=f+i;
                if(!cm.containsKey(nm)){
                    return false;
                }
                cm.put(nm, cm.get(nm)-1);
                if(cm.get(nm)==0){
                    cm.remove(nm);
                }
            }
        }
        return true;
    }
}