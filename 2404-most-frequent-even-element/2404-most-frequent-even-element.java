class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer,Integer> freqMap = new HashMap<>() ;

        for(int num : nums){
            if(num % 2 == 0){
                freqMap.put(num , freqMap.getOrDefault(num , 0)+1);
            }
        }
        int max = 0 ;
        int mostFreq = -1 ;
        for(int key : freqMap.keySet()){
            // Math.max(max , freqMap.get(key));
            int freq = freqMap.get(key) ;
            if( freq > max){
                mostFreq = key ;
                max = freq;
            }
            else if(freq == max){
                mostFreq = Math.min(mostFreq , key);
            }
        }

        return mostFreq ;
    }
}