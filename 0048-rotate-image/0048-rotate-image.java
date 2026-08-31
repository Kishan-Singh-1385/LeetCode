class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length , col = matrix[0].length ;

        for(int i = 0 ; i < row ; i++){
            for(int j = i+1 ; j < col ; j++){
                int temp = matrix[i][j] ;
                matrix[i][j] = matrix[j][i] ;
                matrix[j][i] = temp ;
            }
        }

        int l = 0 , r = col - 1 ;
        while(l < r){
            for(int i = 0 ; i < row ; i++){
                int temp = matrix[i][l] ;
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp ;
            }
            l++;
            r--;
        } 
    }
}