public class Sudoku {
    public static void main(String[] args) {
        int[][] board = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        if(solveSudoku(board)){
            display(board);
        }
    }

    static boolean solveSudoku(int[][] board){
        int n = board.length;
        int row = -1;
        int col = -1;
        boolean foundEmpty = false;

        // this is how we are replacing thr row, col arguments
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0){
                    row = i;
                    col = j;
                    foundEmpty = true;
                    break;
                }
            }
            if (foundEmpty){
                break;
            }
        }

        if (!foundEmpty){
            return true; //sudoku solved
        }

        for (int number = 1; number <=9 ; number++) {
            if (isSafe(board, row, col, number)){
                board[row][col] = number;
                //*SEE*
                if (solveSudoku(board)){
                    //found answer
                    return true;
                }else{
                    //backtrack
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }
    static boolean isSafe(int[][] board, int row, int col, int num){
        //checking row
        for (int i = 0; i < board.length; i++){
            if (board[row][i] == num){
                return false;
            }
        }

        //checking col
        for (int i = 0; i < board.length; i++){
            if (board[i][col] == num){
                return false;
            }
        }

        int sqrt = (int)(Math.sqrt(board.length));
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;
        for (int i = rowStart; i < rowStart + sqrt; i++) {
            for (int j = colStart; j < colStart + sqrt; j++) {
                if (board[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }
    static void display(int[][] board){
        for (int[] row: board){
            for(int num: row){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
