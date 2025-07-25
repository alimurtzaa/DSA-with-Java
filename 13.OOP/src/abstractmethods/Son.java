package abstractmethods;

public class Son extends Parent{

    Son (int age){
        super(age);
    }

    @Override
    public void career (String name){
        System.out.println("I will be a "+ name);
    }

}
