public class QueueMain {
    public static void main(String[] args) throws Exception {

        CustomQueue queue = new CustomQueue(5);

//        queue.insert(23);
//        queue.insert(65);
//        queue.insert(54);
//        queue.insert(12);
//
//        queue.display();
//
//        System.out.println(queue.front());
//
//        System.out.println(queue.remove());
//
//        queue.display();


        CircularQueue queue2 = new CircularQueue(5);

        queue2.insert(23);
        queue2.insert(65);
        queue2.insert(54);
        queue2.insert(12);

        queue2.display();

        System.out.println(queue2.front());

        System.out.println(queue2.remove());
        queue2.insert(45);

        queue2.display();
    }
}
