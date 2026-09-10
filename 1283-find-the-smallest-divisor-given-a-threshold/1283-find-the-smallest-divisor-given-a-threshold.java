class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE ;

        for(int n : nums){
            max = Math.max(max , n);
        }

        int left = 1 , right = max , ans = 0 ;
        while(left <= right ){
            int mid = left + (right - left)/2;

            int sum = 0 ;
            for(int n : nums){
                sum += (n + mid - 1) / mid ;
            }

            if(sum <= threshold ){
                ans = mid;
                right = mid - 1 ;
            }else left = mid + 1 ;
        }

        return ans ;
    }
}