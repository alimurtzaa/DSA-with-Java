public class bitManipulation {
    public static void main(String[] args) {

        //1. Even or Odd
        System.out.println(isOdd(53));

        //2. Find Unique in duplicates arr
        int[] arr = {2, 3, 5, 3, 5, 6, 2, 7, 6};
        System.out.println(findUnique(arr));
    }
    static int findUnique(int[] arr){
        int ans = 0;
        for (int n: arr){
            ans ^= n;
        }
        return ans;
    }

    static boolean isOdd(int n){
        return (n & 1) == 1;
    }
}