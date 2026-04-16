public class LinkedList {

    Node head;
    Node tail;
    int size = 0;
    int getValue = -1;

    private class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public String toString() {
            return "[ NODE " + val + " ]";
        }
    }

    public LinkedList() {

    }

    public int get(int index) {
        Node currentNode = head;
        if (size <= 0 || index >= size) {
            return -1;
        }
        for (int i = 0; i < size; i++) {
            // System.out.println("curr node ->" + currentNode + " index: " + i);
            if (i == index) {
                return currentNode.val;
            }
            currentNode = currentNode.next;
        }
        return -1;
    }

    public void insertHead(int val) {
        Node insertNode = new Node(val, null);
        if (head == null && tail == null) {
            head = insertNode;
            tail = insertNode;
            size++;
            return;
        }
        if (head != null) {
            Node headNode = head;
            head = insertNode;
            head.next = headNode;
            size++;
            return;
        }
        head = insertNode;
        size++;
    }

    public void insertTail(int val) {
        Node insertNode = new Node(val, null);
        if (head == null && tail == null) {
            head = insertNode;
            tail = insertNode;
            size++;
            return;
        }
        if (tail != null) {
            tail.next = insertNode;
            tail = insertNode;
            size++;
            return;
        }
        tail = insertNode;
        tail.next = insertNode;
        size++;
    }

    public boolean remove(int index) {
        Node currentNode = head;
        if (size <= 0 || index >= size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (index == 0) {
                head = head.next;
                size--;
                return true;
            }
            if (i == index - 1) {
                Node elementToDelete = currentNode.next;
                if (elementToDelete == tail) {
                    tail = elementToDelete.next == null ? currentNode : elementToDelete.next;
                }
                currentNode.next = elementToDelete.next;
                size--;
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();
        Node currentNode = head;
        while (currentNode != null) {
            values.add(currentNode.val);
            currentNode = currentNode.next;
        }
        ;
        return values;
    }
}
