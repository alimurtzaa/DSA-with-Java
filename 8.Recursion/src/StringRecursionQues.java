import java.util.ArrayList;
import java.util.Arrays;

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


    }

    static void subSequenceAscii( String p, String up){  // p=processed, up=unprocessed
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
