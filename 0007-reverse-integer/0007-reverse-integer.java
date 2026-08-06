class Solution {
    public int reverse(int x) {
        boolean neg = false ; 
        if(x < 0){
            neg = true ;
            x = -x ;
        }
        int n = x ;
        int prevRev = 0 , rev = 0 ;
        while(n > 0){
            int currDigit = n % 10 ;
            rev = rev * 10 + currDigit ;

            if((rev - currDigit) / 10 != prevRev ) return 0 ;

            prevRev = rev ;
            n /= 10 ;
        } 
        if(neg)
            return -rev;
        else return rev ;
    }
}