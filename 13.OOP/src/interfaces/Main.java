package interfaces;

public class Main {
    public static void main(String[] args) {

        Car c = new Car();

        c.accelerate();
        c.start();
        c.stop();
        c.brake();
        System.out.println(c.a);

        //can also do
        Engine c2 = new Car();
        c2.accelerate();
        //but cannot access variables that is only in Car not Engine
        //System.out.println(c2.a); error
    }
}
