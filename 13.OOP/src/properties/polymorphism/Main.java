package properties.polymorphism;

public class Main {
    public static void main(String[] args) {
        Shapes s1 = new Shapes();
        Circle s2 = new Circle();
        Triangle s3 = new Triangle();

        s1.area();
        s2.area();
        s3.area();

        Shapes s4 = new Circle();

        s4.area(); // will call area from Circle

        //instance of
        System.out.println(s2 instanceof Shapes); //true
        System.out.println(s2 instanceof Circle); //true
        System.out.println(s2 instanceof Object); //true

       // System.out.println(s2 instanceof Triangle); error

        //getClass()
        System.out.println(s3.getClass());
        // in getClass() you have many methods which can be used
        System.out.println(s3.getClass().getName());

    }
}
