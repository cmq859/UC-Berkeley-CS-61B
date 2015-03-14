public class SList {
    private SListNode head;
    private int size;

    public SList() {
        head = null;
        size = 0;
    }

    public void insertFront(Object o) {
        head = new SListNode(o, head);
        size++;
    }

    public void add(SListNode s) {
        if (head == null) {
            head = s;
            return;
        }
        SListNode current = head;
        for (int i = 0; i < size-1; i++) {
            current = current.getNext();
        }
        current.setNext(s);
        size++;
    }

    public Object getFirst() {
        if (head != null)
            return head.getKey();
        return null;
    }

    public Object get(int index) {
        SListNode current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        return current.getKey();
    }

    public void remove(int index) {
        SListNode current = head;
        for (int i = 0; i < index - 2; i++) {
            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        current.getNext().setNext(null);
    }

    public String printList() {
        SListNode current = head;
        String output = "";
        while (current != null) {
            output += "[" + current.getKey() + "]";
            current = current.getNext();
        }
        return output;
    }

    public int getSize() {
        return size;
    }
}
