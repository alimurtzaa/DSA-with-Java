import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
