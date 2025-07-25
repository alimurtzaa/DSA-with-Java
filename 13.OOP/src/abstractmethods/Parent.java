package abstractmethods;

public abstract class Parent {

    int age;

    public Parent (int age){
        this.age = age;
    }

    abstract void career (String name);

    // cannot define abstract static method
    //abstract static void hobby(){
    //}
}
