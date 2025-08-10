public class StackMain {
    public static void main(String[] args) throws StackException {

        CustomStack stack = new CustomStack();
//        stack.push(34);
//        stack.push(75);
//        stack.push(65);
//        stack.push(23);
//
//        System.out.println(stack.peek());
//
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());

        //System.out.println(stack.pop());  stack is empty : custom Exception

        DynamicStack stack2 = new DynamicStack();

        stack.push(75);
        stack.push(65);
        stack.push(23);
        stack.push(43);
        stack.push(67);
        stack.push(90);
        stack.push(11);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        // CustomStack tells what functions can be accessed
        // DynamicStack tells what version of those function to access
        CustomStack stack3 = new DynamicStack();

    }
}