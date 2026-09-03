class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length ;
       int maxProd = nums[0] , currMax = nums[0] , currMin = nums[0] ;

       for(int i = 1 ; i < n ; i++){
            if(nums[i] < 0){
                int temp = currMax ;
                currMax = currMin ;
                currMin = temp ;
            }

            currMax = Math.max(nums[i] , nums[i] * currMax);
            currMin = Math.min(nums[i] , nums[i] * currMin);

            maxProd = Math.max(maxProd, currMax) ;
       }

       return maxProd ;
    }
}