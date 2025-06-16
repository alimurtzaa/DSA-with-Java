public class basicRecursion {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 78, 32, 98};
        System.out.println(binarySearch(arr, 32, 0, arr.length-1));
    }

    static int binarySearch(int[] arr, int target, int s, int e){
        if (s > e){
            return -1;
        }
        int mid = s + (e-s)/2;

        if (arr[mid] == target){
            return mid;
        } else if (arr[mid] > target) {
            return binarySearch(arr, target, s, mid-1);
        } else{
            return binarySearch(arr, target, mid+1, e);
        }
    }
}