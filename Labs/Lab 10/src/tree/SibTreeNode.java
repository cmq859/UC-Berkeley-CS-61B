/* SibTreeNode.java */

package tree;

/**
 *  A SibTreeNode object is a node in a SibTree (sibling-based general tree).
 *  @author Jonathan Shewchuk
 */

class SibTreeNode extends TreeNode {

    /**
     *  (inherited)  item references the item stored in this node.
     *  (inherited)  valid is true if and only if this is a valid node in some
     *               Tree.
     *  myTree references the Tree that contains this node.
     *  parent references this node's parent node.
     *  firstChild references this node's first (leftmost) child.
     *  nextSibling references this node's next sibling.
     *
     *  DO NOT CHANGE THE FOLLOWING FIELD DECLARATIONS.
     */

    /**
     *  ADT implementation invariants:
     *  1) if valid == true, myTree != null.
     *  2) if valid == true, then this is a descendent of myTree.root.
     *  3) if valid == true, myTree satisfies all the invariants of a
     *     SibTree (listed in SibTree.java).
     */

    protected SibTree myTree;
    protected SibTreeNode parent;
    protected SibTreeNode firstChild;
    protected SibTreeNode nextSibling;

    /**
     * Construct a valid SibTreeNode referring to a given item.
     */
    SibTreeNode(SibTree tree, Object item) {
        this.item = item;
        valid = true;
        myTree = tree;
        parent = null;
        firstChild = null;
        nextSibling = null;
    }

    /**
     * Construct an invalid SibTreeNode.
     */
    SibTreeNode() {
        valid = false;
    }

    /**
     *  children() returns the number of children of the node at this position.
     *  WARNING:  Does not run in constant time.  Actually counts the kids.
     */
    public int children() {
        if (isValidNode()) {
            int count = 0;
            SibTreeNode countNode = firstChild;
            while (countNode != null) {
                count++;
                countNode = countNode.nextSibling;
            }
            return count;
        } else {
            return 0;
        }
    }

    /**
     *  parent() returns the parent TreeNode of this TreeNode.  Throws an
     *  exception if `this' is not a valid node.  Returns an invalid TreeNode if
     *  this node is the root.
     */
    public TreeNode parent() throws InvalidNodeException {
        // REPLACE THE FOLLOWING LINE WITH YOUR SOLUTION TO PART I.
        if (!valid) {
            throw new InvalidNodeException("Not a valid Node");
        } else if (parent == null) {
            return new SibTreeNode();
        }
        return parent;
    }

    /**
     *  child() returns the cth child of this TreeNode.  Throws an exception if
     *  `this' is not a valid node.  Returns an invalid TreeNode if there is no
     *  cth child.
     */
    public TreeNode child(int c) throws InvalidNodeException {
        if (isValidNode()) {
            if (c < 1) {
                return new SibTreeNode();
            }
            SibTreeNode kid = firstChild;
            while ((kid != null) && (c > 1)) {
                kid = kid.nextSibling;
                c--;
            }
            if (kid == null) {
                return new SibTreeNode();
            } else {
                return kid;
            }
        } else {
            throw new InvalidNodeException();
        }
    }

    /**
     *  nextSibling() returns the next sibling TreeNode to the right from this
     *  TreeNode.  Throws an exception if `this' is not a valid node.  Returns
     *  an invalid TreeNode if there is no sibling to the right of this node.
     */
    public TreeNode nextSibling() throws InvalidNodeException {
        if (isValidNode()) {
            if (nextSibling == null) {
                return new SibTreeNode();
            } else {
                return nextSibling;
            }
        } else {
            throw new InvalidNodeException();
        }
    }

    /**
     *  insertChild() inserts an item as the cth child of this node.  Existing
     *  children numbered c or higher are shifted one place to the right
     *  to accommodate.  If the current node has fewer than c children,
     *  the new item is inserted as the last child.  If c < 1, act as if c is 1.
     *
     *  Throws an InvalidNodeException if "this" node is invalid.
     */
    public void insertChild(Object item, int c) throws InvalidNodeException {
        // FILL IN YOUR SOLUTION TO PART II HERE.
        if (!valid) {
            throw new InvalidNodeException("Not a valid Node");
        }
        if (children() == 0) {                                          //No children
            firstChild = new SibTreeNode(myTree, item);                 //Make a child node
            firstChild.parent = this;
        } else if (c <= 1) {                                            //If c <= 1, then make the node the first child
            SibTreeNode sibTreeNode = new SibTreeNode(myTree, item);
            sibTreeNode.nextSibling = firstChild;
            firstChild = sibTreeNode;
            firstChild.parent = this;
        } else if (c > children()) {                                    //If c > #of children, make the node the last
            SibTreeNode sibTreeNode = firstChild;
            while (sibTreeNode.nextSibling != null) {
                sibTreeNode = sibTreeNode.nextSibling;
            }
            SibTreeNode node = new SibTreeNode(myTree, item);
            node.parent = this;
            sibTreeNode.nextSibling = node;
        } else {
            SibTreeNode sibTreeNode = firstChild;
            int i = 1;
            while (++i < c) {                                           //Look for the correct position of the child
                sibTreeNode = sibTreeNode.nextSibling;
            }
            SibTreeNode node = new SibTreeNode(myTree, item);
            node.nextSibling = sibTreeNode.nextSibling;                 //Place that node there
            node.parent = this;
            sibTreeNode.nextSibling = node;
        }
        myTree.size++;                                                  //Increment the size
    }

    /**
     *  removeLeaf() removes the node at the current position from the tree if
     *  it is a leaf.  Does nothing if `this' has one or more children.  Throws
     *  an exception if `this' is not a valid node.  If 'this' has siblings to
     *  its right, those siblings are all shifted left by one.
     */
    public void removeLeaf() throws InvalidNodeException {
        // FILL IN YOUR SOLUTION TO PART III HERE.
        if (!valid) {
            throw new InvalidNodeException("Not a valid Node");
        }
        if (children() > 0) {                                   //If not a leaf, do nothing
            return;
        } else if (nextSibling != null) {                       //If there is a sibling
            SibTreeNode parent = (SibTreeNode) parent();        //Find the parent and set the parent's firstchild
            parent.firstChild = nextSibling;                    //To the this node's next sibling
            valid = false;                                      //Makes this node invalid
            nextSibling = null;
        } else {
            SibTreeNode parent = (SibTreeNode) parent();        //If there is no sibling
            if (!parent.isValidNode()) {                        //Check if it is a root node
                valid = false;
            } else if (parent.children() == 1) {                //If there is only one child node, remove the child
                parent.firstChild = null;
            } else {
                SibTreeNode child = parent.firstChild;          //Find the node previous to this one
                if (child.nextSibling != this) {
                    while (child != this) {
                        child = child.nextSibling;
                    }
                }
                child.nextSibling = null;                       //Set that node's next sibling to null
            }
        }
        valid = false;                                          //Makes this an invalid node
        myTree.size--;                                          //Decrement the size
    }

}
