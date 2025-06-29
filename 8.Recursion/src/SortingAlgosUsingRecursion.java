import java.util.Arrays;

public class SortingAlgosUsingRecursion {
    public static void main(String[] args) {

        //1. Bubble sort using recursion
        int[] arr = {2, 3, 14, 0, 0, 8, -5};
        System.out.println(Arrays.toString(bubbleSort(arr, 0, 1)));

        //2. Selection sort using recursion
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
