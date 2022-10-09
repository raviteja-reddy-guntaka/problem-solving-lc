class Solution {
public:
    int maxProduct(vector<int>& nums) {
        
        int dp[nums.size()+1][2], max_p = INT_MIN;
        dp[0][0] = 1;
        dp[0][1] = 1;
        
        for (int i=1; i<=nums.size(); i++) {
            int up = dp[i-1][0]*nums[i-1], down = dp[i-1][1]*nums[i-1];
            dp[i][0] = max(up, max(nums[i-1], down));
            dp[i][1] = min(up, min(nums[i-1], down));
            max_p = max(max_p, dp[i][0]);
        }
        return max_p;
    }
};