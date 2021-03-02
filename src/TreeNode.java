import sun.reflect.generics.tree.Tree;

/**
 * the Treenode without p.
 *
 * @author An Yuhang
 * @version 1.0
 * @date 2021/2/19 11:27
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
