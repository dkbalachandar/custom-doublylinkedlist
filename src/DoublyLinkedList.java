
/**
 * Doubly linked list implementation in Java
 */
public class DoublyLinkedList {

    private Node head;

    private Node tail;

    private int size;

    public void insertFirst(Object data) {

        //Create a new node
        Node temp = new Node(data);
        if (isEmpty()) {
            //If its empty, then point tail to that node
            tail = temp;
        } else {
            //If its not empty, then point head node prev link to the temp node.
            head.prev = temp;
        }
        //Point the temp node next to head node
        temp.next = head;
        head = temp;
        size++;
    }

    public void insertLast(Object data) {

        //Create a new node
        Node temp = new Node(data);
        if (isEmpty()) {
            //If its empty, then point head to that node
            head = temp;
        } else {
            //If its not empty, then point tail node next link to the temp node.
            tail.next = temp;
            temp.prev = tail;
        }
        tail = temp;
        size++;
    }

    /**
     * Method to remove the first element
     *
     * @return Object
     */
    public Object removeFirst() {

        if (isEmpty()) {
            System.out.println("Empty list");
            return null;
        }
        Node current = head;
        head = head.next;
        head.prev = null;
        size--;
        return current.getData();
    }

    public Object removeLast() {

        if (isEmpty()) {
            System.out.println("Empty list");
            return null;
        }
        Node current = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        return current.getData();
    }

    /**
     * Method to print the node elements
     */
    public void printElements() {

        Node current = head;
        while (current.getNext() != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
        System.out.println(current.getData());
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    /**
     * A static inner class represents a Node.
     */
    private static class Node {

        private Object data;

        private Node prev;

        private Node next;

        public Node(Object data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

        public Object getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }
    }

    public static void main(String[] args) {

        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.insertFirst("String1");
        linkedList.insertLast("String2");
        linkedList.insertLast("String3");
        linkedList.insertLast("String4");
        System.out.println("Size of the Linked List is :" + linkedList.getSize());
        linkedList.printElements();
        System.out.println("==============================");
        System.out.println("Going to remove the elements");
        System.out.println("Remove Last Element");
        linkedList.removeLast();
        linkedList.printElements();
        System.out.println("Remove First Element");
        linkedList.removeFirst();
        linkedList.printElements();
    }
}
