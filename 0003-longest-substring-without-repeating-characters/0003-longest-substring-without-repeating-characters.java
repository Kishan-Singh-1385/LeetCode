class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        boolean chars[] = new boolean[128];
        
        int maxLen = 1, left = 0, right = 1 ;
        chars[s.charAt(0)] = true;
        while(right < s.length()){
            while(chars[s.charAt(right)]){
                chars[s.charAt(left)] = false ;
                left++ ;
            }
            chars[s.charAt(right)] = true ;
            maxLen = Math.max(maxLen , right-left+1);
            right++ ;
        }

        return maxLen ;
        
    }
}