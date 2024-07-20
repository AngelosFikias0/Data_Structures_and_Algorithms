//Class for binary search tree node
public class BSTNode {
    int value;       // Data value of the BSTNode
    BSTNode left;    // Reference to the left child BSTNode
    BSTNode right;   // Reference to the right child BSTNode

    // Constructor to initialize a BSTNode with a value
    public BSTNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
