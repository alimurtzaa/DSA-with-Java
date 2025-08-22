public class BST {
    private Node root;

    public BST(){

    }

    class Node {
        private int val;
        private int height;
        private Node left;
        private Node right;

        public Node(int val){
            this.val = val;
        }

        public int getVal() {
            return val;
        }

    }

    public int height(Node node){
        if (node == null) return -1;
        return node.height;
    }

    public boolean isEmpty(Node node){
        return root == null;
    }

    public void display(){
        display(root, "Root Node: ");
    }
    public void display(Node node, String details){
        if (node == null) return;

        System.out.println(details + node.val);
        display(node.left, "Left child of " + node.val + ": ");
        display(node.right, "Right child of " + node.val + ": ");
    }

    public void insert(int val){
        root = insert(val, root);
    }
    private Node insert(int val, Node node){
        if (node == null){
            node = new Node(val);
            return node;
        }

        if (node.val > val){
            node.left = insert(val, node.left);
        }
        if (node.val < val){
            node.right = insert(val, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public boolean balanced(){
        return balanced(root);
    }
    private boolean balanced(Node node){
        if (node == null){
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void populates(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    public void populatesSorted(int[] nums){
        populatesSorted(nums, 0, nums.length);
    }
    private void populatesSorted(int[] nums, int start, int end){
        if (start >= end) return;

        int mid = start + (end - start)/2;
        insert(nums[mid]);
        populatesSorted(nums, start, mid);
        populatesSorted(nums, mid+1, end);
    }

    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if (node == null) return;

        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(){
        preOrder(root);
    }
    private void inOrder(Node node){
        if (node == null) return;

        preOrder(node.left);
        System.out.print(node.val + " ");
        preOrder(node.right);
    }

    public void postOrder(){
        preOrder(root);
    }
    private void postOrder(Node node){
        if (node == null) return;

        preOrder(node.left);
        preOrder(node.right);
        System.out.print(node.val + " ");
    }
}
