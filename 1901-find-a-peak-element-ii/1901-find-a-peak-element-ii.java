class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int row = mat.length ;
        int start = 0 , end = row -1 ;
        
        while(start <= end){
            int mid = start + (end - start)/2;
            
            int maxCol = 0;
            for(int k = 0 ; k < mat[mid].length ; k++){
                if(mat[mid][k] > mat[mid][maxCol]){
                    maxCol = k ;
                }
            }
            
            int top = (mid == 0) ? -1 : mat[mid-1][maxCol] ;
            int bottom = (mid == row - 1) ? -1 : mat[mid+1][maxCol] ;
            
            if(mat[mid][maxCol] > top && mat[mid][maxCol] > bottom ) 
                return new int[]{mid,maxCol};
            
            if( mat[mid][maxCol] < top) end = mid - 1 ;
            else start = mid +1 ;
        }
        
        return new int[]{0,0} ;
    }
}