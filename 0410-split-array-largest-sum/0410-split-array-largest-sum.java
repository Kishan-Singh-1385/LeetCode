class Solution {
    public int splitArray(int[] nums, int k) {
        long maxSum = 0 , ans = 0 , max = nums[0] ;

        for(int i : nums){
            maxSum += i;
            max = Math.max(max , i);
        }

        long low = max , high = maxSum ;
        while(low <= high){
            long mid = low + (high - low)/2;
            long sum = 0 , split = 1 ;
            for(int n : nums){
                if(sum + n > mid){
                    split++ ;
                    sum = n ;
                }
                else sum += n ;
            }
            
            if(split <= k){
                ans = mid ;
                high = mid - 1 ;
            }else low = mid + 1 ;
        }

        return (int)ans ;
    }
}