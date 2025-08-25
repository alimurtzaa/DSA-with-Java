import java.util.ArrayList;
import java.util.Arrays;

public class StringandStringBuilder {
    public static void main(String[] args) {
        String a = "ali";
        String b = "ali";
        System.out.println(a==b); //true
        System.out.println(a.equals(b)); //true

        String name1 = new String("bro");
        String name2 = new String("bro");
        System.out.println(name1==name2); //false
        System.out.println(name1.equals(name2)); //true

        //pretty printing
        float n = 324.3476f;
        System.out.printf("formatted number is: %.2f \n", n);  //324.35
        System.out.printf("Hello my name is %s and my age is %d.\n", "ali ", 21);

        //operators
        System.out.println('a' + 'b');  //195
        System.out.println("a" + "b");  //ab
        System.out.println("a" + 'b');  //ab
        System.out.println("a" + 1);    //a1
        System.out.println('a' + 1);    //97+1=98
        System.out.println((char)('a' + 1));    //(char)98 = b
        System.out.println("a" + new ArrayList<>());    //a[]
        System.out.println(new int[2] + "" +new ArrayList<>());    //[I@4769b07b[]
//        System.out.println(new int[] + new ArrayList<>());    //error
//        System.out.println(1+new ArrayList<>());  //error
        System.out.println('a'-'b'); //-1
//        System.out.println("a"-"b"); //error

        //performance
        String series = "";
        for (int i = 0; i < 26; i++) {
            char ch = (char)('a'+i);    //everytime new object is created as String is immutable = a, ab, abc, abcd ...., abcdefghijklmnopqrstuvwxyz
            series+=ch;                 //memory is wasted so String Builder = can change it
        }
        System.out.println(series);

        //using String Builder
        StringBuilder alphabets = new StringBuilder("");
        for (int i = 0; i < 26; i++) {
            char ch = (char)('a'+i);
            alphabets.append(ch);
        }
        System.out.println(alphabets);

        //string methods
        String nm = "Murtza Ali";
        System.out.println(nm.indexOf('a'));  //5
        System.out.println(Arrays.toString(nm.split(" "))); //[Murtza, Ali]
        System.out.println("  bro   ".strip()); //bro

        //1. Palindrome
        String st = "Raar";
        boolean isPalindrome = true;
        st = st.toLowerCase();
        for (int i = 0; i <= st.length()/2; i++) {
            if(st.charAt(i) != st.charAt(st.length()-i-1)){
                isPalindrome = false;
            }
        }
        System.out.println(isPalindrome);
    }
}