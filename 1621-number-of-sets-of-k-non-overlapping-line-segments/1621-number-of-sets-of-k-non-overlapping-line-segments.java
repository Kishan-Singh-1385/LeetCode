class Solution {
    public int numberOfSets(int n, int k) {
        int MOD = 1_000_000_007;
        
        int[] dp = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
        }
        
        for (int j = 1; j <= k; j++) {
            
            int[] nextDp = new int[n + 1];
            int runningSum = 0;
           
            for (int i = 2; i <= n; i++) {
            
                runningSum = (runningSum + dp[i - 1]) % MOD;
            
                nextDp[i] = (nextDp[i - 1] + runningSum) % MOD;
            }
            
            dp = nextDp;
        }
        
        return dp[n];
    }
    
}