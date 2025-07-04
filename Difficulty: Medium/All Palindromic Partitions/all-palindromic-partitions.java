class Solution {
     static boolean check(int i,int j,String str,int[][] dp){
        if(dp[i][j]!=0) return dp[i][j]==1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                dp[i][j]=-1;
                return false;
            }
            i++; j--;
        }
        dp[i][j]=1;
        return true;
    }
    static void find(ArrayList<String> li,int n,String str,ArrayList<ArrayList<String>> ans,int prev,int[][] dp){
        if(prev==n){
            ans.add(new ArrayList<String>(li));
            return;
        }
        for(int j=prev;j<n;j++){
            if(check(prev,j,str,dp)){
                li.add(str.substring(prev,j+1));
                find(li,n,str,ans,j+1,dp);
                li.remove(li.size()-1);
            }
        }
    }

    public ArrayList<ArrayList<String>> palinParts(String s) {
        // code here
        ArrayList<ArrayList<String>> ans=new ArrayList<ArrayList<String>>();
        int[][] dp=new int[s.length()][s.length()];
        find(new ArrayList<String>(),s.length(),s,ans,0,dp);
        return ans;
    }
}
