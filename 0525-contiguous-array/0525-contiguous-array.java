class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> sumMap = new HashMap<>();
        int sum  = 0;
        int longest = 0 ;
        sumMap.put(0 , -1);

        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 0) sum += -1 ;
            else sum += nums[i];

            if(sumMap.containsKey(sum)){
                longest = Math.max(longest , i - sumMap.get(sum));
            }
            else {
                sumMap.put(sum , i) ;
            }
        }

        if(sum == 0) return nums.length ;
        else return longest ;
    }
}