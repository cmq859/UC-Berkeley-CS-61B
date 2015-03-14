package list;

/**
 * Created by IntelliJ IDEA.
 * User: Lawrence
 * Date: 3/9/2015
 * Time: 3:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class LockDList extends DList {
    public void lockNode(DListNode node) {
        if (!(node instanceof LockDListNode)) {
            return;
        }
        LockDListNode lockDListNode = (LockDListNode) node;
        lockDListNode.setLocked();
    }

    @Override
    public void remove(DListNode node) {
        if (node instanceof LockDListNode) {
            LockDListNode node1 = (LockDListNode) node;
            if (node1.isLocked()) {
                return;
            }
        }
        super.remove(node);
    }
}
