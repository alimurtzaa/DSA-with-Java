import java.util.Arrays;

public class InsertionS {
    public static void main(String[] args) {
        int[] arr = {1, -3, 0, 4, 7, 6, 5, 4};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void insertionSort(int[] arr){
        for (int i = 0; i <= arr.length-2; i++) {
            for (int j = i+1; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }else{
                    break;
                }
            }
        }
    }
}
