class Solution {
public:
    vector<int> countBSTs(vector<int>& arr) {
        int n = arr.size();
        const long long MOD = 1e9 + 7;
        vector<long long> dp(n + 1, 0);
        dp[0] = dp[1] = 1;

        // Precompute Catalan numbers up to n
        for (int i = 2; i <= n; i++) {
            for (int k = 1; k <= i; k++) {
                dp[i] = (dp[i] + dp[k - 1] * dp[i - k]) % MOD;
            }
        }

        unordered_map<int,int>mp;
        vector<int>temp=arr;
        sort(arr.begin(),arr.end());
        for(int i=0;i<n;i++){
            mp[arr[i]]=i;
        }
        vector<int> ans(n);

        // For each element, compute left and right subtree sizes
        for (int i = 0; i < n; i++) {
            int e=temp[i];
            int left = mp[e];           // elements smaller
            int right = n - mp[e] - 1;  // elements greater
            ans[i] = (dp[left] * dp[right]) % MOD;
        }

        return ans;
    }
};