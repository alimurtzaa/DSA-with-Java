import java.util.*;

public class InbuiltClasses {
    public static void main(String[] args) {
        //STACK
        Stack<Integer> stack = new Stack<>();

        stack.push(23);
        stack.push(12);
        stack.push(56);
        stack.push(33);
        stack.push(87);

//        System.out.println(stack.pop()); // returns poped element
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());

        //System.out.println(stack.pop()); error because now stack is empty


        //QUEUE
        Queue<Integer> queue = new LinkedList<>();

        queue.add(23);
        queue.add(65);
        queue.add(54);
        queue.add(12);

//        System.out.println(queue.remove());
//        System.out.println(queue.remove());


        //DEQUE
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(78);
        deque.addLast(43);
        System.out.println(deque.getFirst());
        System.out.println(deque.remove());

    }
}
