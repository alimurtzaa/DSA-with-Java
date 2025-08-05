public class CustomLL {
    private Node head;
    private Node tail;
    private int size;

    public CustomLL (){
        this.size = 0;
    }

    public void insertFirst (int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null){
            tail = head;
        }
        size++;
    }

    public void insertLast (int val){
        if (tail == null){
            insertFirst(val);
            return;
        }

        Node node = new Node(val);
        tail.next = node;
        tail = node;

        size++;
    }

    public void insert (int val, int index){
        if (index == 0){
            insertFirst(val);
            return;
        }
        if (index == size){
            insertLast(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }

    //insert using recursion
    public void insertRec (int val, int index){
        head = insertRec(val, index, head);
    }
    private Node insertRec(int val, int index, Node node){
        if (index == 0){
            Node temp = new Node(val, node);
            temp.next = node;
            size++;
            return temp;
        }
        node.next = insertRec(val, --index, node.next);
        return node;
    }

    public int deleteFirst (){
        int val = head.val;
        head = head.next;
//        if (size == 1){
//            tail = tail.next;
//        }
        //OR
         if (head == null){
             tail = null;
         }
        size--;
        return val;
    }

    public int deleteLast (){
        if (size == 1){
            return deleteFirst();
        }
        Node secondLast = get(size - 2);
        int val = secondLast.next.val;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }

    public int delete (int index){
        if (index == 0){
            return deleteFirst();
        }
        if (index == size - 1){
            return deleteLast();
        }

        Node prev = get(index - 1);
        int val = prev.next.val;
        prev.next = prev.next.next;
        return val;
    }

    public Node find (int val){
        Node temp = head;
        while (temp != null){
            if (temp.val == val){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public Node get (int index){
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }


    public void display (){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    private class Node {
        private int val;
        private Node next;

        public Node (int val){
            this.val = val;
        }

        public Node (int val, Node next){
            this.val = val;
            this.next = next;
        }
    }

    //Questions

    // 1. remove duplicates (https://leetcode.com/problems/remove-duplicates-from-sorted-list/)
    public void duplicates(){
        Node node = head;
        while (node.next != null){
            if (node.val == node.next.val){
                node.next = node.next.next;
                size--;
            }else {
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

    // bubble sort
    public void bubbleSort (){
        bubbleSort (size-1, 0);
    }
    private void bubbleSort(int i, int j) {
        if (i == 0){
            return;
        }
        if (j < i){
            Node first = get(j);
            Node second = get(j+1);
            if (first.val > second.val){
                //swap
                if (first == head){
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) {
                    Node prev = get(j-1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = first;
                } else {
                    Node prev = get(j-1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(i, j+1);
        } else {
            bubbleSort(i - 1, 0);
        }
    }

    // reversing a LL
    public void reverse(Node node){
        if (node == tail){
            head = tail;
            return;
        }
        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    // inplace reversal
    public void reverse(){
        if (size < 2){
            return;
        }
        Node prev = null;
        Node curr = head;
        Node forward = curr.next;
        while (curr != null){
            curr.next = prev;
            prev = curr;
            curr = forward;
            if (forward != null){
                forward = forward.next;
            }
        }
        head = prev;
    }
}

