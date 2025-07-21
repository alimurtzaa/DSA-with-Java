package properties.inheritance;

public class Box {
    static int size = 20;
    int l;
    int b;
    int h;

    Box (){
        this.l = -1;
        this.b = -1;
        this.h = -1;
    }

    Box (int l, int b, int h){
        this.l = l;
        this.b = b;
        this.h = h;
    }
}
