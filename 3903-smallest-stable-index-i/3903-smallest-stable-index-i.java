class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length ;
        int leftMax[] = new int[n];
        int rightMin[] = new int[n];
        int max = nums[0] , min = nums[n-1] ;
        for(int i = 0 ; i < n ; i++){
            max = Math.max(max , nums[i]);
            min = Math.min(min , nums[n-1-i]);
            leftMax[i] = max;
            rightMin[n-1-i] = min;
        }

        for(int i = 0 ; i < n ; i++){
            if(leftMax[i] - rightMin[i] <= k) return i ;
        }

        return -1 ;
    }
}