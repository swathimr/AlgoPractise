package Matrix;

import java.util.ArrayList;
import java.util.List;

// time and space O(n)
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if(matrix.length == 0)
            return result;

        int m = matrix.length;
        int n = matrix[0].length;

        int rowBegin = 0;
        int rowEnd = m -1;
        int colBegin = 0;
        int colEnd = n - 1;

        while(rowBegin<=rowEnd && colBegin<=colEnd) {
            // traverse right
            for(int j=colBegin;j<=colEnd;j++) {
                result.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            // traverse down
            for(int j=rowBegin;j<=rowEnd;j++) {
                result.add(matrix[j][colEnd]);
            }

            colEnd--;

            // traverse left
            if(rowBegin<=rowEnd) {
                for(int j=colEnd;j>=colBegin;j--) {
                    result.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            // traverse right
            if(colBegin<=colEnd) {
                for(int j=rowEnd;j>=rowBegin;j--) {
                    result.add(matrix[j][colBegin]);
                }
            }
            colBegin++;
        }

        return result;
    }

}
