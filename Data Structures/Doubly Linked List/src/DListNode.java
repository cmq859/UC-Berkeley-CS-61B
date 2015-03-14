public class DListNode {
    DListNode next;
    DListNode prev;
    Object key;

    public DListNode(Object o) {
        this (o, null, null);
    }

    public DListNode(Object o, DListNode p, DListNode n) {
        key = o;
        p = prev;
        n = next;
    }

    public void setPrev(DListNode node) {
        prev = node;
    }

    public void setNext(DListNode node) {
        next = node;
    }

    public DListNode getPrev() {
        return prev;
    }

    public DListNode getNext() {
        return next;
    }

    public Object getKey() {
        return key;
    }
}
