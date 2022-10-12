class Solution {
    public int oddEvenJumps(int[] arr) {
        
        int n = arr.length, count = 1;
        int[][] dp = new int[n][2];
        dp[n-1][0] = 1;
        dp[n-1][1] = 1;
        
        TreeMap<Integer, Integer> m = new TreeMap<>();
        m.put(arr[n-1], n-1);
        
        for (int i=n-2; i>=0; i--) {
            Integer min_ind = m.ceilingKey(arr[i]), max_ind = m.floorKey(arr[i]);
            
            // odd jump
            if (min_ind != null)
                dp[i][0] = dp[m.get(min_ind)][1];
            
            // even jump
            if (max_ind != null)
                dp[i][1] = dp[m.get(max_ind)][0];
            
            count += dp[i][0];
            m.put(arr[i], i);
        }
        return count;
    }
}