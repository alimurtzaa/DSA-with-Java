public class Main {
    public static void main(String[] args) {

        // SINGLY LINKEDLIST
        CustomLL list = new CustomLL();
        list.insertFirst(23);
        list.insertFirst(41);
        list.insertFirst(4);
        list.insertFirst(12);
        list.insertFirst(3);

        list.insertLast(99);

//        list.display();

        list.insert(0, 2);
//        list.display();

//        System.out.println(list.deleteFirst());
//        list.display();

//        System.out.println(list.deleteLast());
//        list.display();

//        System.out.println(list.delete(3));
//        list.display();


        // DOUBLY LINKEDLIST
        CustomDLL list2 = new CustomDLL();
        list2.insertFirst(0);
        list2.insertFirst(41);
        list2.insertFirst(4);
        list2.insertFirst(12);
        list2.insertFirst(3);
//        list2.display();

        list2.insertLast(99);
//        list2.display();

        list2.insert(4, 100);
//        list2.display();


        //CIRCULAR LL
        CustomCLL list3 = new CustomCLL();
        list3.insert(34);
        list3.insert(76);
        list3.insert(2);
        list3.insert(90);
        list3.insert(4);

//        list3.display();

        list3.delete(2);

//        list3.display();

        //recursion in LL
//        list.display();
        list.insertRec(89, 2);
//        list.display();

        //bubble sort
        CustomLL list4 = new CustomLL();
        for (int i = 7; i > 0; i--) {
            list4.insertLast(i);
        }
        list4.display();
        list4.bubbleSort();
        list4.display();
    }
}