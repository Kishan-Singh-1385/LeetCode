class Solution {
    static void swap(int[] nums , int i  , int j){
        int temp = nums[i] ;
        nums[i] = nums[j];
        nums[j] = temp ;
    }

    static void reverse(int[] nums , int i , int j){
        while(i<j){
            int temp = nums[i] ;
            nums[i] = nums[j];
            nums[j] = temp ;
            i++;
            j--;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length ;
        if(n == 1) return ;

        int i = n - 2 ;
        while(i >= 0 && nums[i] >= nums[i+1]){
            i-- ;
        }

        int j = n - 1 ;
        if(i >= 0){
            while( j >= 0 && nums[j] <= nums[i]) j-- ;
            swap(nums , i , j);
        }

        reverse(nums , i+1 , n-1);
    }
}