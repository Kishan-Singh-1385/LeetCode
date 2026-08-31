class Solution {
    public void setZeroes(int[][] matrix) {
        Queue<int[]> que = new LinkedList<>();
        int row = matrix.length , col = matrix[0].length ;

        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(matrix[i][j] == 0) que.offer(new int[]{i,j}) ;
            }
        }

        while(!que.isEmpty()){
            int r = que.peek()[0] ;
            int c = que.peek()[1] ;
            que.poll();

            for(int j = 0 ; j < col ; j++){
                matrix[r][j] = 0 ;
            }
            
            for(int j = 0 ; j < row ; j++){
                matrix[j][c] = 0 ; 
            }
        }
    }
}