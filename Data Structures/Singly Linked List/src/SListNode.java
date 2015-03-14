public class SListNode {
    private SListNode next;
    private Object key;

    public SListNode(Object o) {
        this(o, null);
    }

    public SListNode(Object o, SListNode s) {
        key = o;
        next = s;
    }

    public SListNode getNext() {
       return next;
    }

    public Object getKey() {
        return key;
    }

    public void setNext(SListNode s) {
        next = s;
    }

}
