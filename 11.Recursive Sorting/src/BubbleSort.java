import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {

        //1. Bubble sort using recursion
        int[] arr = {2, 3, 14, 0, 0, 8, -5};
        System.out.println(Arrays.toString(bubbleSort(arr, 0, 1)));
    }

    static int[] bubbleSort(int[] arr, int i, int j){
        if (i == arr.length-1) return arr;
        if (j <= arr.length-i-1){
            if (arr[j] < arr[j-1]){
                //swap
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
            }
            return bubbleSort(arr, i, ++j);
        }
        return bubbleSort(arr, ++i, 1);
    }

}
