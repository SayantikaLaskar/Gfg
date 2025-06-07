
class Solution {
    public int longestCommonSum(int[] a1, int[] a2) {
        // Code here
        HashMap<Integer, Integer> m=new HashMap<>();
        m.put(0,-1);
        int s=0, a=0;
        for(int i=0; i<a1.length; i++){
            s+=(a1[i]-a2[i]);
            m.put(s, m.getOrDefault(s, i));
            a=Math.max(a, i-m.get(s));
        }
        return a;
    }
}