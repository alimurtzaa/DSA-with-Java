import java.util.ArrayList;
import java.util.List;

public class MazeProblems {
    public static void main(String[] args) {

        //1. Count possible ways to cross maze to end
        System.out.println(countWaysInMaze(3, 3));

        //2. Print possible paths to cross maze to end
        allPathsInMaze("", 3, 3);

        //3. Return possible paths to cross maze to end (can move diagonally also)
        System.out.println(allPathsInMazeDiagonal("", 3, 3));

        //4. Print paths with maze having obstacles
        boolean[][] maze = {{true , true, true},
                            {true , false, true},
                            {true , true, true}};
        allPathsMazeObstacles("", maze, 0, 0);
    }

    static void allPathsMazeObstacles(String p, boolean[][] maze, int r, int c){
        if (r == maze.length - 1 && c == maze[0].length - 1){
            System.out.println(p);
            return;
        }
        if (!maze[r][c]){
            return;
        }

        if (c < maze[0].length - 1) {
            allPathsMazeObstacles(p + 'R', maze, r, c + 1);
        }
        if (r < maze.length - 1) {
            allPathsMazeObstacles(p + 'D', maze,r + 1, c);
        }
    }

    static List<String> allPathsInMazeDiagonal(String p, int r, int c){
        List<String> list = new ArrayList<>();
        if (r == 1 && c == 1){
            list.add(p);
            return list;
        }

        if (c > 1) {
            list.addAll(allPathsInMazeDiagonal(p + 'R', r, c - 1));
        }
        if (r > 1) {
            list.addAll(allPathsInMazeDiagonal(p + 'D', r - 1, c));
        }
        if (r > 1 && c > 1){
            list.addAll(allPathsInMazeDiagonal(p + 'X', r - 1, c - 1)); // X = Diagonal move
        }
        return list;
    }

    static void allPathsInMaze(String p, int r, int c){
        if (r == 1 && c == 1){
            System.out.println(p);
            return;
        }

        if (c > 1) {
            allPathsInMaze(p + 'R', r, c - 1);
        }
        if (r > 1) {
            allPathsInMaze(p + 'D', r - 1, c);
        }
    }

    static int countWaysInMaze(int r, int c){
        if (r == 1 || c == 1) return 1;

        int ans1 = countWaysInMaze(r, c - 1);
        int ans2 = countWaysInMaze(r - 1, c);
        return ans1 + ans2;
    }
}