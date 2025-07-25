package generics.comparision;

public class Main {
    public static void main(String[] args) {
        Student bob = new Student(23, 89.78f);
        Student rahul = new Student(3, 91.08f);

        if (rahul.compareTo(bob) > 0){
            System.out.println(rahul.compareTo(bob));
            System.out.println("Rahul has More marks.");
        }
    }
}
