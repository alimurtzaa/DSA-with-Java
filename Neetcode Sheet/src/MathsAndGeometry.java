import java.util.Arrays;

public class MathsAndGeometry {
    public static void main(String[] args) {

        //1. Plus One (https://leetcode.com/problems/plus-one/description/)
        int[] digits = {4,3,2,9};
        System.out.println(Arrays.toString(plusOne(digits)));

        //2. pow(x, n) (https://leetcode.com/problems/powx-n/)
        double x = 2.00000;
        int n = -2;
        System.out.println(myPow(x, n));

        // Using Recursion
        System.out.println(myPowRecursion(x, n));

        //3. Transpose of Matrix (https://leetcode.com/problems/transpose-matrix/)
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] result = transpose(matrix);
        for (int[] arr: result){
            System.out.println(Arrays.toString(arr));
        }

        //4. Rotate Image (https://leetcode.com/problems/rotate-image/)
        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix2);
        for (int[] arr: matrix2){
            System.out.println(Arrays.toString(arr));
        }

    }

    static void rotate(int[][] matrix){
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }

    static int[][] transpose(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] ans = new int[c][r];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }

    static double myPowRecursion(double x, int n){
        long pow = n;
        double ans = 1;
        if (pow < 0){
            x = 1/x;
            pow = -pow;
        }
        return helperPow(x, pow);
    }
    static double helperPow(double x, long n){
        if (n == 0) return 1;
        double half = helperPow(x, n/2);

        if (n % 2 == 0){
            return half*half;
        }else{
            return half*half*x;
        }
    }

    static double myPow(double x, int n){
        long pow = n;
        double ans = 1;
        if (pow < 0){
            x = 1/x;
            pow = -pow;
        }
        while (pow > 0){
            if ((pow & 1) == 1){
                ans *= x;
            }
            x *= x;
            pow = pow >> 1;
        }
        return ans;
    }

    static int[] plusOne(int[] digits){
        for (int i = digits.length-1; i >= 0; i--) {
            if (digits[i]+1 != 10){
                digits[i] +=1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newDigits = new int[digits.length+1]; // new array created have all 0 filled in it
        newDigits[0] = 1;
        return newDigits;
    }
}