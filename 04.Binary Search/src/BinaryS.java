import java.util.Arrays;

public class BinaryS {
    public static void main(String[] args) {
        //Binary search
        int[] arr = {-9, -1, 23, 34, 45, 56, 67, 78, 89};
        System.out.println(binarySearch(arr, 78));

        //Order agnostic binary search
        int[] arr2 = {99, 89, 34, 30, 29, 10, -67, -78, -89};
        System.out.println(orderAgnosticBS(arr2, 34));


    }


    static int orderAgnosticBS(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        boolean isAscending = arr[start] < arr[end];

        while(start<=end) {
            int mid = start + (end-start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (isAscending) {
                if (arr[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }else {
                if (arr[mid] < target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    static int binarySearch(int[] arr, int target){
        if (arr.length==0){
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;

        while(start<=end) {
            int mid = start + (end-start) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
    return -1;
    }


}