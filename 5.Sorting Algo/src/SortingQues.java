public class SortingQues {
    public static void main(String[] args) {
        //1. Missing Number (https://leetcode.com/problems/missing-number/description/)
        int[] nums = {3, 0, 1};
        int[] nums2 = {0, 1, 2};
        System.out.println(missingNumber(nums2));


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
