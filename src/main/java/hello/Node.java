package hello;

public class Node {
    private int value;
    private Node next;
    private static Node node = initializeNode();
    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public static Node initializeNode() {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        return node1;
    }

    public void addNode(int locate){
    }

    public void deleteNode(int locate){

    }
}
