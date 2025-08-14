import java.lang.invoke.StringConcatException;
import java.util.Arrays;
import java.util.Stack;

public class Questions {

    //1. Implement Queue using Stacks (https://leetcode.com/problems/implement-queue-using-stacks/)
    public class QueueUsingStack {
        private Stack<Integer> first;
        private Stack<Integer> second;

        public QueueUsingStack(){
            this.first = new Stack<>();
            this.second = new Stack<>();
        }

        public void push(int item){
            first.push(item);
        }

        public int pop(){
            while(!first.isEmpty()){
                int item = first.pop();
                second.push(item);
            }
            int removed = second.pop();
            while (!second.isEmpty()){
                int item = second.pop();
                first.push(item);
            }
            return removed;
        }

        public int peek() {
            while(!first.isEmpty()){
                int item = first.pop();
                second.push(item);
            }
            int peeked = second.peek();
            while (!second.isEmpty()){
                int item = second.pop();
                first.push(item);
            }
            return peeked;
        }

        public boolean empty() {
            return first.isEmpty();
        }
    }

    //2. Game of two Stacks (https://www.hackerrank.com/challenges/game-of-two-stacks/problem)
    public int twoStacks(int x, int[] a, int[] b){
        return twoStacks(x, a, b, 0, 0) - 1;
    }
    private int twoStacks(int x, int[] a, int[] b, int sum, int count){
        if (sum > x){
            return count;
        }

        if (a.length == 0 || b.length == 0){
            return count;
        }

        int ans1 = twoStacks(x, Arrays.copyOfRange(a, 1, a.length), b, sum+a[0], count+1);
        int ans2 = twoStacks(x, a, Arrays.copyOfRange(b, 1, b.length), sum+b[0], count+1);

        return Math.max(ans1, ans2);
    }

    //3. Valid Parenthesis (https://leetcode.com/problems/valid-parentheses/)
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{' || ch == '(' || ch == '['){
                stack.push(ch);
            }else {
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if ((ch == '}' && top != '{') ||
                        (ch == ']' && top != '[') ||
                        (ch == ')' && top != '(')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    //4. Min add to make parenthesis valid ()
    public int minAddToMakeValid(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '('){
                stack.push(ch);
            }else {
                if (!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else {
                    stack.push(ch);
                }
            }
        }
        return stack.size();
        
    }

    //5. Min stack (https://leetcode.com/problems/min-stack/)
    class MinStack {
        Stack<Integer> s1;
        Stack<Integer> s2;

        public MinStack() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int val) {
            s1.push(val);
            if (s2.isEmpty() || s2.peek() >= val){
                s2.push(val);
            }
        }

        public void pop() {
            if (s1.peek().equals(s2.peek())){
                s2.pop();
            }
            s1.pop();
        }

        public int top() {
            return s1.peek();
        }

        public int getMin() {
            return s2.peek();
        }
    }

    //6. Next greater element I (https://leetcode.com/problems/next-greater-element-i/)
//    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//
//    }


}
