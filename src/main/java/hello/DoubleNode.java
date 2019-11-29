package hello;

public class DoubleNode {
    private int value;
    private DoubleNode pre;
    private DoubleNode next;


    public DoubleNode(int value, DoubleNode pre, DoubleNode next) {
        this.value = value;
        this.pre = pre;
        this.next = next;
    }

    public static void main(String[] args) {
        DoubleNode node1 = new DoubleNode(1, null, null);
        DoubleNode node2 = new DoubleNode(2, null, null);
        DoubleNode node3 = new DoubleNode(3, null, null);
        DoubleNode node4 = new DoubleNode(4, null, null);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.pre = node3;
        node3.pre = node2;
        node2.pre = node1;
        showLinkList(node1);
        DoubleNode node5 = new DoubleNode(5,null,null);
        insertNode(node4,null,node5);
        showLinkList(node1);
    }

    public static void showLinkList(DoubleNode node) {
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    public static void deleteNode(DoubleNode readyToDelete) {
        readyToDelete.pre.next = readyToDelete.next;
        readyToDelete.next.pre = readyToDelete.pre;
    }

    public static void insertNode(DoubleNode pre, DoubleNode next, DoubleNode readyToInsert) {
        if (pre.equals(next)){
            return;
        }
        pre.next = readyToInsert;
        readyToInsert.next = next;
        next.pre = readyToInsert;
        readyToInsert.pre = pre;
    }

}
