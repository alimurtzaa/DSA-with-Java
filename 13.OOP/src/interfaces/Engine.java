package interfaces;

public interface Engine {
    void start();
    void stop();
    void accelerate();

    static void iAmStaticMethod(){
        System.out.println("I require body in interfaces, as i am static");
    }
}
