package cloning;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Human h1 = new Human(20, "Ali");
        Human h2 = new Human(h1);
        System.out.println(h2.name);

        // cloning (Shallow copy)
        Human h3 = (Human) h1.clone();
        System.out.println(h3.name);
        System.out.println(h3.age);
        System.out.println(Arrays.toString(h3.arr));

        h3.arr[0] = 400;
        System.out.println(Arrays.toString(h3.arr));
        System.out.println(Arrays.toString(h1.arr)); // h1 also got changed


        // cloning (Deep copy)
        Human h4 = (Human) h1.clone();
        h4.arr[0] = 400;
        System.out.println(Arrays.toString(h4.arr));
        System.out.println(Arrays.toString(h1.arr)); // h1 will not change
    }
}
