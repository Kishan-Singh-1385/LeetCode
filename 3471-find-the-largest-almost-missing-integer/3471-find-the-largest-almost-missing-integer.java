class Solution {
    public int largestInteger(int[] nums, int k) {
        int freq[] = new int[51];
        int l = 0 , r = k - 1 ;

        while(r < nums.length){
            boolean seenInWin[] = new boolean[51];
            for(int i = l ; i <= r ; i++){
                if(!seenInWin[nums[i]]){
                    seenInWin[nums[i]] = true ;
                    freq[nums[i]]++ ;
                }
            }
            l++;
            r++;
        }

        for(int i = 50 ; i >= 0 ; i--){
            if(freq[i] == 1) return i ;
        }

        return -1 ;
    }
}