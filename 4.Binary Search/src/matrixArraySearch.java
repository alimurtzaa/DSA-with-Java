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
        System.out.println(Arrays.toString(searchInRowSortColSort2DArr(matrix, 15)));

        //2. search when Matrix is sorted
        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6},
                {8, 9, 10}
        };
        System.out.println(Arrays.toString(sortedMatrix(matrix2, 8)));
    }

    static int[] sortedMatrix(int[][] matrix,  int target){
        int rows = matrix.length;
        int cols = matrix[0].length; // change it for not square matrix (take length of row which has largest elements.)

        //if 1D array
        if(rows == 1){
            return binarySearch(matrix, 0, 0, cols-1, target);
        }

        int rStart = 0;
        int rEnd = rows-1;
        int cMid = cols/2;

        //run loop till 2 rows are remaining
        while(rStart < (rEnd-1)){
            int rMid = rStart + (rEnd - rStart)/2;
            if (matrix[rMid][cMid] == target){
                return new int[]{rMid, cMid};
            }if (matrix[rMid][cMid] > target){
                rEnd = rMid;
            }else{
                rStart = rMid;
            }
        }

        //now we have two rows
        // check whether the target is in the mid col
        if (target == matrix[rStart][cMid]){
            return new int[]{rStart, cMid};
        }if (target == matrix[rStart+1][cMid]){
            return new int[]{rStart+1, cMid};
        }

        //check in 1st half
        if(target <= matrix[rStart][cMid-1]){
            return binarySearch(matrix, rStart, 0, cMid-1, target);
        }
        //check in 2nd half
        if(target >= matrix[rStart][cMid+1] && target <= matrix[rStart][cols-1]){
            return binarySearch(matrix, rStart, cMid+1, cols-1, target);
        }
        //check in 3rd half
        if(target <= matrix[rStart+1][cMid-1]){
            return binarySearch(matrix, rStart+1, 0, cMid-1, target);
        }
        //check in 4th half
        else {
            return binarySearch(matrix, rStart+1, cMid+1, cols-1, target);
        }

    }
    static int[] binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target){
        while (cStart<=cEnd){
            int mid = cStart + (cEnd-cStart)/2;
            if (matrix[row][mid] == target){
                return new int[]{row, mid};
            }
            if (matrix[row][mid] > target){
                cEnd = mid-1;
            }else{
                cStart= mid+1;
            }
        }
        return new int[]{-1, -1};
    }

    static int[] searchInRowSortColSort2DArr(int[][] matrix, int target){
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
