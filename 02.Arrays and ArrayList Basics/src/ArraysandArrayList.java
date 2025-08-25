import java.util.Arrays;
import java.util.Scanner;

public class ArraysandArrayList {
    public static void main(String[] args) {

        //Basics of Arrays
//        int[] arr = new int[5]; // [0, 0, 0, 0, 0]   initialized like this
//        arr[0] = 30;
//        System.out.println(Arrays.toString(arr));
//
//        String[] arr2 = new String[2]; //[null, null]    initialized like this
//        arr2[0] = "ali";
//        System.out.println(Arrays.toString(arr2));


        Scanner sc = new Scanner(System.in);

//        int[] arr = new int[5];

//        for (int i=0; i< arr.length; i++ ){
//            arr[i] = sc.nextInt();
//            System.out.print(arr[i]+ " ");
//        }

        //for each
//        for (int num: arr){
//            num = sc.nextInt();
//            System.out.print(num+ " ");
//        }


        // multidimensional array
        // 2-D Array

//        int[][] arr = new int[3][]; // defining rows is mandatory but defining column is optional
//
//        int[][] arr2 = {
//                {1, 2, 3},
//                {4, 5},
//                {6, 7, 8, 9}
//                };
        //2D using for each
//        for(int[] num1: arr2){
//            for(int num2: num1){
//                System.out.print(num2);
//            }
//            System.out.println();
//        }
        //2D using .toString
//        for(int i=0; i<arr2.length; i++){
//            System.out.println(Arrays.toString(arr2[i]));
//        }


        //ArrayList

//        ArrayList<Integer> list = new ArrayList<>(10);
//
//        list.add(23);
//        list.add(33);
//        list.add(43);
//        list.add(53);
//        list.add(63);
//
//        list.set(0, 100);
//        System.out.println(list);
//
//        for(int i =0; i<5; i++){
//            System.out.println(list.get(i));
//        }


        //2D ArrayList
//        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//
//        for (int i=0; i<3; i++){
//            list.add(new ArrayList<>());
//        }
//
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                list.get(i).add(sc.nextInt());
//            }
//        }
//
//        System.out.println(list);




        //Questions
        //1.swap
        int[] arr = {11, 32, 53, 324, 85};
        swap(arr, 1, 3);

        //2.max item
        int[] arr2 = {-11, -32, -53, -324, -85};
        System.out.println(findMax(arr));

        //3.reverse array
        int[] arr3 = {11, 32, 53, 324, 85};
        reverse(arr);

    }

    static void reverse(int[] arr3){
        for (int i = 0; i < arr3.length/2; i++) {
            swap(arr3, i, arr3.length-i-1);
        }
        System.out.println(Arrays.toString(arr3));
    }

    static int findMax(int[] arr2){
        int max=Integer.MIN_VALUE; //or max=arr[0]
        for (int n:arr2){
            if (n > max) {
                max=n;
            }
        }
        return max;
    }

    static void swap(int[] arr, int i1, int i2){
        int temp=arr[i1];
        arr[i1]=arr[i2];
        arr[i2]=temp;
        System.out.println(Arrays.toString(arr));
    }

}