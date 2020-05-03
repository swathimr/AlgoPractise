package Matrix;

public class Search2DMatrix                                                                         {

    public static void main(String[] args) {
        int[][] matrix =  {
        {1,   3,  5,  7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(searchMatrix(matrix, 16));
    }

    // binary search
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0)
            return false;

        int m = matrix.length; // row length
        int n = matrix[0].length; // column length

        int start=0,end=m*n-1;
        while(start<=end) {
            int mid = (start+end)/2;
            int midX = mid/n;
            int midY = mid%n;

            if(matrix[midX][midY] == target)
                return true;

            if(matrix[midX][midY] <target)
                start = mid+1;
            else
                end = mid-1;
        }
        return false;
    }

}
