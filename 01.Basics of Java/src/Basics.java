import java.util.Arrays;
import java.util.Scanner;

public class Basics {
    public static void main(String[] args) {
//        System.out.println("Hello, World!");
//        Scanner input = new Scanner(System.in);
//        int roll_number = input.nextInt();
//        System.out.println("Your roll number is: "+ roll_number);

        //Questions
        //1. find largest
//        Scanner sc = new Scanner(System.in);
//
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int c = sc.nextInt();
//        int max = c;
//
//        if (a > max) {
//            max = a;
//        }
//        if (b > max) {
//            max = b;
//        }
//        System.out.println(max);

        //2. check uppercase
//        Scanner sc = new Scanner(System.in);
//        char ch = sc.next().trim().charAt(0);
//
//        if (ch >=65 && ch<=90){
//            System.out.println("Uppercase");
//        }else {
//            System.out.println("Lowercase");
//        }

        //3. Find nth fibonacci number
//        Scanner sc= new Scanner(System.in);
//        int n = sc.nextInt();
//        int a = 0;
//        int b = 1;
//
//        for(int i = 2; i<=n; i++){
//            int temp = b;
//            b = a+b;
//            a = temp;
//        }
//        if(n<0){
//            System.out.println("enter valid value of n");
//        }
//        else if(n==0 || n==1){
//            System.out.println(n);
//        }else {
//            System.out.println(b);
//        }

        //4. counting occurrence
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int count = 0;
//        while(n>0){
//            int lastDigit = n%10;
//            if(lastDigit==5)
//                count++;
//            n/=10;
//        }
//        System.out.println(count);

        //5. reverse a number
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int rev=0;
//        while(n>0){
//            int lastDigit = n%10;
//            rev = rev*10 + lastDigit;
//            n/=10;
//        }
//        System.out.println(rev);

        //switch case
//        Scanner sc = new Scanner(System.in);
//        String fruit = sc.next();

//        switch (fruit){
//            case "Mango":
//                System.out.println("Mango khalo");
//                break;
//            case "Apple":
//                System.out.println("apple khalo");
//                break;
//            default:
//                System.out.println("Other fruits not valid");
//
//        }

        //enhanced switch
//        switch (fruit) {
//            case "Mango" -> System.out.println("Mango khalo");
//            case "Apple" -> System.out.println("apple khalo");
//            default -> System.out.println("Other fruits not valid");
//        }

        // nested switch
//        Scanner sc = new Scanner(System.in);
//        int employId = sc.nextInt();
//        String department = sc.next();
//        switch(employId){
//            case 1:
//                System.out.println("Murtza Ali");
//                break;
//            case 2:
//                System.out.println("Amina");
//                break;
//            case 3:
//                System.out.println("Rahul");
//                switch(department){
//                    case "IT":
//                        System.out.println("IT D");
//                        break;
//                    case "Management":
//                        System.out.println("Management D");
//                        break;
//                    default:
//                        System.out.println("No department found");
//                }
//        }

        //enhanced switch
//        switch (employId) {
//            case 1 -> System.out.println("Murtza Ali");
//            case 2 -> System.out.println("Amina");
//            case 3 -> {
//                System.out.println("Rahul");
//                switch (department) {
//                    case "IT" -> System.out.println("IT D");
//                    case "Management" -> System.out.println("Management D");
//                    default -> System.out.println("No department found");
//                }
//            }
//        }

      //methods call
//        System.out.println(sum());

//        func(2, 3, "ali", "amina");

        //method overloading
//        same(1);
//        same(3, 2);
//        same("ali");


//      1. Question check prime
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number: ");
        int n1 = sc.nextInt();
        System.out.println(isPrime(n1));

//      2. Question check Armstrong
         System.out.println("Enter 3 digit Number: ");
         int n2 = sc.nextInt();
         System.out.println(isArmstrong(n2));

    }

    //methods
    static int sum(){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        return a+b;
    }

    static void func(int a, int b, String ...v){
        System.out.println(a);
        System.out.println(b);
        System.out.println(Arrays.toString(v));
    }


    //method overloading
    static void same(int a){
        System.out.println(a);
    }

    static void same(int a, int b){
        System.out.println(a+" "+b);
    }

    static void same(String name){
        System.out.println(name);
    }

    //Methods for Questions
    static boolean isPrime(int n1) {
        if (n1<=1){
            return false;
        }
        int c = 2;
        while (c * c <= n1) {
            if (n1 % c == 0) {
                return false;
            }
            c++;
        }
        return true;
    }

    static boolean isArmstrong(int n2) {
        int original = n2;
        int sum = 0;
        while (n2 > 0) {
            int lastDigit = n2 % 10;
            sum += (int) Math.pow(lastDigit, 3);
            n2 = n2 / 10;
        }
        return original == sum;
    }

}