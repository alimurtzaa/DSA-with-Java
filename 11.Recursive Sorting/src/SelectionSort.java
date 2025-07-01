import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {

        //1. Selection sort using recursion
        int[] arr = {2, 3, 14, 0, 0, 8, -5};
        System.out.println(Arrays.toString(selectionSort(arr, 0, 1, 0)));
    }

    static int[] selectionSort(int[] arr, int i, int j, int maxIndex){
        if (i == arr.length-1) return arr;
        if (j <= arr.length-i-1){
            if (arr[maxIndex] < arr[j]){
                maxIndex = j;
            }
            return selectionSort(arr, i, ++j, maxIndex);
        }
        //swap max and last
        int temp = arr[maxIndex];
        arr[maxIndex] = arr[arr.length-i-1];
        arr[arr.length-i-1] = temp;

        return selectionSort(arr, ++i, 1, 0);
    }
}
