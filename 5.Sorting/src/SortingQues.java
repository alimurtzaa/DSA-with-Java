import java.util.*;


public class SortingQues {
    public static void main(String[] args) {
        //1. Missing Number (https://leetcode.com/problems/missing-number/description/)
        int[] nums = {3, 0, 1};
        int[] nums2 = {0, 1, 2};
        System.out.println(missingNumber(nums2));

        //2. Find All Numbers Disappeared in an Array (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/)
        int[] nums3 = {4,3,2,7,8,2,3,1};
        System.out.println((findDisappearedNumbers(nums3)));

        //3. Find the Duplicate Number (https://leetcode.com/problems/find-the-duplicate-number/description/)
        int[] nums4 = {1,3,3,4,2};
        System.out.println(findDuplicate(nums4));

        //4. Find All Duplicates in an Array (https://leetcode.com/problems/find-all-duplicates-in-an-array/description/)
        int[] nums5 = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums5));

        //5. Set Mismatch (https://leetcode.com/problems/set-mismatch/description/)
        int[] nums6 = {1,2,2,4};
        System.out.println(Arrays.toString(findErrorNums(nums6)));

        //6. First Missing Positive (https://leetcode.com/problems/first-missing-positive/description/)
        int[] nums7 = {-1, 0, 1, 2};
        System.out.println(firstMissingPositive(nums7));

        //7. Merge Sorted Array (https://leetcode.com/problems/merge-sorted-array/description/)
        int[] nums8 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums9 = {2,5,6};
        int n = 3;
        merge(nums8, m, nums9, n);
        System.out.println(Arrays.toString(nums8));

        //8. Majority Element (https://leetcode.com/problems/majority-element/description/)
        int[] nums10 = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums10));

        //9. Assign Cookies (https://leetcode.com/problems/assign-cookies/description/)
        int[] g = {1,2,3};
        int[] s = {1,1};
        System.out.println(findContentChildren(g, s));

        //10. Intersection of Two Arrays (https://leetcode.com/problems/intersection-of-two-arrays/description/)
        int[] nums11 = {4,9,5};
        int[] nums12 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(nums11, nums12)));

        //11. Third Maximum Number (https://leetcode.com/problems/third-maximum-number/description/)
        int[] nums13 = {3, 2, 1};
        System.out.println(thirdMax(nums13));

        //12. Largest Perimeter Triangle (https://leetcode.com/problems/largest-perimeter-triangle/description/)
        int[] nums14 = {1,2,1,10};
        System.out.println(largestPerimeter(nums14));

        //13. Sort Array By Parity (https://leetcode.com/problems/sort-array-by-parity/description/)
        int[] nums15 = {3,1,2,4};
        System.out.println(Arrays.toString(sortArrayByParity(nums15)));

        //14. Height Checker (https://leetcode.com/problems/height-checker/description/)
        int[] heights = {1,1,4,2,1,3};
        System.out.println(heightChecker(heights));

        //15. Squares of a Sorted Array (https://leetcode.com/problems/squares-of-a-sorted-array/description/)
        int[] nums16 = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(nums16)));

        //16. Sort colors (https://leetcode.com/problems/sort-colors/description/)
        int[] nums17 = {2,0,2,1,1,0};
        sortColors(nums17);
        System.out.println(Arrays.toString(nums17));
    }

    // *Dutch National Flag Algorithm*
    static void sortColors(int[] nums){
        int low = 0, mid = 0, high = nums.length-1;

        while (mid <= high){
            if (nums[mid] == 0){
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else{
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }

    static int[] sortedSquares(int[] nums){
        int i = 0;
        int j = nums.length-1;
        int k = nums.length-1;
        int[] result = new int[nums.length];
        while (i<=j){
            if (nums[i]*nums[i] > nums[j]*nums[j]){
                result[k--] = nums[i]*nums[i];
                i++;
            }else{
                result[k--] = nums[j]*nums[j];
                j--;
            }
        }
        return result;
    }

    static int heightChecker(int[] heights){
        int[] expected = Arrays.copyOf(heights, heights.length);
        int count = 0;
        Arrays.sort(expected);
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]){
                count++;
            }
        }
        return count;
    }

    static int[] sortArrayByParity(int[] nums){
        int i = 0;
        int j = nums.length-1;

        while(i < j){
            if ((nums[i] & 1) == 1 && (nums[j] & 1) == 0){
                //swap
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
            if ((nums[i] & 1) == 0) i++;
            if ((nums[j] & 1) == 1) j--;
        }
        return nums;
    }

    static int largestPerimeter(int[] nums){
        Arrays.sort(nums);

        for (int i = nums.length-1; i >= 2; i--) {
            if (nums[i] < nums[i-1] + nums[i-2]){
                return nums[i] + nums[i-1] + nums[i-2];
            }
        }
        return 0;
    }

    static int thirdMax(int[] nums){
        Integer first = null, second = null, third = null;
        
        for(Integer num: nums){
            if (num.equals(first) || num.equals(second) || num.equals(third)) continue; //case for duplicates
            
            if (first == null || num > first){
                third = second;
                second = first;
                first = num;
            } else if (second == null || num > second) {
                third = second;
                second = num;
            } else if (third == null || num > third) {
                third = num;
            }
        }
        return third == null ? first : third;
    }

    static int[] intersection(int[] nums1, int[] nums2){
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        for(Integer num: nums2){
            if(binarySearch(nums1, num)){
                set.add(num);
            }
        }
        int[] result = new int[set.size()];
        int i = 0;
        for(Integer num: set){
            result[i++] = num;
        }
    return result;
    }
    static boolean binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if (arr[mid] ==  target){
                return true;
            }
            if(arr[mid] > target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return false;
    }

    static int findContentChildren(int[] g, int[] s){
        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0;
        int cookie = 0;

        while(child < g.length && cookie < s.length){
            if (s[cookie] >= g[child]){
                child++;
            }
            cookie++;
        }
        return child;
    }

    static int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        return nums[nums.length / 2];

        //OR
        //Using Boyer-Moore Voting Algo.
        int candidate = 0;
        int count = 0;

        for(int num: nums){
            if (count == 0){
                candidate = num;
            }
            count+=(candidate == num) ? 1 : -1;
        }
        return candidate;
    }

    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        while(j>=0){
            if(i>=0 && nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }else{
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }

    static int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int correctIndex = nums[i]-1;
            if (nums[i] >= 1 && nums[i] <= nums.length && nums[i] != nums[correctIndex]){
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }else{
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j+1){
                return j+1;
            }
        }
        return nums.length + 1;
    }

    static int[] findErrorNums(int[] nums) {
        int i = 0;
        while (i < nums.length){
            int correctIndex = nums[i] - 1;
            if(nums[i]>=1 && nums[i]<=nums.length && nums[i] != nums[correctIndex]){
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }else{
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j+1){
                return new int[]{nums[j], j+1};
            }
        }
        return new int[] {-1, -1};
    }

    static List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        while (i < nums.length){
            int correctIndex = nums[i] - 1;
            if(nums[i]>=1 && nums[i]<=nums.length && nums[i] != nums[correctIndex]){
                //swap
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }else{
                i++;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j+1){
                list.add(nums[j]);
            }
        }
        return list;
    }

    static int findDuplicate(int[] nums) {
//        int i = 0;
//        while (i < nums.length){
//            int correctIndex = nums[i] - 1;
//            if(nums[i]>=1 && nums[i]<=nums.length && nums[i] != nums[correctIndex]){
//                //swap
//                int temp = nums[i];
//                nums[i] = nums[correctIndex];
//                nums[correctIndex] = temp;
//            }else{
//                i++;
//            }
//        }
//        for (int j = 0; j < nums.length; j++) {
//            if (nums[j] != j+1){
//                return nums[j];
//            }
//        }
//        return -1;

        // better code
        int i = 0;
        while (i < nums.length){
            if(nums[i] != i+1){  //nums[i] correct position pe nhi hai
                int correctIndex = nums[i] - 1;
                if(nums[i]>=1 && nums[i]<=nums.length && nums[i] != nums[correctIndex]){  //nums[correctIndex] pe bhi nhi hai pehle se nums[i] similar, toh swap
                    int temp = nums[i];
                    nums[i] = nums[correctIndex];
                    nums[correctIndex] = temp;
                }else{
                    return nums[i];
                }
            }else{
                i++;
            }
        }
        return -1;
    }

    static List<Integer> findDisappearedNumbers(int[] nums){
        int i = 0;
        while (i < nums.length){
            int correctIndex = nums[i] - 1;
            if(nums[i]>=1 && nums[i]<=nums.length && nums[i] != nums[correctIndex]){
                //swap
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }else{
                i++;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j+1){
                list.add(j+1);
            }
        }
        return list;
    }

    static int missingNumber(int[] nums) {
        //1.Solution using sum of numbers
//        int sum = nums.length * (nums.length + 1) / 2;
//        int actualSum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            actualSum += nums[i];
//        }
//        return sum - actualSum;


        //2.Solution using cyclic sort
        int i = 0;
        while (i<nums.length){
            int correctIndex = nums[i];
            if (nums[i] >= 0 && nums[i] < nums.length && nums[i] != nums[correctIndex]){
                //swap
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }else{
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j){
                return j;
            }
        }
        return nums.length;
    }
}
