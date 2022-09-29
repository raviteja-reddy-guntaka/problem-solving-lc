class Solution {
public:
    int numSquares(int n) {
        
        int dp[n+1];
        fill_n(dp, n+1, INT_MAX);
        dp[0] = 0;
        dp[1] = 1;
        
        for (int i=2; i<=n; i++) {
            for (int j=sqrt(i); j>=1; j--) {
                dp[i] = min(dp[i], 1+dp[i-j*j]);
            }
        }
        
        return dp[n];
    }
};