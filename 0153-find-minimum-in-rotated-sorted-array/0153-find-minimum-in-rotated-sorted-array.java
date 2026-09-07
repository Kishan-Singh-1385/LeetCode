class Solution {
    public int findMin(int[] nums) {
        int left= 0 ,right = nums.length- 1 ;
        int ans= nums[0];

        while(left <= right){
            int mid = left+ (right - left)/2;

            if(nums[mid]  < ans) ans = nums[mid];
            if(nums[left] <= nums[mid]){
                ans = Math.min(nums[left], ans);
                left = mid + 1 ;
            }else{
                ans = Math.min(ans, nums[mid+1]);
                right = mid - 1;
            }
        }

        return ans ;
    }
}