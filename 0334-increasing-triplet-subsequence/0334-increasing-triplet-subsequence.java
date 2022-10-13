class Solution {
    public boolean increasingTriplet(int[] nums) {
        
//         int n = nums.length;
//         int[] dp = new int[n];
//         int len = 0;
        
//         for (int x:nums) {
//             int idx = Arrays.binarySearch(dp, 0, len, x);
//             if (idx < 0)
//                 idx = -(idx+1);
//             dp[idx] = x;
//             if (idx == len)
//                 len++;
            
//             if (len==3)
//                 return true;
//         }
        
        int min = Integer.MAX_VALUE, s_min = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++) {
            if (nums[i]<=min)
                min = nums[i];
            else if (nums[i]<s_min)
                s_min = nums[i];
            else if (nums[i]>s_min)
                return true;
        }
        
        return false;
    }
}