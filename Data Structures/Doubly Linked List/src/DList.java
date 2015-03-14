public class DList {
    private DListNode head;
    private DListNode tail;
    private int size;

    public DList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void insertFront(DListNode node) {
        node.setNext(head);
        head.setPrev(node);
        head = node;
        size++;
    }

    public void insertEnd(DListNode node) {
        node.setPrev(tail);
        tail.setNext(node);
        tail = node;
        size++;
    }

    public void add(DListNode node) {
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            node.setPrev(tail);
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    public Object get(int index) {
        DListNode current;
        if (size - index >= size / 2) {
            current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            return current.getKey();
        } else {
            current = tail;
            for (int i = size; i > index; i--) {
                current = current.getPrev();
            }
            return current.getKey();
        }
    }

    public void remove(int index) {
        DListNode current = head;
        for(int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
        current.setNext(null);
        current.setPrev(null);
    }

    public String printList() {
        DListNode current = head;
        String output = "";
        while (current != null) {
            output += "[" + current.getKey() + "]";
            current = current.getNext();
        }
        return output;
    }
}
