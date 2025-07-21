package properties.polymorphism;

public class Shapes {
    void area(){
        System.out.println("In the shape");
    }

    // this can not be overridden, as it is final
//    final void area(){
//        System.out.println("In the shape");
//    }

    // this can not be overridden, as it is static and it will always be runed from here when you even call it from child class
    static void peri(){
        System.out.println("In the shape with peri");
    }
}
