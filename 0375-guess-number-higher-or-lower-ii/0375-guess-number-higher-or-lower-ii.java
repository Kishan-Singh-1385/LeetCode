class Solution {
    public int getMoneyAmount(int n) {
        int memo[][] = new int[n+1][n+1];
       return solve(1,n,memo);
    }

    int solve(int start , int end , int[][] memo){
        if(start >= end) return 0 ;
        if(memo[start][end] != 0 ) return memo[start][end] ;

        int minCost = Integer.MAX_VALUE ;

        for(int i  = start ; i <= end ; i++){
            int leftCost = solve(start,i-1,memo);
            int rightCost = solve(i+1,end,memo);

            int currCost = i + Math.max(leftCost , rightCost);
            
            minCost = Math.min(minCost,currCost) ;
        }
        memo[start][end] = minCost ;
        return minCost ;
    }
}