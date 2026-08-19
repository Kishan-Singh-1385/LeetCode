class Solution {
    public int[] rearrangeArray(int[] nums) {
        int reaArray[] = new int[nums.length];
        int p = 0 , n = 1 ;
        
        for(int i : nums){
            if(i > 0){
                reaArray[p] = i ;
                p += 2 ;
            } 
            else{
                reaArray[n] = i ;
                n += 2 ;
            } 
        }

        return reaArray;
    }
}