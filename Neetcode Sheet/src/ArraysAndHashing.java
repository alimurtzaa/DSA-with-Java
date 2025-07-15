import java.util.Arrays;

public class ArraysAndHashing {
    public static void main(String[] args) {

        //1. Product of Array Except Self (https://leetcode.com/problems/product-of-array-except-self/description/)
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));

    }

    static int[] productExceptSelf(int[] nums){
        int[] ans = new int[nums.length];

        ans[0] = 1;
        // Prefix sum
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1]*nums[i - 1];
        }

        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= suffix;
            suffix *= nums[i];
        }
        return ans;
    }
}
