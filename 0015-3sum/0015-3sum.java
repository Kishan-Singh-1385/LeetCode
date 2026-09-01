class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int x , y , z ;
        int sum = 0 ;
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length ; i++){
            x = nums[i] ;
            if(x > 0) break ;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1 , k = nums.length - 1 ;
            while(j < k){
                y = nums[j] ;
                z = nums[k] ;
                if((x + y + z) == 0 ){
                    list.add(new ArrayList<>(List.of(x,y,z)));

                    while(j < k && nums[j] == nums[j+1]) j++ ;
                    while(j < k && nums[k] == nums[k-1]) k-- ;

                    j++;
                    k--;
                } 
                else if((x + y + z) > 0 ) k--;
                else j++ ;
            }
        }

        return list ;
    }
}