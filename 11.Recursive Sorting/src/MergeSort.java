import java.util.Arrays;
public class MergeSort {
    public static void main(String[] args) {
        // Merge sort
        int[] arr = {2, 3, 8,6, 5,9, 5, -8, 0, 1};
        System.out.println(Arrays.toString(mergeSort(arr)));
        System.out.println(Arrays.toString(arr));  // ***original array is not changed***

        // Inplace merge sort
        mergeSortInPlace(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));  // ***original array is changed***
    }

    static void mergeSortInPlace(int[] arr, int s, int e){
        if (e - s == 1) return;
        int mid = s + (e - s)/2;
        mergeSortInPlace(arr, s, mid);
        mergeSortInPlace(arr, mid, e);

        merge2(arr, s, mid, e);
    }

    static void merge2(int[] arr, int s, int mid, int e){
        int[] temp = new int[e - s];
        int i = s;
        int j = mid;
        int k = 0;

        while (i < mid && j < e){
            if (arr[i] < arr[j]){  // for descending order reverse sign here
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i < mid){
            temp[k] = arr[i];
            i++;
            k++;
        }

        while (j < e){
            temp[k] = arr[j];
            j++;
            k++;
        }

        // Copying values from temp to arr
        for (int l = 0; l < temp.length; l++) {
            arr[s+l] = temp[l];
        }
    }



    static int[] mergeSort(int[] arr){
        if (arr.length == 1) return arr;
        int mid = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));  // creating copy and mid is exclusive
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length)); // creating copy and arr.length is exclusive

        return merge(left, right);
    }

    static int[] merge(int[] first, int[] second){
        int[] result = new int[first.length+second.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < first.length && j < second.length){
            if (first[i] < second[j]){  // for descending order reverse sign here
                result[k] = first[i];
                i++;
            }else{
                result[k] = second[j];
                j++;
            }
            k++;
        }

        //copy remaining elements
        while (i < first.length){
            result[k] = first[i];
            i++;
            k++;
        }

        while (j < second.length){
            result[k] = second[j];
            j++;
            k++;
        }
        return result;
    }
}