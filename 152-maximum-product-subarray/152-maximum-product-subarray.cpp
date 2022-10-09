class Solution {
public:
    int maxProduct(vector<int>& nums) {
        
        int dp[nums.size()][2], max_p = nums[0];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        
        for (int i=1; i<nums.size(); i++) {
            int up = dp[i-1][0]*nums[i], down = dp[i-1][1]*nums[i];
            dp[i][0] = max(up, max(nums[i], down));
            dp[i][1] = min(up, min(nums[i], down));
            max_p = max(max_p, dp[i][0]);
        }
        return max_p;
    }
};