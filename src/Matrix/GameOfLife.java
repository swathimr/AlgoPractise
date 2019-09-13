package Matrix;

public class GameOfLife {

    // time and space O(m*n)
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        int[][] copyBoard = new int[rows][cols];
        int[] neighbors={0,1,-1};

        //copy board
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                copyBoard[i][j] = board[i][j];
            }
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                int liveNeighbors = 0;

                // Rule 2
                for(int l =0;l<3;l++) {
                    for(int m=0;m<3;m++) {

                        if(!(neighbors[l] == 0 && neighbors[m]==0))
                        {
                            int r = i+neighbors[l];
                            int c = j+neighbors[m];

                            if((r>=0 && r<rows) && (c>=0 && c<cols) && copyBoard[r][c]==1){
                                liveNeighbors+=1;
                            }
                        }
                    }
                }

                // Rule 1 or Rule 3
                if(copyBoard[i][j] == 1 && (liveNeighbors<2 || liveNeighbors>3))
                    board[i][j] = 0;

                // Rule 4
                if(copyBoard[i][j] == 0 && liveNeighbors == 3)
                    board[i][j] = 1;

            }
        }
    }

}
