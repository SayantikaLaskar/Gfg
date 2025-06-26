class Solution {
    public int minValue(String s, int k) {
        // code here
        int[] f=new int[26];
        for(char c:s.toCharArray()){
            f[c-'a']++;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>((a, b)->b-a);
        for (int i = 0; i < 26; i++) {
            if (f[i] > 0) pq.add(f[i]);
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int top = pq.poll();
            pq.add(top - 1);
        }
        int sum=0;
        while(!pq.isEmpty()){
            int n=pq.poll();
            sum+=n*n;
        }
        return sum;
    }
}