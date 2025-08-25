import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringRecursionQues {
    public static void main(String[] args) {

        //1. Skip a character
        //just printing
        String word = "murtzaali";
        skipChar(word, "");

        //returning the string
        System.out.println(skipChar2(word));
        //original string is not changing
        System.out.println(word);

        //2. Skip string
        String word2 = "bachappleay";
        System.out.println(skipApple(word2));

        //3. Skip app only if it is not apple
        String word3 = "bappachappleay";
        System.out.println(skipAppNotApple(word3));

        // SUBSTRING QUES

        //4. Subsequence
        subSequence("", "abc");

        //5. Subsequence in Arraylist
        System.out.println(subSequence2("", "abc"));

        //6. Subsequence with their Ascii value
        subSequenceAscii("", "abc");

        //7. Subsets with loops
        int[] arr = {1, 2, 3};
        List<List<Integer>> ans = subset(arr);
        for (List<Integer> list: ans){
            System.out.println(list);
        }

        //8. Subsets (if duplicates) with loops
        int[] arr2 = {2, 1, 2};
        List<List<Integer>> ans2 = subsetDuplicates(arr2);
        for (List<Integer> list: ans2){
            System.out.println(list);
        }

        //9. Find the K-th Character in String Game I (https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/description/)
        int k = 5;
        System.out.println(kthCharacter(k));

    }

    static char kthCharacter(int k){
        StringBuilder sb = new StringBuilder("a");
        while (sb.length() < k){
            int n = sb.length();
            for (int i = 0; i < n; i++){
                char ch = (char)(sb.charAt(i) + 1);
                sb.append(ch);
            }
        }
        return sb.charAt(k-1);
    }

    static List<List<Integer>> subsetDuplicates(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++){
            start = 0;
            if (i > 0 && arr[i] == arr[i-1]) {
                start =  end + 1;
            }
            end = outer.size() - 1;
            int n = outer.size();
            for (int j = start; j < n; j++) {
                List<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(arr[i]);
                outer.add(inner);
            }
        }
        return outer;
    }

    static List<List<Integer>> subset(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for (int num: arr){
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }
        return outer;
    }

    static void subSequenceAscii( String p, String up){
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subSequenceAscii(p, up.substring(1));
        subSequenceAscii(p + ch, up.substring(1));
        subSequenceAscii(p + (ch+0), up.substring(1));
    }

    static ArrayList<String> subSequence2(String p, String up){
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> right = subSequence2(p + ch, up.substring(1));
        ArrayList<String> left = subSequence2(p, up.substring(1));
        left.addAll(right);
        return left;
    }

    static void subSequence( String p, String up){  // p=processed, up=unprocessed
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subSequence(p, up.substring(1));
        subSequence(p + ch, up.substring(1));
    }

    static String skipAppNotApple(String word) {
        if (word.isEmpty()) return "";

        if (word.startsWith("app") && !word.startsWith("apple")){
            return skipAppNotApple(word.substring(3));
        }
        return word.charAt(0) + skipAppNotApple(word.substring(1));
    }

    static String skipApple(String word) {
        if (word.isEmpty()) return "";

        if (word.startsWith("apple")){
            return skipApple(word.substring(5));
        }
        return word.charAt(0) + skipApple(word.substring(1));
    }

    static String skipChar2(String word) {
        if (word.isEmpty()) {
            return "";
        }
        char ch = word.charAt(0);

        if (ch == 'a') {
            return skipChar2(word.substring(1));
        } else {
            return ch + skipChar2(word.substring(1));
        }
    }

    static void skipChar(String word, String skipedWord){
        if (word.isEmpty()){
            System.out.println(skipedWord);
            return;
        }
        char ch = word.charAt(0);

        if (ch == 'a'){
            skipChar(word.substring(1), skipedWord);
        }else {
            skipedWord += ch;
            skipChar(word.substring(1), skipedWord);
        }

    }
}
