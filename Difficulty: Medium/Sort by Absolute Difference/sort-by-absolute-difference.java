class Solution {
    public void rearrange(int[] arr, int x) {
        // code here
        Integer[] t=Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(t, (a, b)->{
            int d1=Math.abs(a-x);
            int d2=Math.abs(b-x);
            return Integer.compare(d1, d2);
        });
        for(int i=0; i<arr.length; i++){
            arr[i]=t[i];
        }
    }
}
