/**
 * Binary Search Tree: basic operations.
 *
 * @author An Yuhang
 * @version 1.0
 * @date 2021 /2/19 11:23
 */
public class BinarySearchTree {

    /**
     * Is valid bst boolean.
     *
     * @param node  the node
     * @param lower the lower
     * @param upper the upper
     * @return the boolean
     */
    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

    /**
     * Insert into bst tree node.
     *
     * @param root the root
     * @param val  the val
     * @return the tree node
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode y = null;
        TreeNode x = root;
        while( x != null){
            y = x;
            if (val < x.val){
                x = x.left;
            }
            else{
                x = x.right;
            }
        }
        if (y == null){
            root = new TreeNode(val);
        }
        else if (val < y.val){
            y.left = new TreeNode(val);
        }
        else{
            y.right = new TreeNode(val);
        }
        return root;
    }

    /**
     * Delete node tree node by changing vals of nodes rather than linking.
     *
     * @param root the root
     * @param key  the key
     * @return the tree node
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            // 待删除节点在左子树中
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.val) {
            // 待删除节点在右子树中
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            // key == root.val，root 为待删除节点
            if (root.left == null) {
                // 返回右子树作为新的根
                return root.right;
            } else if (root.right == null) {
                // 返回左子树作为新的根
                return root.left;
            } else {
                // 左右子树都存在，返回后继节点（右子树最左叶子）作为新的根
                TreeNode successor = min(root.right);
                successor.right = deleteMin(root.right);
                successor.left = root.left;
                return successor;
            }
        }
    }

    private TreeNode min(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    private TreeNode deleteMin(TreeNode node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }
}
