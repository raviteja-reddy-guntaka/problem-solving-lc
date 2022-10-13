class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int[] dp = new int[nums.length];
        int len = 0;
        
        for (int x: nums) {
            int idx = Arrays.binarySearch(dp, 0, len, x);
            if (idx<0)
                idx = -(idx+1);
            
            dp[idx] = x;
            if (idx==len)
                len++;
        }
        return len;
    }
}