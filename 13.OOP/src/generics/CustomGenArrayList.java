package generics;

import java.util.Arrays;

//public class CustomGenArrayList<T extends Number> { // wildcard (restriction) = this will ensure T can be Number or its subclasses(like integer, float ...)
public class CustomGenArrayList<T> {
    private Object[] data;
    private int size = 0;
    private static int DEFAULT_SIZE = 10;

    public CustomGenArrayList() {
        this.data = new Object[DEFAULT_SIZE];
    }

    public void add(T num){
        if (isFull()){
            resize();
        }
        data[size++] = num;
    }

    private boolean isFull(){
        return data.length == size;
    }

    private void resize(){
        Object[] temp = new Object[2* data.length];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public T remove(){
        T removed = (T)(data[--size]);
        return removed;
    }

    public T get(int index){
        return (T)data[index];
    }

    @Override
    public String toString() {
        return "CustomGenArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        CustomGenArrayList<String> list = new CustomGenArrayList<>(); //,define type in generics
        list.add("ewhewud");
        //list.add(9); error
    }

}
