import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointer {
    public static void main(String[] args) {

        //1. Rotate Array (https://leetcode.com/problems/rotate-array/)
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));

        //2. Valid Palindrome (https://leetcode.com/problems/valid-palindrome/)
        String s = "A man, a plan, a canal: Panama";
        System.out.println(validPalindrome(s));

        //3. Valid Palindrome II (https://leetcode.com/problems/valid-palindrome-ii/)
        String s2 = "abca";
        System.out.println(validPalindrome2(s2));

        //4. Merge Strings Alternately (https://leetcode.com/problems/merge-strings-alternately)
        String word1 = "abc", word2 = "pqr";
        System.out.println(mergeAlternately(word1, word2));

        //5. Remove Duplicates from Sorted Array (https://leetcode.com/problems/remove-duplicates-from-sorted-array/)
        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums2));

        //6. 3 Sum (https://leetcode.com/problems/3sum/)
        int[] nums3 = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums3));

        //7. Container with most water (https://leetcode.com/problems/container-with-most-water/)
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));

        //8. Boats to Save People (https://leetcode.com/problems/boats-to-save-people/)
        int[] people = {3,2,2,1};
        int limit = 3;
        System.out.println(numRescueBoats(people, limit));

    }

    static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int i = 0;
        int j = people.length - 1;

        while (i <= j){
            if (people[i] + people[j] <= limit){
                i++;
                j--;
            } else {
                j--;
            }
            count++;
        }
        return count;
    }

    static int maxArea(int[] height) {
        int maxWater = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j){
            int currentWater = Math.min(height[i], height[j])*(j-i);
            if (currentWater > maxWater){
                maxWater = currentWater;
            }
            if (height[i] < height[j]){
                i++;
            } else{
                j--;
            }
        }
        return maxWater;
    }

    static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0){
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j-1]){
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]){
                        k--;
                    }
                } else if (sum > 0) {
                    k--;
                }else {
                    j++;
                }
            }
        }
        return list;
    }

    static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int j = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    static String mergeAlternately(String word1, String word2) {
        StringBuilder ans = new StringBuilder();
        int i = 0;
        int j = 0;

        while (i < word1.length() && j < word2.length()){
            ans.append(word1.charAt(i++));
            ans.append(word2.charAt(j++));
        }
        while (i < word1.length()) ans.append(word1.charAt(i++));
        while (j < word2.length()) ans.append(word2.charAt(j++));

        return ans.toString();
    }

    static boolean validPalindrome2(String s) {
        int i = 0;
        int j = s.length()-1;

        while (i < j){
            if (s.charAt(i) != s.charAt(j)){
                return isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1);
            }
            i++;
            j--;
        }
        return true;
    }
    static boolean isPalindrome(String s, int i, int j) {
        while (i < j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    static boolean validPalindrome(String s) {
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
