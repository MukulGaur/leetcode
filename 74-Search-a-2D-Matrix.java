// Solution 2 - runtime 0ms | TC - O(logn)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int i=0, j=matrix[0].length-1;
        
        while(i<matrix.length && j>=0){
            if(matrix[i][j]==target)
                return true;
            else if(matrix[i][j]<target)
                i++;
            else
                j--;
        }
        
        return false;
        
    }
}

// Solution 1 - runtime 0ms | TC - O(n^2)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int col = matrix[0].length;
        int row = matrix.length;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j]==target)
                    return true;
            }
        }
        
        return false;
        
    }
}
