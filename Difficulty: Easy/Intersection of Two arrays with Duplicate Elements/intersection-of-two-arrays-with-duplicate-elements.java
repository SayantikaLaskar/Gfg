class Solution {
    public ArrayList<Integer> intersect(int[] a, int[] b) {
        // code here
        ArrayList<Integer> list=new ArrayList<>();
        int i=0;
        int j=0;
        Arrays.sort(a);
        Arrays.sort(b);
        while(i<a.length && j<b.length){
            if(a[i]==b[j]){
                if(list.size()==0||list.get(list.size()-1)!=a[i]){
                    list.add(a[i]);
                }
                i++;
                j++;
            }else if(a[i]<b[j]){
                i++;
            }else{
                j++;
            }
          
        }
        return list;
    }
}