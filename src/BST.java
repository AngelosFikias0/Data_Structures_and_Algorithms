//Class for binary search tree
public class BST {
    private BSTNode root; // Root BSTNode of the BST

    // Constructor to initialize an empty BST
    public BST() {
        this.root = null;
    }

    // Insert a value into the BST
    public void insert(int value) {
        root = insertRec(root, value);
    }

    // Recursive helper method for insertion
    private BSTNode insertRec(BSTNode node, int value) {
        if (node == null) {
            node = new BSTNode(value);
            return node;
        }
        if (value < node.value) {
            node.left = insertRec(node.left, value);
        } else if (value > node.value) {
            node.right = insertRec(node.right, value);
        }
        return node;
    }

    // Search for a value in the BST
    public boolean search(int value) {
        return searchRec(root, value);
    }

    // Recursive helper method for searching
    private boolean searchRec(BSTNode node, int value) {
        if (node == null) {
            return false;
        }
        if (value == node.value) {
            return true;
        }
        return value < node.value ? searchRec(node.left, value) : searchRec(node.right, value);
    }

    // Delete a value from the BST
    public void delete(int value) {
        root = deleteRec(root, value);
    }

    // Recursive helper method for deletion
    private BSTNode deleteRec(BSTNode root, int value) {
        if (root == null) {
            return root;
        }
        if (value < root.value) {
            root.left = deleteRec(root.left, value);
        } else if (value > root.value) {
            root.right = deleteRec(root.right, value);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.value = minValue(root.right);
            // Delete the inorder successor
            root.right = deleteRec(root.right, root.value);
        }
        return root;
    }

    // Method to find the minimum value in a BST
    private int minValue(BSTNode root) {
        int minValue = root.value;
        while (root.left != null) {
            minValue = root.left.value;
            root = root.left;
        }
        return minValue;
    }

    // In-order traversal
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(BSTNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }

    // Pre-order traversal
    public void preorder() {
        preorderRec(root);
    }

    private void preorderRec(BSTNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Post-order traversal
    public void postorder() {
        postorderRec(root);
    }

    private void postorderRec(BSTNode root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.value + " ");
        }
    }
}
