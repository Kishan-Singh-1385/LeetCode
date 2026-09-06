class Solution {
    
    int solve(String s , String t , int m , int n , int[][] memo){
        if(n == t.length()){
            return 1;
        } 
        if(m == s.length()) return 0 ;
        if(memo[m][n] != -1) return memo[m][n] ;

        int totalWays = solve(s, t , m+1 , n , memo);

        if(s.charAt(m) == t.charAt(n)){
            totalWays += solve(s , t , m+1 , n+1 , memo);
        }

        memo[m][n] = totalWays;
        return totalWays ;    
    }

    public int numDistinct(String s, String t) {
        int memo[][] = new int[s.length()][t.length()];

        for(int[] row : memo){
            Arrays.fill(row , -1);
        }

        return solve(s,t,0, 0,memo);
        
    }
}