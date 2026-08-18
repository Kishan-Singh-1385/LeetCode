class Solution {
    public int largestInteger(int[] nums, int k) {
        int freq[] = new int[51];
        for(int i = 0 ; i < nums.length ; i++){
                freq[nums[i]]++ ;
            }

        if(nums.length == k){
           for(int i = 50 ; i >= 0 ; i--){
                if(freq[i] > 0) return i ;
            } 
        }

        if(k == 1){
           for(int i = 50 ; i >= 0 ; i--){
                if(freq[i] == 1) return i ;
            }
            return -1 ; 
        }

        int max = -1 ;
        if(freq[nums[0]] == 1) max = Math.max(max ,nums[0] );
        if(freq[nums[nums.length - 1]] == 1) max = Math.max(max ,nums[nums.length - 1]);

        return max ;
    }
}