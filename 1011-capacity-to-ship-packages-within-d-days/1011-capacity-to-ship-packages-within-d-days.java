class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minDays = 0 , maxWeight = 0 , ans = 0 , max = weights[0] ;

        for(int i : weights){
            maxWeight += i;
            max = Math.max(max , i);
        }

        int low = max , high = maxWeight ;
        while(low <= high){
            int mid = low + (high - low)/2;
            int sum = 0 , day = 1 ;
            for(int n : weights){
                if(sum + n > mid){
                    day++ ;
                    sum = n ;
                }
                else sum += n ;
            }
            
            if(day <= days){
                ans = mid ;
                high = mid - 1 ;
            }else low = mid + 1 ;
        }

        return ans ;
    }
}