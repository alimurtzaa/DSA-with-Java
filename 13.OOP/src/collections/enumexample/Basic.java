package collections.enumexample;

public class Basic {
    enum Week {
        Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;
        // these are enum constants
        // public, static, final
        // As final so you can not create child enum
        // type is Week


        Week() {
            System.out.println(" constructor for "+ this);
        }
    }

    public static void main(String[] args) {
        Week w = Week.Monday;
        System.out.println(w);
        System.out.println(w.ordinal()); // like index

        for (Week day: Week.values()){
            System.out.println(day);
        }


    }
}
