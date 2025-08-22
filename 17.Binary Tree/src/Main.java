import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        CustomBinaryTree tree = new CustomBinaryTree();
//        tree.populates(sc);
//        tree.display();

        BST tree = new BST();
        int[] nums = {15, 20, 12, 8, 10, 5, 4};
        tree.populates(nums);
        tree.display();

        tree.preOrder();
    }
}
