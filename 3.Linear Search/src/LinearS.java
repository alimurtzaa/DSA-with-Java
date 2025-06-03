import java.util.Arrays;

public class LinearS {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5};
//        System.out.println(linearSearch(arr, 5));

        //Questions
        //1. searching a char in string
        String name = "murtza";
        char target = 'u';
        System.out.println(searchChar(name, target));
        System.out.println(searchChar2(name, target));

        //2. Searching char in range
        System.out.println(searchInRange(name, target, 2, 4));

        //3. finding min in an array
        int[] arr2 = {2, 34, 32, 0, -4};
        System.out.println(findMin(arr2));

        int[][] arr3 = {
                {1, 2, 35},
                {44, 5, -16, 7},
                {28, 29}
        };
        //4. search in 2D array
        System.out.println(Arrays.toString(searchIn2DArray(arr3, 6)));  //{row, col}

        //5. find max in 2d array
        System.out.println(maxIn2DArray(arr3));

        //6. count elements with even no of digits(https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/)
        int[] nums = {-9,3047,2,6,786};
        System.out.println(findNumbers(nums));
        System.out.println(noOfDigits2(-2097));

        //7. find maximum wealth of account holder(https://leetcode.com/problems/richest-customer-wealth/)
        int[][] accounts = {{2,8,7},{7,1,3},{1,9,5}};
        System.out.println(maximumWealth(accounts));
    }

    static int maximumWealth(int[][] accounts) {
        int maxWealth = Integer.MIN_VALUE;
        for(int[] acc : accounts){
            int wealth = arraySum(acc);
            if (wealth>maxWealth){
                maxWealth=wealth;
            }
        }
        return maxWealth;
    }
    static int arraySum(int[] arr){
        int sum = 0;
        for (int num: arr){
            sum+=num;
        }
        return sum;
    }

    static int findNumbers(int[] nums){
        int ans = 0;
        if (nums.length == 0){
            return -1;
        }
        for (int n: nums){
            if (even(n)){
                ans++;
            }
        }
        return ans;
    }

    static boolean even(int n){
        int digits = noOfDigits(n);
        return digits%2==0;
    }

    static int noOfDigits2(int n){
        //makiing n positive
        if (n<0){
            n=n*-1;
        }
        return (int)(Math.log10(n))+1;
    }
    static int noOfDigits(int n){
        int digits = 0;
        //if number is negative
        if (n<0){
            n = n * -1;
        }

        //if number is 0
        if (n==0){
            digits++;
        }

        while(n>0){
            n=n/10;
            digits++;
        }
        return digits;
    }


    static int maxIn2DArray(int[][] arr3){

        int max = Integer.MIN_VALUE;
        for (int row=0; row<arr3.length;row++){
            for (int col=0; col<arr3[row].length; col++){
                if (arr3[row][col]>max){
                    max=arr3[row][col];
                }
            }
        }
        return max;

    }

    static int[] searchIn2DArray(int[][] arr3, int target){
        if (arr3.length == 0){
            return new int[]{-1, -1};
        }
        for (int row=0; row<arr3.length;row++){
            for (int col=0; col<arr3[row].length; col++){
                if (arr3[row][col]==target){
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{-1, -1};
    }

    static int findMin(int[] arr){
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    static int searchInRange(String str, char target, int start, int end){
        if (str.isEmpty()){
            return -1;
        }
        for (int i = start; i <= end; i++) {
            if (str.charAt(i)==target){
                return i;
            }
        }
        return -1;
    }

    static boolean searchChar2(String str, char target){
        if (str.isEmpty()){
            return false;
        }
        for(char ch: str.toCharArray()){
            if (ch==target)
                return true;
        }
        return false;
    }

    static int searchChar(String str, char target){
        if (str.length() == 0){
            return -1;
        }
        for (int i = 0; i < str.length(); i++) {
            if (target == str.charAt(i)){
                return i;
            }
        }
        return -1;
    }

    static int linearSearch(int[] arr, int item){
        if(arr.length == 0){
            return -1;
        }
        for(int i=0; i<arr.length; i++){
            if( arr[i]==item){
                return i;
            }
        }
        return -1;
    }
}