public class Patterns {
    public static void main(String[] args) {

        //1.
//        pattern1(5);

        //2.
//        pattern2(5);

        //3.
//        pattern3(5);

        //4.
//        pattern4(8);

        //5.
//        pattern5(8);

        //6.
//        pattern6(5);

        //7.
        pattern7(4);
    }
    static void pattern7(int n){
        int originalN = n;
        n = 2*n;
        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= n; col++) {
                int atEveryIndex = originalN - Math.min(Math.min(row, col), Math.min(n-row, n-col));
                System.out.print(atEveryIndex+" ");
            }
            System.out.println();
        }
    }

    static void pattern6(int n){
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }

            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            for (int j = 2; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static void pattern5(int n){
        for (int i = 1; i <=(2*n-1); i++) {
            int col = i <= n ? i : 2*n-i;
//            int spaces = i <= n ? n-i : i-n;  //or below
            int spaces = n-col;
            //spaces
            for (int j = 1; j <=spaces; j++) {
                System.out.print(" ");
            }
            //star
            for (int j = 1; j <=col; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern4(int n){
        for (int i = 1; i <=(2*n-1); i++) {
            int col = i <= n ? i : 2*n-i;
                for (int j = 1; j <=col; j++) {
                    System.out.print("* ");
                }
                System.out.println();
        }
    }

    static void pattern3(int n){
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static void pattern2(int n){
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=(n-i+1) ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern1(int n){
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}