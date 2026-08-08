class Solution {
    int findFirst(int[] nums, int target){
        int low = 0 , high = nums.length - 1 ;
        int ans = -1 ;
        while(low<=high){
            int mid = low + (high-low)/2 ;
            if(nums[mid] == target){
                high = mid - 1 ;
                ans = mid ;
            }
            else if(nums[mid] < target){
                low = mid +1 ;
            }else{
                high = mid -1 ;
            }
        }
        return ans ;
    }
    int findSecond(int[] nums, int target){
        int low = 0 , high = nums.length - 1 ;
        int ans = -1 ;
        while(low<=high){
            int mid = low + (high-low)/2 ;
            if(nums[mid] == target){
                low = mid + 1 ;
                ans = mid ;
            }
            else if(nums[mid] < target){
                low = mid +1 ;
            }else{
                high = mid -1 ;
            }
        }
        return ans ;
    }
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findFirst(nums,target),findSecond(nums,target)} ;
    }
}