public class EasyRecursionQues {
    public static void main(String[] args) {

        //1. Print numbers from n to 1
        ntoOne(5);

        //2. Print numbers from 1 to n
        oneToN(5);

        //3. Factorial of a number
        System.out.println(factorial(5));

        //4. Sum of digits
        System.out.println(sumDigits(1342));

        //5.Product of Digits
        System.out.println(productDigits(505));

        //6. Reverse a number
        System.out.println(reverse(12345));

        //7. Palindrome
        System.out.println(palindrome(12321));

        //8. Counting zeros in a number
        System.out.println(countZeros(3203));

        //9. Calculate steps (https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/description/)
        System.out.println(numberOfSteps(8));

        //10. Reverse a number *not recursion (https://leetcode.com/problems/reverse-integer/)
        System.out.println(reverse2(-0));

    }

    static int reverse2(int n) {
        int rev = 0;
        while(n != 0){
            int ld = n % 10;
            n /= 10;

            if (rev > Integer.MAX_VALUE / 10 || rev == Integer.MAX_VALUE / 10 && ld > 7) return 0;
            if (rev < Integer.MIN_VALUE / 10 || rev == Integer.MIN_VALUE / 10 && ld < 8) return 0;

            rev = rev*10 +ld;
        }
        return rev;
    }

    static int numberOfSteps(int num){
        return helper3(num, 0);
    }
    static int helper3(int num, int steps) {
        if (num == 0) return steps;

        if((num & 1) == 0){
            return helper3(num/2, ++steps);
        }
        return helper3(num-1, ++steps);
    }

    static int countZeros(int n){
        return helper2(n, 0);
    }
    static int helper2(int n, int count) {
        if (n == 0){
            return count;
        }
        if (n%10 == 0){
            return helper2(n/10, ++count);
        }
        return helper2(n/10, count);
    }

    static boolean palindrome(int n){
        return n == reverse(n);
    }

    static int reverse(int n){
        int digits = (int)Math.log10(n) + 1;
        return helper(n, digits);
    }
    static int helper(int n, int digits){
        if (n%10 == n) return n; // return when only single digit left
        return (n%10)*(int)Math.pow(10, digits-1) + helper(n/10, digits-1);
    }

    static int productDigits(int n){
        if (n == 0) return 1;
        return (n % 10) * productDigits(n / 10);
    }

    static int sumDigits(int n){
        if (n == 0) return 0;
        return (n % 10) + sumDigits(n / 10);
    }

    static int factorial(int n){
        if (n == 1) return 1;
        return n * factorial(n-1);
    }

    static void oneToN(int n){
        if (n == 0){
            return;
        }
        oneToN(n-1);
        System.out.println(n);
    }

    static void ntoOne(int n){
        if (n == 0){
            return;
        }
        System.out.println(n);
        ntoOne(n-1);
    }
}
