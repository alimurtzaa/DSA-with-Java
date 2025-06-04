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
