package properties.polymorphism;

public class Numbers {

    int sum(int a, int b){
        return a+b;
    }
    int sum(int a, int b, int c){
        return a+b+c;
    }
    double sum(double a, int b){
        return a+b;
    }

    public static void main(String[] args) {
        Numbers obj = new Numbers();
        System.out.println(obj.sum(1, 2));
        System.out.println(obj.sum(1, 2,3));
        System.out.println(obj.sum(88888888888888d, 2));
    }
}
