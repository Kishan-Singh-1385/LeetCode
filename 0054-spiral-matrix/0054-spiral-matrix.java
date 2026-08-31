class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length , n = matrix[0].length ;
        List<Integer> list = new ArrayList<>();
        boolean[][] visited = new boolean[m][n] ;
        int totalCells = m * n ;
        int direc = 0 , i = 0 , j = 0 ;
        list.add(matrix[0][0]);
        visited[0][0] = true ;
        totalCells-- ;
        while(totalCells > 0){
            
            if(direc == 0 && j + 1 < n && !visited[i][j+1]){
                j++;
            }else if(direc == 1 && i + 1 < m && !visited[i+1][j]){
                i++;
            }else if(direc == 2 && j - 1 >= 0 && !visited[i][j-1]){
                j--;
            }else if(direc == 3 && i - 1 >= 0 && !visited[i-1][j]){
                i--;
            }else{
                direc = (direc + 1) % 4 ;
                continue ;
            } 
            
            list.add(matrix[i][j]);
            visited[i][j] = true;
            totalCells-- ;
        }

        return list ;
    }
}