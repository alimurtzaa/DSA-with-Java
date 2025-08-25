import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {

        //1. Printing  permutations
        permutations("", "abc");

        //2. Returning Arraylist of permutations
        System.out.println(permutations2("", "abcd"));

        //3. Counting permutations (formula = n!)
        System.out.println(permutationsCount("", "abcd"));

        //4. PhonePad (https://leetcode.com/problems/letter-combinations-of-a-phone-number/)
        System.out.println(letterCombinations("", "21"));

        //5. Dice Sum Combinations

        // Printing
        diceSum("", 4);

        // Returning array
        System.out.println(diceSumArray("", 4));

        // N face dice (means now it can use 1 to n values to make sum equal to target)
        System.out.println(nFaceDiceSum("", 8, 7));

    }

    static ArrayList<String> nFaceDiceSum(String p, int target, int face) {
        ArrayList<String> list = new ArrayList<>();
        if (target == 0) {
            list.add(p);
            return list;
        }
        for (int i = 1; i <= face && i <= target; i++) {
            list.addAll(nFaceDiceSum(p + i, target - i, face));
        }
        return list;
    }
    static ArrayList<String> diceSumArray(String p, int target){
        ArrayList<String> list = new ArrayList<>();
        if (target == 0){
            list.add(p);
            return list;
        }
        for (int i = 1; i <= 6 && i <= target; i++) {
            list.addAll(diceSumArray(p + i, target - i));
        }
        return list;
    }
    static void diceSum(String p, int target){
        if (target == 0){
            System.out.println(p);
            return;
        }
        for (int i = 1; i <= 6 && i <= target; i++) {
            diceSum(p + i, target - i);
        }
    }

    static ArrayList<String> letterCombinations(String p, String up) {
        ArrayList<String> list = new ArrayList<>();
        if (up.isEmpty()){
            list.add(p);
            return list;
        }
        int digit = up.charAt(0) - '0';
        int start = 3*(digit - 1);
        int end = 3*(digit);
        for (int i = start; i < end; i++) {
            char ch = (char)('a' + i);
            List<String> ans = letterCombinations(ch + p, up.substring(1));
            list.addAll(ans);
        }
        return list;
    }

    static int permutationsCount(String p, String up){
        if (up.isEmpty()){
            return 1;
        }
        int count = 0;
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++){
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            count = count + permutationsCount(f + ch + s, up.substring(1));
        }
        return count;
    }

    static ArrayList<String> permutations2(String p, String up){
        ArrayList<String> list = new ArrayList<>();
        if (up.isEmpty()){
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++){
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            ArrayList<String> ansFromAboveCall = permutations2(f + ch + s, up.substring(1));
            list.addAll(ansFromAboveCall);
        }
        return list;
    }

    static void permutations(String p, String up){
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++){
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            permutations(f + ch + s, up.substring(1));
        }
    }
}
