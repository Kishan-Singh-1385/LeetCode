class Solution {
    public boolean check(int[] nums) {
        int size = nums.length ;
        int drop = 0 ; 

        for(int i = 0 ; i < size ; i++){
            if(nums[i] > nums[(i + 1)%size]) drop++ ;
            if(drop > 1){
                return false ;
            } 
        }

        return true ;
    }
}