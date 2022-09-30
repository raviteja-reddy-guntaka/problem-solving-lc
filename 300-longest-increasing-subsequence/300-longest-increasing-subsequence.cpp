class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        
        int n = nums.size();
        int lis[n], max_lis = 0;
        for (int i=0; i<n; i++) {
            lis[i] = 1;
            for (int j=i-1; j>=0; j--) {
                if (nums[j] < nums[i]) {
                    lis[i] = max(lis[i], 1+lis[j]);
                }
            }
            max_lis = max(max_lis, lis[i]);
        }
        return max_lis;
    }
};