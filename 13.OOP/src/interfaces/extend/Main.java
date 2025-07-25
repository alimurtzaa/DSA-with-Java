package interfaces.extend;

public class Main implements B{

    @Override
    public void demo() {
        System.out.println("from interface A");
    }

    @Override
    public void demoB() {
        System.out.println("from interface B");
    }
}
