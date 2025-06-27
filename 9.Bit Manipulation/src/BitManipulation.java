import java.util.Arrays;

public class BitManipulation {
    public static void main(String[] args) {

        //1. Even or Odd
        System.out.println(isOdd(53));

        //2. Find Unique in duplicate arr
        int[] arr = {2, 3, 5, 3, 5, 6, 2, 7, 6};
        System.out.println(findUnique(arr));

        //3. Find Nth magic number
        System.out.println(magicNumber(4));

        //4. Reverse Bits (https://leetcode.com/problems/reverse-bits/)
        int n = 43261596;
        System.out.println(reverseBits(n));

        //5. No of digits
        int n2 = 34567;
        int base = 10;
        System.out.println(totalDigits(n2, base));

        //6. Check if number is power of 2
        int n3 = 256;
        System.out.println(isPowerofTwo(n3));

        //7. find a power b
        int power = 6;
        int base2 = 3;
        System.out.println(calculatePower(power, base2));

        //8. XOR from 0 to a
        int a = 0;
        System.out.println(xorAll(a));

        //9. XOR from range a to b
        int a2 = 3;
        int b = 9;
        System.out.println(xorInRange(a2, b));

        //10. flip and invert array ()
        int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
        System.out.println(Arrays.deepToString(flipAndInvertImage(image)));
    }

    static int[][] flipAndInvertImage(int[][] image){
        for (int[] row: image){
            for (int i = 0; i < (row.length+1)/2; i++) {
                int temp = row[i]^1;
                row[i] = row[row.length-i-1]^1;
                row[row.length-i-1] = temp;
            }
        }
        return image;
    }

    static int xorInRange(int a, int b){
        return xorAll(b)^xorAll(a-1);
    }

    static int xorAll(int a){
        if (a%4 == 0) return a;
        if (a%4 == 1) return 1;
        if (a%4 == 2) return a+1;
        return 0;
    }

    static int calculatePower(int power, int base){
        int ans = 1;

        while(power > 0){
            if ((power & 1) == 1){
                ans *= base;
            }
            base *= base;
            power = power >> 1;
        }
        return ans;
    }

    static boolean isPowerofTwo(int n){
        if (n == 0) return false;
        return (n & (n-1)) == 0;
    }

    static int totalDigits(int n, int base){
        return (int)(Math.log(n)/Math.log(base)) + 1;
    }

    static int reverseBits(int n){
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int last = n & 1;
            ans = (ans << 1) | last;
            n = n >>> 1;
        }
        return ans;
    }

    static int magicNumber(int n){
        int result  = 0;
        int base = 5;
        while(n>0){
            int last = n & 1;
            n = n >> 1;
            result = base*last;
            base = base*5;
        }
        return result;
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