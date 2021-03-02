/**
 * RedBlackTreeNode
 *
 * @author An Yuhang
 * @version 1.0
 * @date 2021/2/19 11:37
 */

public class RedBlackTreeNode {
    private final boolean RED = false;
    private final boolean BLACK = true;
    private int key;
    private boolean color;
    private RedBlackTreeNode left;
    private RedBlackTreeNode right;
    private RedBlackTreeNode parent;

    RedBlackTreeNode(){};
    RedBlackTreeNode(int val){
        this.key = val;
    }
    RedBlackTreeNode(int key, RedBlackTreeNode left, RedBlackTreeNode right, RedBlackTreeNode parent, boolean color){
        this.key = key;
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.color = color;
    }

    public boolean getColor(){
        return color;
    }

    public int getKey() {
        return key;
    }

    public RedBlackTreeNode getLeft() {
        return left;
    }

    public RedBlackTreeNode getRight() {
        return right;
    }

    public RedBlackTreeNode getParent() {
        return parent;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setLeft(RedBlackTreeNode left) {
        this.left = left;
    }

    public void setParent(RedBlackTreeNode parent) {
        this.parent = parent;
    }

    public void setRight(RedBlackTreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "RedBlackTreeNode{" +
                ",key=" + key +
                ", color=" + color +
                '}';
    }
}
