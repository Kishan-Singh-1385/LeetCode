class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        if(nums.length <= 1) return nums.length ;

        for(int i = 0 ; i < nums.length ; i++){
            set.add(nums[i]);
        }

        int longestSeq = 0 , count = 0 ; 
        for(int n : set){
            if(!set.contains(n-1)){
                int start = n ;
                while(set.contains(start)){
                    count++;
                    start++;
                }
                longestSeq = Math.max(longestSeq , count);
                count = 0 ;
            }
        }

        return longestSeq ;
    }
}