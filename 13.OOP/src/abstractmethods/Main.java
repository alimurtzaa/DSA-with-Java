package abstractmethods;

public class Main {
    public static void main(String[] args) {

        Son s = new Son(18);

        s.career("engineer");
        System.out.println(s.age);

        //you cannot direct use Parent constructor as we cannot create objects of abstract classes
        //Parent p = new Parent(23); error
    }
}
