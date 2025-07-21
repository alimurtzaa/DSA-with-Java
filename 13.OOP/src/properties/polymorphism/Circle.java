package properties.polymorphism;

public class Circle extends Shapes{

//    @Override // called annotations, it just checks that area function is overridden
    void area(){
        System.out.println("Area is pi*r*r");
    }

    //cannot be overridden as superclass method peri is static
//    @Override
//    void peri(){
//        System.out.println("In the circle with peri");
//    }
}
