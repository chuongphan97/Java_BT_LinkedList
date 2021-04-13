public class MyLinkedListTest {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList ll = new MyLinkedList(10);
        ll.addFirst(11);
        ll.addFirst(12);
        ll.addFirst(13);

        ll.printList();
        ll.removeObj(12);
        System.out.println();
        ll.printList();
        System.out.println();

        MyLinkedList cloneLL = ll.clone();
        cloneLL.printList();
        System.out.println( );
        System.out.println("Clear");
        cloneLL.clear();

        cloneLL.printList();
        System.out.println("Done");
    }
}
