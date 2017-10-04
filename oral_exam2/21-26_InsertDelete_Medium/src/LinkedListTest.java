/**
 * This is an example of the linked list class running.
 * The main method runs through various possiblities.
 * @author Sophia Mallaro
 * @see LinkedListTest
 * */
public class LinkedListTest {
    public static void main(String[] args) {
        List<Integer> myList = new List<Integer>("List");

        System.out.println("Add one, two and three to the linked list, adding each number at the back");
        myList.insertAtFront(1);
        myList.insertAtBack(2);
        myList.insertAtBack(3);
        myList.print();
        System.out.println("Add 4 before 3");
        myList.insertBefore(4,3);
        myList.print();
        System.out.println("Remove 2 and 4");
        myList.remove(2);
        myList.remove(4);
        myList.print();
        System.out.println("Add 2,5,6 in the middle");
        myList.insertAfter(2,1);
        myList.insertAfter(5,2);
        myList.insertAfter(6,5);
        myList.print();
        System.out.println("Remove the second element");
        myList.removePosition(2);
        myList.print();


    }
}
