/**
 * This class represents a node in the linked list.
 * NOTE: This class is a modified version of the class
 * in Deitel and Deitel's Java How To Program Early Objects, 10th Edition
 * @author Sophia Mallaro
 * @see ListNode
 */
public class ListNode<T> {
    public T data;
    public ListNode<T> nextNode;
    public ListNode<T> previousNode;

    /**
     * Constructor that makes a node with null next and previous nodes
     * @param data Data of node
     */
    ListNode(T data) {
        this(data, null, null);
    }

    /**
     * Constructs a node with the given data and next node and a null previous node
     * @param data Data of node to be added
     * @param nextNode Next node in the list
     */
    ListNode(T data, ListNode<T> nextNode) {
        this(data, null, nextNode);
    }

    /**
     * Copy constructor
     * @param node Node to be copied
     */
    ListNode(ListNode<T> node) {
        this(node.data, node.nextNode, node.previousNode);
    }

    /**
     * Constructor with data, next node and previous node
     * @param data Element data
     * @param nextNode Next node in the list
     * @param previousNode Previous node in the list
     */
    ListNode(T data, ListNode<T> nextNode, ListNode<T> previousNode ) {
        this.data = data;
        this.nextNode = nextNode;
        this.previousNode = previousNode;
    }

    /**
     * Returns node's data
     * @return Node's data
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the data of the node
     * @param data Data
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Returns the next node in the list
     * @return next node in the list
     */
    public ListNode<T> getNext() {
        return nextNode;
    }

    /**
     * Sets the next node in the list
     * @param nextNode Next node in the list
     */
    public void setNext(ListNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    /**
     * Returns previous node in the list
     * @return previous node
     */
    public ListNode<T> getLast() {
        return previousNode;
    }

    /**
     * sets previous node
     * @param previousNode previous node
     */
    public void setLast(ListNode<T> previousNode) {
        this.previousNode = previousNode;
    }

}
