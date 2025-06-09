import java.sql.Array;
import java.util.Arrays;

public class BubbleS {
    public static void main(String[] args) {
        int[] arr2 = {1, -3, 0, 4, 7, 6, 5, 4};
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            boolean isSwap = false;
            // each pass will sort largest element to its position
            for (int j = 1; j < arr.length-i; j++) {
                if (arr[j] < arr[j-1]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    isSwap = true;
                }
            }
            if (!isSwap){
                break;
            }
        }
    }
}