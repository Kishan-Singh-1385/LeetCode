class Solution {
    public int missingInteger(int[] nums) {
        boolean[] exist = new boolean[51];
        int sum = nums[0] ;

        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i-1] + 1 == nums[i]) sum += nums[i] ;
            else break ;
        }
        for(int num : nums){
            if(num <= 50) exist[num] = true ;
        }

        if(sum > 50) return sum ;

        while(sum < 51 && exist[sum]){
            sum++;
        }

        return sum ;
    }
}