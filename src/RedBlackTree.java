/**
 * Red Black Tree: basic operations.
 *
 * @author An Yuhang
 * @version 1.0
 * @date 2021 /2/19 11:35
 */
public class RedBlackTree {
    private final boolean RED = false;
    private final boolean BLACK = true;
    /**
     * The Nil.
     */
    RedBlackTreeNode nil = new RedBlackTreeNode(0, null, null, null, BLACK);
    /**
     * The Root.
     */
    RedBlackTreeNode root;

    /**
     * Insert a RBTreeNode whose key is key.
     *
     * @param key the key
     */
    public void insert(int key){
        RedBlackTreeNode z = new RedBlackTreeNode(key);
        RedBlackTreeNode y = nil;
        RedBlackTreeNode x = root;
        while(x != nil){
            y = x;
            if (z.getKey() < x.getKey()){
                x = x.getLeft();
            }
            else{
                x = x.getRight();
            }
        }
        z.setParent(y);
        if (y == nil){
            root = z;
        }
        else if(z.getKey() < y.getKey()){
            y.setLeft(z);
        }
        else{
            y.setRight(z);
        }
        z.setLeft(nil);
        z.setRight(nil);
        z.setColor(RED);
        insertFixUp(z);
    }

    /**
     * Fix up the RBTree after inserting.
     * 3 cases using different fixing methods.
     *
     * @param z the inserted RBTreeNode.
     */
    private void insertFixUp(RedBlackTreeNode z){
        while(z.getParent().getColor() == RED){
            if (z.getParent() == z.getParent().getParent().getLeft()){
                //z.p is the leftchild of its parent.
                RedBlackTreeNode y = z.getParent().getParent().getRight();
                if (y.getColor() == RED){
                    // case 1, uncle_node y of z is RED, change the color
                    z.getParent().setColor(BLACK);
                    y.setColor(BLACK);
                    z.getParent().getParent().setColor(RED);
                    z = z.getParent().getParent();
                }
                else if (z == z.getParent().getRight()){
                    // case 2
                    z = z.getParent();
                    leftRotate(z);
                }
                // case 3
                z.getParent().setColor(BLACK);
                z.getParent().getParent().setColor(RED);
                rightRotate(z.getParent().getParent());
            }
            else{
                //z.p is the rightchild of its parent.
                RedBlackTreeNode y = z.getParent().getParent().getLeft();
                if (y.getColor() == RED){
                    z.getParent().setColor(BLACK);
                    y.setColor(BLACK);
                    z.getParent().getParent().setColor(RED);
                    z = z.getParent().getParent();
                }
                else if (z == z.getParent().getLeft()){
                    z = z.getParent();
                    rightRotate(z);
                }
                z.getParent().setColor(BLACK);
                z.getParent().getParent().setColor(RED);
                leftRotate(z.getParent().getParent());
            }
        }
    }

    private void leftRotate(RedBlackTreeNode x){
        RedBlackTreeNode y = x.getRight();
        RedBlackTreeNode p = x.getParent();
        x.setRight(y.getLeft());
        if (y.getLeft() != nil){
            y.getLeft().setParent(x);
        }
        y.setParent(p);
        if (p == nil){
            root = y;
        }
        else if (x == p.getLeft()){
            p.setLeft(y);
        }
        else{
            p.setRight(y);
        }
        y.setLeft(x);
        x.setParent(y);
    }

    private void rightRotate(RedBlackTreeNode y){
        RedBlackTreeNode x = y.getLeft();
        RedBlackTreeNode p = y.getParent();
        y.setLeft(x.getRight());
        if (x.getRight() != nil){
            x.getRight().setParent(y);
        }
        x.setParent(p);
        if (p == nil){
            root = x;
        }
        else if (y == p.getLeft()){
            p.setLeft(x);
        }
        else{
            p.setRight(x);
        }
        x.setRight(y);
        y.setParent(x);
    }

    public static void main(String[] args) {
        int [] array = {2,5,2,1,2};
        RedBlackTree tree = new RedBlackTree();
        RedBlackTreeNode root = tree.root;

    }

}
