class Solution {
    public ArrayList<String> binstr(int n) {
        // code here
        Queue<String>q = new ArrayDeque<>(Arrays.asList("0", "1"));
        int x = 1;
        
        while(!q.isEmpty()) {
            if(x == n) {
                break;
            }
            int y = q.size();
            for(int i=0;i<y;i++) {
                String s = q.poll();
                q.offer(s+"0");
                q.offer(s+"1");
            }
            x++;
        }
        
        ArrayList<String>ans = new ArrayList<>();
        while(!q.isEmpty()) ans.add(q.poll());
        
        return ans;
    }
}
