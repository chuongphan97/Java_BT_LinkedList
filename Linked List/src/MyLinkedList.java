public class MyLinkedList {
    private Node head;
    private int numNodes;

    public MyLinkedList(Object data){
        head = new Node(data);
    }

    private class Node{
        private Node next;
        private Object data;

        public Node(Object data){
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public void add(int index, Object o){
        Node temp = head;
        Node holder;

        for (int i=0; i<index-1 && temp.next != null; i++){
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(o);
        temp.next.next = holder;
        numNodes++;
    }
    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public void addFirst(Object o){
        Node temp = head;
        Node insertNode = new Node(o);
        head = insertNode;
        head.next = temp;
        numNodes++;
    }
    public void addLast(Object o){
        Node temp = head;
        Node insertNode = new Node(o);
        for (int i = 0; i < numNodes-1; i++) {
            temp = temp.next;
        }
        temp.next = insertNode;
        insertNode.next = null;
        numNodes++;
    }

    public void remove(int index){
        Node temp = head;
        Node delNode;
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        delNode = temp.next;
        holder = delNode.next;
        temp.next = holder;
        delNode = null;
        numNodes--;
    }

    public void removeObj(Object o){
        Node temp = head;
        Node del = new Node(o);
        Node holder;
        Node delNode;
        
        while (temp.next != null){
            if (head.data == del.data){
                head = temp.next;
            } else if (temp.next.data == del.data) {
                delNode = temp.next;
                holder = delNode.next;
                temp.next = holder;
                delNode = null;
            }   else temp = temp.next;
        }
        
        numNodes--;
    }

    public boolean contains(Object o){
        Node temp = head;

        while (temp.next != null) {
            if (temp.data == o) return true;
            temp = temp.next;
        }
        return false;
    }

    public MyLinkedList clone(){
        MyLinkedList llClone = new MyLinkedList(this.head);
        Node temp = head;
        llClone.head.data = head.data;


        while (temp != null){
            llClone.addLast(temp.data);
            temp = temp.next;

        }
        return llClone;
    }

    public int indexOf(Object o){
        Node temp = head;
        int i=0;
        while (temp != null){
            if (temp.data == o) return i;
            i++;
        }
        return -1;
    }

    public Object get(int index){
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp =  temp.next;
        }
        return temp.data;
    }

    public Object getFirst(){
        return head.data;
    }

    public Object getLast(){
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public void clear(){
        Node temp = head;
        Node holder;
        while (temp != null){
            holder = temp;
            head = temp.next;
            holder = null;
            temp = head;
        }
    }
}
