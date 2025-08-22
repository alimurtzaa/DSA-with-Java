import java.util.Scanner;

public class CustomBinaryTree {
    private Node root;

    public CustomBinaryTree(){

    }

    private static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }


    public void populates(Scanner sc){
        System.out.println("Enter the root Node: ");
        int val = sc.nextInt();
        root = new Node(val);
        populates(sc, root);
    }
    private void populates(Scanner sc, Node node){
        System.out.println("Do you want to enter on left of "+ node.val);
        boolean left = sc.nextBoolean();
        if (left){
            System.out.println("Enter the value of the left of "+ node.val);
            int val = sc.nextInt();
            node.left = new Node(val);
            populates(sc, node.left);
        }

        System.out.println("Do you want to enter on right of "+ node.val);
        boolean right = sc.nextBoolean();
        if (right){
            System.out.println("Enter the value of the right of "+ node.val);
            int val = sc.nextInt();
            node.right = new Node(val);
            populates(sc, node.right);
        }
    }

    public void display(){
        display(root, "");
    }
    private void display(Node node, String indent){
        if (node == null){
            return;
        }

        System.out.println(indent + node.val);
        display(node.left, indent+"\t");
        display(node.right, indent+"\t");
    }
}