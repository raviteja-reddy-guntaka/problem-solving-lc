class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        
        int n = s.length();
        
        int[][] dp = new int[n+1][k+1];
        
        for (int i=0; i<=n; i++) {
            for (int j=0; j<=k; j++) {
                // setting value greater than max string length
                dp[i][j] = 150;
            }
        }
        
        dp[0][0] = 0;
        
        for (int i=1; i<=n; i++) {
            for (int j=0; j<=k; j++) {
                
                int count = 0, del_count = 0 ;
                // not deleting current char
                for (int l=i; l>=1; l--) {
                    if (s.charAt(l-1) == s.charAt(i-1))
                        count++;
                    else
                        del_count++;
                    
                    if (j-del_count>=0) {
                        dp[i][j] = Math.min(dp[i][j], dp[l-1][j-del_count] 
                                            + 1 + (count>=100?3:count>=10?2:count>=2?1:0));
                    } else {
                        break;
                    }
                }
                if (j>0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
                }
                
            }
        }
        
        return dp[n][k]; 
    }
}