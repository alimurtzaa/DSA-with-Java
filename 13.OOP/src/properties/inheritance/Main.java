package properties.inheritance;

public class Main {
    public static void main(String[] args) {
        System.out.println(Box.size);
        System.out.println(BoxWeight.size);

        BoxWeight box1 = new BoxWeight(2, 3 ,4 , 50);
        System.out.println(box1.b);

        // can also do
        Box box2 = new BoxWeight(2, 5, 6, 80);
        System.out.println(box2.b);
        // System.out.println(box2.weight); error, only access that Box has

        // but cannot do this
        // BoxWeight box3 = new Box(2, 5, 7); as it depends on reference, here BoxWeight needs weight also but Box constuctor dont have it

    }
}
