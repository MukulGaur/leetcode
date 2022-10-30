// 304. Range Sum Query 2D - Immutable

class NumMatrix {
    
    int[][] dp;

    public NumMatrix(int[][] M) {
        int yLen=M.length+1, xLen=M[0].length+1;
        dp = new int[yLen][xLen];
        for(int i=1; i<yLen; i++){
            for(int j=1; j<xLen; j++)
                dp[i][j] = M[i-1][j-1]+dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1];
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return (dp[row2+1][col2+1]-dp[row2+1][col1]-dp[row1][col2+1]+dp[row1][col1]);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
