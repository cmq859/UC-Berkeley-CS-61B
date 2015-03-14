package list;

/**
 * Created by IntelliJ IDEA.
 * User: Lawrence
 * Date: 3/9/2015
 * Time: 3:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class LockDListNode extends DListNode {
    private boolean isLocked;

    /**
     * DListNode() constructor.
     *
     * @param i the item to store in the node.
     * @param p the node previous to this node.
     * @param n the node following this node.
     */
    LockDListNode(Object i, DListNode p, DListNode n) {
        super(i, p, n);
        isLocked = false;
    }

    public void setLocked() {
        if (isLocked) {
            return;
        }
        isLocked = true;
    }

    public boolean isLocked() {
        return isLocked;
    }
}
