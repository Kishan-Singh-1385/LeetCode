class Solution {
    public boolean check(int[] nums) {
        int size = nums.length ;
        if(size == 1) return true ;

        int start = 1 ; 
        while(start < size && nums[start-1] <= nums[start]) start++ ;
        if(start == size) return true ;
        
        for(int i = 1 ; i < size ; i++){
            if(nums[start] > nums[(start + 1)%size]) return false ;
            start = (start + 1)%size ; 
        }

        return true ;
    }
}