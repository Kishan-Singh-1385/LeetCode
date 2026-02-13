class Solution {
    public int pivotIndex(int[] nums) {
        int sufixSum = 0 ;
        int prifixSum = 0;
        for(int i : nums){
            sufixSum += i ;
        }

        for(int i = 0 ; i < nums.length ; i++){

            sufixSum -= nums[i] ;
            if(prifixSum == sufixSum) return i;
            prifixSum += nums[i] ;
        }
       return -1;
    }    
}