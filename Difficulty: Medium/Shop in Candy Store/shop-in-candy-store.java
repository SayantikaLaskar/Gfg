class Solution {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        // code here
        int n=prices.length;
        ArrayList<Integer> a=new ArrayList<>();
        Arrays.sort(prices);
        int t=(n+k)/(k+1);
        int m=0, ma=0;
        for(int i=0; i<t; i++){
            m+=prices[i];
            ma+=prices[n-1-i];
        }
        a.add(m);
        a.add(ma);
        return a;
    }
}
