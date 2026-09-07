class Solution {
    public int distinctSubseqII(String s) {
        int mod = 1000000007 ;
        int endsWith[] = new int[26];

        for (char c : s.toCharArray()){
            int previosTotal = 0 ;

            for( int n : endsWith){
                previosTotal = (previosTotal + n) % mod ;
            }

            endsWith[c - 'a'] = (previosTotal + 1) % mod ;
        }

        int totalWays = 0 ;
        for(int n : endsWith){
            totalWays = (totalWays + n) % mod ;
        }

        return totalWays ;
    }
}