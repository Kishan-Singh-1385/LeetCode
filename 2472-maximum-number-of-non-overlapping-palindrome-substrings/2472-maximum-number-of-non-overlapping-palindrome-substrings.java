class Solution {
    boolean isPalindrome(String s , int i , int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j-- ;
        }

        return true ;
    }

    int solve(String s , int k , int i , int[] memo ){
        if(i + k > s.length() ) return 0 ;

        if(memo[i] != -1) return memo[i] ;

        int maxPalindrome = solve(s,k,i+1,memo);

        for(int j = i + k - 1 ; j < s.length() ; j++){
            if(isPalindrome(s,i,j)){
                maxPalindrome = Math.max(maxPalindrome , 1 + solve(s,k,j+1,memo));
                break;
            }
        }

        return memo[i] = maxPalindrome ;
    }
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        if(k == 1) return n ;

        int memo[] = new int[n+1] ;
        Arrays.fill(memo , -1);

        return solve(s,k,0, memo);
    }
}