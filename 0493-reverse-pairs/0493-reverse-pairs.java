class Solution {
    long count = 0 ;

    void mergeSort(int[] arr , int left , int right){
        if(left < right){
            int mid = left + (right - left)/2 ;
            mergeSort(arr , left , mid);
            mergeSort(arr , mid + 1 , right);
            merge(arr , left , mid , right);
        }
    }

    void merge(int[] arr , int left , int mid , int right){
        int[] a = new int[right-left+1] ;
        int k = 0 , l = left , r = mid+1;
        int j = mid+1 ;
        for(int i = left ; i <= mid ; i++ ){
            while(j<=right && arr[i] > 2L * arr[j]){
                j++;
            }
            count += (j - (mid+1));
        }

        while(l <= mid && r <= right){
            if(arr[l] <= arr[r]){
                a[k++] = arr[l++];
            }else{
                a[k++] = arr[r++];
            }
        }

        while(l <= mid) a[k++] = arr[l++];
        while(r <= right) a[k++] = arr[r++];

        for(int i = 0 ; i < a.length ; i++){
            arr[i+left] = a[i] ;
        }
    } 
    public int reversePairs(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return (int)count ;
    }
}