package generics;

import java.util.Arrays;

public class CustomArrayList {
    private int[] data;
    private int size = 0;
    private static int DEFAULT_SIZE = 10;

    public CustomArrayList() {
        this.data = new int[DEFAULT_SIZE];
    }

    public void add(int num){
        if (isFull()){
            resize();
        }
        data[size++] = num;
    }

    private boolean isFull(){
        return data.length == size;
    }

    private void resize(){
        int[] temp = new int[2* data.length];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public int remove(){
        int removed = data[--size];
        return removed;
    }

    public int get(int index){
        return data[index];
    }

    @Override
    public String toString() {
        return "CustomArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList();
        list.add(8);
        list.add(5);
        list.add(3);
        list.add(1);
        System.out.println(list);
        System.out.println(list.remove());
        list.add(99);
        System.out.println(list);

        //list.add("wqdjd"); error

    }

}
