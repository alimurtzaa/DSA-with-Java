package exceptionHandling;

public class Main {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        try{
            divide(a, b);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("This will always run.");
        }
    }
    static int divide(int a, int b) throws ArithmeticException{
        if (b == 0){
            throw new ArithmeticException("You can not divide by zero");
        }
        return a/b;
    }
}
