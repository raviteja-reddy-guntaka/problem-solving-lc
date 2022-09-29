class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        if (n==1)
            return nums[0];
        int amounts[n];
        amounts[0] = nums[0];
        amounts[1] = max(nums[0], nums[1]);
        for (int i=2; i<n; i++) {
            amounts[i] = max(amounts[i-1], nums[i]+amounts[i-2]);
        }
        return amounts[n-1];
    }
};