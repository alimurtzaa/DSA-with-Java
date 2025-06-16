import java.util.Arrays;

public class SelectionS {
    public static void main(String[] args) {
        int[] arr = {1, -3, 0, 4, 7, 6, 5, 4};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length-i-1;
            int maxIndex = getMaxIndex(arr, 0, last);
            //swaping max element with last index
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[last];
            arr[last] = temp;
        }
    }
    static int getMaxIndex(int[] arr, int start, int end){
        int maxIndex = start;
        for (int i = start; i <= end; i++) {
            if (arr[i] > maxIndex){
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
