import java.util.ArrayList;

public class MathsForDSA {
    public static void main(String[] args) {

        //1. Find All Primes Upto N
        int n = 40;
        boolean[] primes = new boolean[n+1];
        sieve(n, primes);

        //2. Square root using BS upto p decimal places
        int n2 = 40;
        int p = 3;
        System.out.println(sqrt(n2, p));

        //3. Square root using Newton Raphson Method
        int n3 = 40;
        System.out.println(newtonSQRT(n3));

        //4. Factors of a number
        int n4 = 20;
        factors1(n4);
        factors2(n4);
        factors3(n4);

        //5. HCF/GCD
        int a = 20;
        int b = 2;
        System.out.println(gcd(a, b));

        //6. LCM
        int a2 = 20;
        int b2 = 2;
        System.out.println(lcm(a2, b2));

    }

    static int lcm(int a, int b){
        return a * b / gcd(a, b);
    }

    static int gcd(int a, int b){
        if (a == 0){
            return b;
        }
        return gcd(b%a, a);
    }

    // Neatly printing in sorted order
    static void factors3(int n){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++){
            if (n % i == 0){
                if (i == n/i) {
                    System.out.print(i + " ");
                }else {
                    System.out.print(i + " ");
                    list.add(n/i);
                }
            }
        }
        for (int i = list.size()-1; i >=0 ; i--) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
    // O(sqrt(n))
    static void factors2(int n) {
        for (int i = 1; i <= Math.sqrt(n); i++){
            if (n % i == 0){
                if (i == n/i) {  // if equal factors like 6*6 = 36
                    System.out.print(i + " ");
                }else {
                    System.out.print(i + " " + n/i + " ");
                }
            }
        }
        System.out.println();
    }
    // O(n)
    static void factors1(int n){
        for (int i = 1; i <= n; i++){
            if (n % i == 0){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    static double newtonSQRT(double n){
        double x = n;
        double root;

        while (true){
            root = 0.5 * (x + (n/x));

            if (Math.abs(root - x) < 1){
                break;
            }
            x = root;
        }
        return root;
    }

    static double sqrt(int n, int p){
        int start = 0;
        int end = n;
        double root = 0.0;
        while(start <= end){
            int mid = start + (end-start)/2;

            if(mid*mid == n){
                return mid;
            }
            if(mid*mid > n){
                end = mid - 1;
            }else{
                root = mid;
                start = mid + 1;
            }
        }
        double incr = 0.1;
        for (int i = 0; i < p; i++) {
            while (root*root <= n){
                root+=incr;
            }
            root-=incr;
            incr/=10;
        }

        return root;
    }

    //false in array means number is prime
    static void sieve(int n, boolean[] primes){
        for (int i = 2; i*i <= n; i++) {
            if (!primes[i]){
                for (int j = i*2; j <= n; j+=i) {
                    primes[j] = true;
                }
            }
        }

        for (int i = 2; i <=n ; i++) {
            if (!primes[i]){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}