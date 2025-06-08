import java.util.Arrays;

public class matrixArraySearch {
    public static void main(String[] args) {
        //2D arrays
        //1. search when Matrix is sorted in row wise and column wise
        int[][] matrix = {
                {10, 20 , 30},
                {12, 21, 32},
                {15, 25, 39}
        };
        System.out.println(Arrays.toString(search(matrix, 15)));

    }
    static int[] search(int[][] matrix, int target){
        int row = 0;
        int col = matrix.length-1;

        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target){
                return new int[]{row, col};
            } else if (matrix[row][col] > target) {
                col--;
            }else{
                row++;
            }
        }
        return new int[]{-1, -1};

    }
}
