import java.util.Arrays;

public class CyclicS {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 6, 2};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }




    static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;

            if (arr[i] >= 1 && arr[i] <= arr.length && arr[i] != arr[correctIndex]) {
                // Swap
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            } else {
                i++;
            }
        }
    }
}
