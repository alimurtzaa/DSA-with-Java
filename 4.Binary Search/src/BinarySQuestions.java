import java.util.Arrays;

public class BinarySQuestions {
    public static void main(String[] args) {

        int[] arr = {2, 3, 5, 9, 14, 16, 18};

        //1. Ceiling of a number => smallest number greater or equal to the target element
        System.out.println(ceilingOfNumber(arr, 10));

        //2. floor of a number => greatest number smallest or equal to the target
        System.out.println(floorOfNumber(arr, 10));
        System.out.println(floorOfNumber(arr, 1));

        //3. find smallest letter greater than target (https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/)
        char[] letters = {'c','f', 'j'};
        System.out.println(sLGT(letters, 'j'));

        //4.find first and last position of element in sorted array (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
        int[] nums = {2, 2};
        System.out.println(Arrays.toString(searchRange(nums, 7)));

        //5.find element in and infinite array (https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/)
        // Infinte array = mimic it by not using .length
        int[] arr2 = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        System.out.println(elementInInfiniteArr(arr2, 10));

        //6.Peak Index in a Mountain Array (https://leetcode.com/problems/peak-index-in-a-mountain-array/) &
        //7.Find Peak Element (strictly greater than its neighbors) (https://leetcode.com/problems/find-peak-element/description/)
        int[] arr3 = {1, 4, 7, 5, 3, 2, 0};
        System.out.println(mountainArrPeak(arr3));

        //8.Find in Mountain Array and return minimum index of target if target is present multiple times (https://leetcode.com/problems/find-in-mountain-array/) => first finding max, then order agonstic BS on ascending side if not found than on descending side
        int[] arr4 = {1, 2, 17, 15, 30, 2, 1, 0};
        System.out.println(findInMountainArr(arr4, 15));

        //9.Search in Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/description/)
        int [] arr5 = {6,7,1,2,3,4,5};
        System.out.println(searchInRSA(arr5, 6));


    }

    static int searchInRSA(int[] arr, int target){
        int pivot = findPivot(arr);
        if (pivot == -1){
            return binarySearch(arr, target, 0, arr.length-1);
        }
        if (target == arr[pivot]){
            return pivot;
        }
        if (target >= arr[0]) {
            return binarySearch(arr, target, 0, pivot);
        }
        return binarySearch(arr, target, pivot + 1, arr.length - 1);
    }
    static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length-1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases over here
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid-1;
            }
            if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    static int findInMountainArr(int[] arr, int target){
       int peak = mountainArrPeak(arr);
       int ans = orderAgnosticBS(arr, target, 0, peak);
       if (ans!=-1){
           return ans;
       }
       return orderAgnosticBS(arr, target, peak + 1, arr.length-1);
    }
    static int orderAgnosticBS(int[] arr, int target, int start, int end){

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

    static int mountainArrPeak(int[] arr){
        int start = 0;
        int end = arr.length-1;
         while(start<end){  //    here <= is not used as we are not returning anything from the loop as like in BS so it will infinite. when target is found start==end
             int mid = start + (end-start)/2;
              if(arr[mid] < arr[mid+1]){
                  start = mid+1;
              } else  {
                  end = mid;
              }
         }
         return start;
    }

    static int elementInInfiniteArr(int[] arr, int target){
        int start = 0;
        int end = 1;

        while(target > arr[end]){
            int newStart = end+1;
            // end = prev end + sizeofbox*2
            end = end + (end - start + 1)*2;
            start = newStart;
        }
        return binarySearch(arr, target, start, end);
    }
    static int binarySearch(int[] arr, int target, int start, int end){

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

    static int[] searchRange(int[] nums, int target){
        int[] ans = {-1, -1};
        ans[0] = search(nums, 2, true);
        if(ans[0]!=-1){
            ans[1] = search(nums, 2, false);
        }
        return ans;
    }
    static int search(int[] nums, int target, boolean findStartIndex) {
        int start = 0;
        int end = nums.length - 1;
        int ansIndex = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                // potential ans found
                ansIndex = mid;
                if (findStartIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
            return ansIndex;
    }

    static char sLGT(char[] letters, char target){
        int start = 0;
        int end = letters.length-1;

        while(start<=end){
            int mid = start + (end-start)/2;
            if (letters[mid] > target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        //either this or direct what is in return down
//        if (start == letters.length){
//            return letters[0];
//        }

        return letters[start % letters.length];
    }

    static int floorOfNumber(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;

        //If target is smaller than the first element in the array
        if (target < arr[0]){
            return Integer.MIN_VALUE;
        }

        while (start<=end){
            int mid = start+(end-start)/2;

            if (arr[mid] == target ){
                return arr[mid];
            } else if (arr[mid] > target) {
                end = mid-1;
            }else {
                start = mid + 1;
            }

        }
        return arr[end];
    }

    static int ceilingOfNumber(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;

        if (target > arr[arr.length-1]){
            return -1;
        }

        while (start<=end){
            int mid = start+(end-start)/2;

            if (arr[mid] == target ){
                return arr[mid];
            } else if (arr[mid] > target) {
                end = mid-1;
            }else {
                start = mid + 1;
            }

        }
        return arr[start];
    }
}
