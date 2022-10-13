class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        int len = 0;
        
        for (int x:nums) {
            int idx = Arrays.binarySearch(dp, 0, len, x);
            if (idx < 0)
                idx = -(idx+1);
            dp[idx] = x;
            if (idx == len)
                len++;
            
            if (len==3)
                return true;
        }
        
        return false;
    }
}