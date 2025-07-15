import java.util.Arrays;

public class Backtracking {
    public static void main(String[] args) {

        //1. Print paths having obstacles in all directions (L, R, U, D) using backtracking
        boolean[][] maze = {{true , true, true},
                            {true , true, true},
                            {true , true, true}};
        allDirectionPathsObstacles("", maze, 0, 0);

        //2. Print matrix paths with maze having obstacles in all directions (L, R, U, D) using backtracking
        boolean[][] maze2 = {{true , true, true},
                            {true , true, true},
                            {true , true, true}};
        int[][] path = new int[maze2.length][maze2[0].length];
        printAllDirectionPaths("", maze2, 0, 0, path, 1);

        //3. N Queens
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(nQueens(board, 0));

        //4. N knights
        int n2 = 4;
        boolean[][] board2 = new boolean[n][n];
        nKnights(board2, 0, 0, n2);
    }

    static void nKnights(boolean[][] board, int row, int col, int knights){
        if (knights == 0){
            display2(board);
            System.out.println();
            return;
        }

        if (row == board.length-1 && col == board.length){
            return;
        }

        if (col == board.length){
            nKnights(board, row + 1, 0, knights);
            return;
        }

        if (isSafe2(board, row, col)){
            board[row][col] = true;
            nKnights(board, row, col + 1, knights - 1);
            board[row][col] = false;
        }
        nKnights(board, row, col + 1, knights);
    }
    static boolean isSafe2(boolean[][] board, int row, int col) {
        if(isValid(board, row-2, col+1)){
            if (board[row-2][col+1]){
                return false;
            }
        }
        if(isValid(board, row-2, col-1)){
            if (board[row-2][col-1]){
                return false;
            }
        }
        if(isValid(board, row-1, col+2)){
            if (board[row-1][col+2]){
                return false;
            }
        }
        if(isValid(board, row-1, col-2)){
            if (board[row-1][col-2]){
                return false;
            }
        }
        return true;
    }
    static boolean isValid(boolean[][] board, int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board.length){
            return true;
        }
        return false;
    }
    static void display2(boolean[][] board){
        for (boolean[] row: board){
            for(boolean elem: row){
                if(elem){
                    System.out.print("K ");
                }else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    static int nQueens(boolean[][] board, int row){
        if (row == board.length){
            display(board);
            System.out.println();
            return 1;
        }

        int count = 0;
        for (int col = 0; col < board[0].length; col++) {
            if(isSafe(board, row, col)){
                board[row][col] = true;
                count += nQueens(board, row+1);
                board[row][col] = false;
            }
        }
    return count;
    }
    static boolean isSafe(boolean[][] board, int row, int col){
        //check vertical row
        for (int i = 0; i < row; i++) {
            if (board[i][col]){
                return false;
            }
        }

        // diagonal left
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row-i][col-i]){
                return false;
            }
        }

        // diagonal right
        int maxRight = Math.min(row, board.length-col-1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row-i][col+i]){
                return false;
            }
        }
        return true;
    }
    static void display(boolean[][] board){
        for (boolean[] row: board){
            for(boolean elem: row){
                if(elem){
                    System.out.print("Q ");
                }else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    static void printAllDirectionPaths(String p, boolean[][] maze, int r, int c, int[][] path, int step){
        if (r == maze.length - 1 && c == maze[0].length - 1){
            path[r][c] = step;
            for(int[] arr: path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if (!maze[r][c]){
            return;
        }

        // Making the cell as marked visited
        maze[r][c] = false;
        path[r][c] = step;

        if (c < maze[0].length - 1) {
            printAllDirectionPaths(p + 'R', maze, r,c + 1, path, step + 1);
        }
        if (r < maze.length - 1) {
            printAllDirectionPaths(p + 'D', maze,r + 1, c, path, step + 1);
        }
        if (r > 0){
            printAllDirectionPaths(p + 'U', maze,r - 1, c, path, step + 1);
        }
        if (c > 0){
            printAllDirectionPaths(p + 'L', maze, r,c - 1, path, step + 1);
        }

        // Making the cell as marked not visited once function is returned
        maze[r][c] = true;
        path[r][c] = 0;
    }

    static void allDirectionPathsObstacles(String p, boolean[][] maze, int r, int c){
        if (r == maze.length - 1 && c == maze[0].length - 1){
            System.out.println(p);
            return;
        }
        if (!maze[r][c]){
            return;
        }

        // Making the cell as marked visited
        maze[r][c] = false;

        if (c < maze[0].length - 1) {
            allDirectionPathsObstacles(p + 'R', maze, r, c + 1);
        }
        if (r < maze.length - 1) {
            allDirectionPathsObstacles(p + 'D', maze,r + 1, c);
        }
        if (r > 0){
            allDirectionPathsObstacles(p + 'U', maze,r - 1, c);
        }
        if (c > 0){
            allDirectionPathsObstacles(p + 'L', maze, r,c - 1);
        }

        // Making the cell as marked not visited once function is returned
        maze[r][c] = true;
    }
}
