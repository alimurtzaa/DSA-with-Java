import java.util.Arrays;

public class MathsAndGeometry {
    public static void main(String[] args) {

        //1. Plus One (https://leetcode.com/problems/plus-one/description/)
        int[] digits = {4,3,2,9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    static int[] plusOne(int[] digits){
        for (int i = digits.length-1; i >= 0; i--) {
            if (digits[i]+1 != 10){
                digits[i] +=1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newDigits = new int[digits.length+1];
        newDigits[0] = 1;
        return newDigits;
    }
}