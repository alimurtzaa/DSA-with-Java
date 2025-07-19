import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backtracking {
    public static void main(String[] args) {

        //1. Combination Sum (https://leetcode.com/problems/combination-sum/)
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));

        //2. Combination Sum II (https://leetcode.com/problems/combination-sum-ii/description/)
        int[] candidates2 = {10,1,2,7,6,1,5};
        int target2 = 8;
        System.out.println(combinationSum2(candidates2, target2));

        //3. Subsets (https://leetcode.com/problems/subsets/)
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));

        //4. Permutations (https://leetcode.com/problems/permutations/)
        int[] nums2 = {1, 2, 3};
        System.out.println(permutations(nums2));

        //5. Combinations (https://leetcode.com/problems/combinations/)
        int n = 4;
        int k = 2;
        System.out.println(combination(n, k));

    }

    static List<List<Integer>> combination(int n, int k){
        List<List<Integer>> ans = new ArrayList<>();
        comb3helper(n, k, 1, ans, new ArrayList<>());
        return ans;
    }
    static void comb3helper(int n, int k, int start, List<List<Integer>> ans, List<Integer> comb){
        if (k == 0) {
            ans.add(new ArrayList<>(comb));
            return;
        }

        for (int i = start; i <= n; i++) {
            comb.add(i);
            comb3helper(n, k-1, i+1, ans, comb);
            comb.removeLast();
        }
    }

    static List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permutationHelper(nums, ans, 0);
        return ans;
    }
    static void permutationHelper(int[] nums, List<List<Integer>> ans, int index) {
        if (index == nums.length){
            List<Integer> temp = new ArrayList<>();
            for (int num: nums) temp.add(num);
            ans.add(temp);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            permutationHelper(nums, ans, index+1);
            swap(nums, i, index);
        }
    }
    static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subsetHelper(nums, ans, new ArrayList<>(), 0);
        return ans;
    }
    static void subsetHelper(int[] nums, List<List<Integer>> ans, List<Integer> subset, int index){
        if (index == nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        subsetHelper(nums, ans, subset, index + 1);
        subset.remove(subset.size() - 1);
        subsetHelper(nums, ans, subset, index + 1);
    }

    static List<List<Integer>> combinationSum2(int[] candidates, int target){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);

        comb2helper(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }
    static void comb2helper(int[] candidates, int target, int start, List<Integer> comb, List<List<Integer>> ans){
        if (target < 0) return;
        if (target == 0){
            ans.add(new ArrayList<>(comb));
            return;
        }

        for (int i = start; i < candidates.length; i++){
            if (i > start && candidates[i] == candidates[i-1]) continue;
            if (target >= candidates[i]){
                comb.add(candidates[i]);
                comb2helper(candidates, target-candidates[i], i+1, comb, ans);
                comb.removeLast();  // OR comb.remove(comb.size() - 1);
            }
        }
    }

    static List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> ans = new ArrayList<>();
        combHelper(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }
    static void combHelper(int[] candidates, int target, int start, List<Integer> comb, List<List<Integer>> ans){
        if (target == 0){
            ans.add(new ArrayList<>(comb));
            return;
        }

        if (start >= candidates.length) return;

        if (candidates[start] <= target){
            comb.add(candidates[start]);
            comb2helper(candidates, target - candidates[start], start, comb, ans);
            comb.remove(comb.size()-1);
        }
        comb2helper(candidates, target, start + 1, comb, ans);
    }
}
