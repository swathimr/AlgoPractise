package Matrix;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        for(int i = 0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(ifExist(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean ifExist(char[][] board, int i, int j, int start, String word) {
        if(start >= word.length()) {
            return true;
        }
        if(i < 0 || i >= board.length || j<0 || j >= board[0].length) {
            return false;
        }

        boolean res = false;
        if(board[i][j] == word.charAt(start++)) {
            char c = board[i][j];
            board[i][j] = '#';
            if(ifExist(board, i+1, j, start, word) ||
                    ifExist(board, i-1, j, start, word) ||
                    ifExist(board, i, j+1, start,word) ||
                    ifExist(board, i, j-1, start, word)) {
                res = true;
            }
            board[i][j] = c;
            return res;
        }
        return false;
    }
}
