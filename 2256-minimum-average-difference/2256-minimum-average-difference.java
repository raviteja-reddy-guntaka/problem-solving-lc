class Solution {
    public int minimumAverageDifference(int[] nums) {
        
        int n = nums.length;
        double prefixSum = 0, suffixSum = 0;
        for (int i=0; i<n; i++) {
            suffixSum += (double) nums[i];
        }
        double min = Double.MAX_VALUE;
        double avg = 0;
        int ans = 0;
        for (int i=0; i<n; i++) {
            prefixSum = prefixSum + (double)nums[i];
            suffixSum = suffixSum - (double)nums[i];
            avg = Math.floor(prefixSum/(i+1));
            if (n-i-1 != 0)
                avg = Math.abs(Math.floor(prefixSum/(i+1)) - Math.floor(suffixSum/(n-i-1)));
            if (min > avg) {
                min = avg;
                ans = i;
            }
        }
        return ans;
    }
}