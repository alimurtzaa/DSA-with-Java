public class Main {
    public static void main(String[] args) {
        CustomLL list = new CustomLL();
        list.insertFirst(23);
        list.insertFirst(41);
        list.insertFirst(4);
        list.insertFirst(12);
        list.insertFirst(3);

        list.insertLast(99);

        list.display();

        list.insert(0, 2);

        System.out.println(list.deleteFirst());

        list.display();
    }
}