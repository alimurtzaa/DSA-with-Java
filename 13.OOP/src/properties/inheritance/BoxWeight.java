package properties.inheritance;

public class BoxWeight extends Box{
    int weight;

    BoxWeight (){
        super();
        this.weight = -1;
    }

    BoxWeight (int l, int b, int h, int weight){
        super(l, b, h);
        this.weight = weight;
    }
}
