class Solution {
    public int findKthPositive(int[] arr, int k) {
        int min = 0 , max = arr.length - 1 ;

        while(min <= max){
            int mid = min + (max - min)/2 ;
            int missing = arr[mid] - (mid + 1) ;

            if(missing < k) min = mid + 1 ;
            else max = mid - 1 ;
        }

        return min + k ;

    }
}