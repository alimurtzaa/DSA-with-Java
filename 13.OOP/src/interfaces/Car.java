package interfaces;

public class Car implements Engine, Brake{
    int a = 10;

    @Override
    public void accelerate() {
        System.out.println("I can accelerate");
    }

    @Override
    public void brake() {
        System.out.println("I can brake");
    }

    @Override
    public void start() {
        System.out.println("I can start");
    }

    @Override
    public void stop() {
        System.out.println("I can stop");
    }
}
