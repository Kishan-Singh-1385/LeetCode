class Solution {
    int[] tree;

    boolean isPeak(int[] nums , int i){
        if(i <= 0 || i >= nums.length - 1) return false;
        return nums[i] > nums[i-1] && nums[i] > nums[i+1] ;
    }

    void buildTree(int node ,int start , int end , int[] peaks){
        if(start == end){
            tree[node] = peaks[start] ;
            return ;
        }

        int mid = start + (end - start) / 2;
        buildTree(node * 2 + 1,start , mid , peaks);
        buildTree(node * 2 + 2, mid+1 , end , peaks);
        tree[node] = tree[node * 2 + 1] + tree[node * 2 + 2] ;
    }

    void updateTree(int node , int start , int end , int idx , int val){
        if(start == end){
            tree[node] = val ;
            return ;
        }
        int mid = start + (end - start)/2 ;

        if(idx >= start && idx <= mid ){
            updateTree(2 * node + 1 , start , mid , idx , val);
        }else{
            updateTree(2 * node + 2 , mid +1 , end , idx , val);
        }
        tree[node] = tree[node * 2 + 1] + tree[node * 2 + 2] ; 
    }

    int query(int node , int start , int end , int L , int R){
        if( R < start || end < L) return 0 ;
        if( L <= start && R >= end) return tree[node] ;

        int mid = start + (end - start)/2 ;
        return query(2 * node + 1 , start , mid , L , R) +
        query(2 * node + 2 , mid + 1 , end , L , R);
    }

    public List<Integer> countOfPeaks(int[] nums, int[][] queries){
        List<Integer> result = new ArrayList<>();
        int n = nums.length ;
        tree = new int[4*n] ;
        int[] peaks = new int[n];

        for(int i = 1 ; i < nums.length - 1 ; i++){
            if(isPeak(nums , i)) peaks[i] = 1 ;
        }

        if(n > 0) buildTree(0 , 0 , n -1 , peaks);

        for( int[] q : queries){
            if(q[0] == 1){
                int l = q[1] , r = q[2] ;
                if(l+1 <= r-1) result.add(query(0,0,n-1,l+1,r-1));
                else result.add(0);
            }else{
                int idx = q[1] , val = q[2] ;
                nums[idx] = val;

                for(int i = idx -1 ; i <= idx+1 ; i++){
                    if(i > 0 && i < n-1){
                        int newStatus = isPeak(nums , i) ? 1 : 0 ;
                        if(peaks[i] != newStatus){
                            peaks[i] = newStatus ;
                            updateTree(0,0,n-1,i,newStatus);
                        }
                    }
                }
            }
        }
        return result ;
    }
}