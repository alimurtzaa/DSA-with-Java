public class Questions {
    public static void main(String[] args) {

        CustomLL list = new CustomLL();
        list.insertLast(4);
        list.insertLast(4);
        list.insertLast(5);
        list.insertLast(8);
        list.insertLast(8);
        list.insertLast(8);

        list.display();
        list.duplicates();
        list.display();
    }
}
