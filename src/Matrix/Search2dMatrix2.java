package Matrix;

// O(m+n)
public class Search2dMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length  == 0 )
            return false;

        int row = 0;
        int col = matrix[0].length-1;

        while(row <= matrix.length-1 && col >= 0) {
            if(matrix[row][col] == target) {
                return true;
            } else if(matrix[row][col] < target) {
                row++;
            } else if(matrix[row][col] > target) {
                col--;
            }
        }
        return false;
    }

}
