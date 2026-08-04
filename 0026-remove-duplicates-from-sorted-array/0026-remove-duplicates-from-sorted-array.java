class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1 ;
        int i = 1 ;

        while( i < nums.length ){
            if(nums[i] == nums[i-1]){
                while(i < nums.length && nums[i-1] == nums[i]) i++ ;
            }else {
                nums[k] = nums[i] ; 
                i++;
                k++;
            }
        }
        return k ;
    }
}