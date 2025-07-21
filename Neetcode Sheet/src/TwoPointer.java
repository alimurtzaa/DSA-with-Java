import java.util.Arrays;

public class TwoPointer {
    public static void main(String[] args) {

        //1. Rotate Array (https://leetcode.com/problems/rotate-array/)
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));

        //2. Valid Palindrome (https://leetcode.com/problems/valid-palindrome/)
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));


    }

    static boolean isPalindrome(String s) {
        if (s.isEmpty()){
            return true;
        }
        int start = 0;
        int end = s.length()-1;
        while(start <= end) {
            char chStart = s.charAt(start);
            char chEnd = s.charAt(end);
            if (!Character.isLetterOrDigit(chStart)){
                start++;
            }
            else if (!Character.isLetterOrDigit(chEnd)){
                end--;
            }
            else{
                if (Character.toLowerCase(chStart) != Character.toLowerCase(chEnd)){
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

    static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    static void reverse(int[] nums, int s, int e){
        while (s < e){
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }
}
