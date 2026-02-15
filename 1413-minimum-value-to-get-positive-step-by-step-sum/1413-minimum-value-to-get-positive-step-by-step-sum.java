class Solution {
    public int minStartValue(int[] nums) {
        int preSum = 0 ;
        int min = 0 ;
           
        for(int i : nums ){
            preSum += i ;
            if( preSum < min) min = preSum ;
        }
        
        return (int)Math.max(1 , 1 - min);
        
    }
}