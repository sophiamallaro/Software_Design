/**
 * This class represents a node in the linked list.
 * NOTE: This class is a modified version of the class
 * in Deitel and Deitel's Java How To Program Early Objects, 10th Edition
 * @author Sophia Mallaro
 * @see List
 */
public class List<T> {
    private ListNode<T> firstNode;
    private ListNode<T> lastNode;
    private String name;

    /**
     * Creates a list with the name "list"
     */
    public List() {
        this("list");
    }

    /**
     * Creates a new, empty list
     * @param name Name of list
     */
    public List(String name) {
        this.name = name;
        firstNode = lastNode = null;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

    /**
     * Inserts an item at the begining of the list
     * @param insertItem Data of element to be inserted
     */
    public void insertAtFront(T insertItem) {
        if(isEmpty()) {
            firstNode = lastNode = new ListNode<T>(insertItem);
        }
        else {
            ListNode<T> toAdd = new ListNode<T>(insertItem);
            toAdd.nextNode = firstNode;
            firstNode = toAdd;
        }
    }

    /**
     * Removes front element from the lsit
     * @return data of element that has been removed
     */
    public T removeFromFront() {
        if(isEmpty()) {
            throw new EmptyListException();
        }
        else {
            T temp = firstNode.data;
            if(firstNode.nextNode != null) {
                firstNode = firstNode.nextNode;
                firstNode.previousNode = null;
            }
            else {
                firstNode = null;
            }
            return temp;
        }
    }

    /**
     * Inserts an item at the back of the list
     * @param insertItem Element to be inserted
     */
    public void insertAtBack(T insertItem) {
        if(isEmpty()) {
            firstNode = lastNode = new ListNode<T>(insertItem);
        }
        else {
            ListNode<T> toAdd = new ListNode<T>(insertItem);
            toAdd.previousNode = lastNode;
            lastNode.nextNode = toAdd;
            lastNode = toAdd;
        }
    }

    /**
     * Removes the last item in the list
     * @return Data of last element
     */
    public T removeFromBack() {
        if(isEmpty()) {
            throw new EmptyListException(name);
        }
        else {
            T temp = lastNode.data;
            if(lastNode.previousNode != null) {
                lastNode = lastNode.previousNode;
                lastNode.nextNode = null;
            }
            else {
                firstNode = lastNode = null;
            }
            return temp;
        }
    }

    /**
     * This method adds a new element after a given element
     * @param insertItem Data of element to be added
     * @param after Data of node the element should be inserted after
     */
    public void insertAfter(T insertItem, T after) {
        boolean found = false;
        if(isEmpty()) {
            throw new EmptyListException(name);
        }
        else {
            ListNode<T> toAdd = new ListNode<T>(insertItem);
            ListNode<T> current = firstNode;
            while(current != null && !found) {
                if(current.data == after) {
                    toAdd.nextNode = current.nextNode;
                    current.nextNode = toAdd;
                    toAdd.nextNode.previousNode = toAdd;
                    toAdd.previousNode = current;
                    found = true;
                }
                else {
                    current = current.nextNode;
                }
            }
            if(found == false) {
                insertAtBack(insertItem);
            }
        }
    }

    /**
     * This element adds a new element before a given element
     * @param insertItem Item to be added
     * @param before Data of the node the new node should be created before
     */
    public void insertBefore(T insertItem, T before) {
        boolean found = false;
        if (isEmpty()) {
            throw new EmptyListException(name);
        } else {
            ListNode<T> toAdd = new ListNode<T>(insertItem);
            ListNode<T> current = firstNode;
            while (current != null && !found) {
                if (current.data == before) {
                    current.previousNode.nextNode = toAdd;
                    toAdd.previousNode = current.previousNode;
                    toAdd.nextNode = current;
                    current.previousNode = toAdd;
                    found = true;
                } else {
                    current = current.nextNode;
                }
            }
            if (found == false) {
                insertAtBack(insertItem);
            }
        }
    }

    /**
     * This element creates a new node at the given position in the list
     * @param insertItem Item to be inserted
     * @param position Position
     */
    public void insertAtPosition(T insertItem, int position) {
        int count=1;
        boolean inserted=false;
        if (isEmpty()) {
            throw new EmptyListException(name);
        } else {
            ListNode<T> toAdd = new ListNode<T>(insertItem);
            ListNode<T> current = firstNode;
            while (!inserted && current != null) {
                if(count == position ) {
                    insertBefore(insertItem, current.data);
                    inserted = true;
                }
                else {
                    current = current.nextNode;
                    count ++;
                }
            }
            if(!inserted) {
                insertAtBack(insertItem);
            }
        }
    }

    /**
     * This method removes the element containing the data given in the paramater.
     * If this node does not exist, nothing happens.
     * @param toRemove Data of the element to remove
     * @return
     */
    public T remove(T toRemove) {
        ListNode<T> current = firstNode;
        boolean found = false;
        if(isEmpty()) {
            throw new EmptyListException(name);
        } else {
            while(current != null && !found) {
                if(current.data == toRemove) {
                    if(current.nextNode != null && current.previousNode != null) {
                        current.nextNode.previousNode = current.previousNode;
                        current.previousNode.nextNode = current.nextNode;
                    }
                    else if(current.nextNode == null){
                        current.previousNode.nextNode = null;
                    }
                    else {
                        current.nextNode.previousNode = null;
                    }

                    return current.data;
                }
                else {
                    current = current.nextNode;
                }
            }
            return null;
        }
    }

    /**
     * This method removes the element in the given position of the list.
     * If that element does not exist, nothing happens.
     * @param position Position to be removed
     * @return
     */
    public T removePosition(int position) {
        int count=1;
        boolean removed=false;
        if (isEmpty()) {
            throw new EmptyListException(name);
        } else {
            ListNode<T> current = firstNode;
            while (!removed && current != null) {
                if (count == position) {
                    T toReturn = remove(current.data);
                    return toReturn;
                } else {
                    current = current.nextNode;
                    count++;
                }
            }
        }
        return null;
    }

    /**
     * This class prints the linked list
     */
    public void print() {
        ListNode<T> current = new ListNode<T>(firstNode);
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.nextNode;
        }
        System.out.print("\n");
    }
}
