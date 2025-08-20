class Solution {
    public boolean searchMatrix(int[][] mat, int x) {
        // code here
        boolean f=false;
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(x==mat[i][j]){
                    f=true;
                    break;
                }
            }
        }
        return f;
    }
}