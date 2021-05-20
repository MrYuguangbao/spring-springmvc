package algorithm.tree;

import lombok.Data;

import java.util.BitSet;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author admin
 * @date 2019/8/23 15:05
 */
@Data
public class BiTree {
    public Object data;
    public BiTree left;
    public BiTree right;

    public BiTree(BiTree left, Object data, BiTree right) {
        this.left = left;
        this.data = data;
        this.right = right;
    }

    public static BiTree construct() {
        BiTree e = new BiTree(null, "E", null);
        BiTree h = new BiTree(null, "H", null);
        BiTree f = new BiTree(h, "F", null);
        BiTree b = new BiTree(e, "B", f);
        BiTree g = new BiTree(null, "G", null);
        BiTree c = new BiTree(g, "C", null);
        BiTree root = new BiTree(b, "A", c);
        return root;
    }

    public static BiTree construct1() {
        BiTree e = new BiTree(null, 7, null);
        BiTree f = new BiTree(null, 8, null);
        BiTree b = new BiTree(e, 15, f);
        BiTree g = new BiTree(null, 10, null);
        BiTree c = new BiTree(g, 14, null);
        BiTree root = new BiTree(b, 1, c);
        return root;
    }

    /**
     * 先序遍历
     *
     * @param T
     */
    public void preOrder(BiTree T) {
        if (T != null) {
            System.out.print(T.data + " ");
            preOrder(T.left);
            preOrder(T.right);
        }
    }

    /**
     * 中序遍历
     *
     * @param T
     */
    public void inOrder(BiTree T) {
        if (T != null) {
            inOrder(T.left);
            System.out.print(T.data + " ");
            inOrder(T.right);
        }
    }

    /**
     * 中序遍历非递归实现
     *
     * @param T
     */
    public void inOrderByRecursive(BiTree T) {
        Stack<BiTree> stack = new Stack<>();
        BiTree tree = T;
        while (tree != null || !stack.isEmpty()) {
            if (tree != null) {
                stack.push(tree);
                tree = tree.left;
            } else {
                BiTree statckTop = stack.pop();
                System.out.print(statckTop.data + " ");
                tree = statckTop.right;
            }
        }
    }

    /**
     * 后序遍历
     *
     * @param T
     */
    public void postOrder(BiTree T) {
        if (T != null) {
            postOrder(T.left);
            postOrder(T.right);
            System.out.print(T.data + " ");
        }
    }

    /**
     * 后序遍历非递归实现
     * r辅助变量，指向当前节点的上一个访问过的节点
     *
     * @param T
     */
    public void postOrderByRecursive(BiTree T) {
        Stack<BiTree> stack = new Stack<>();
        BiTree p = T;
        BiTree r = null;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.peek();
                if (p.right != null && p.right != r) {//如果右子树不为空且没有被访问过
                    p = p.right;
                    stack.push(p);
                    p = p.left;
                } else {
                    p = stack.pop();
                    System.out.print(p.data + " ");
                    r = p;
                    p = null;
                }
            }
        }
    }

    /**
     * 层次遍历-从上到下、从左至右
     *
     * @param T
     */
    public void levelOrder(BiTree T) {
        Queue<BiTree> queue = new LinkedBlockingQueue<>();
        ((LinkedBlockingQueue<BiTree>) queue).offer(T);
        while (!queue.isEmpty()) {
            BiTree tree = queue.poll();
            System.out.print(tree.data + " ");
            if (tree.left != null) {
                ((LinkedBlockingQueue<BiTree>) queue).offer(tree.left);
            }
            if (tree.right != null) {
                ((LinkedBlockingQueue<BiTree>) queue).offer(tree.right);
            }
        }
    }

    /**
     * 层次遍历-从下到上、从右至左
     *
     * @param T
     */
    public void levelOrderReverse(BiTree T) {
        Queue<BiTree> queue = new LinkedBlockingQueue<>();
        Stack<BiTree> stack = new Stack<>();
        ((LinkedBlockingQueue<BiTree>) queue).offer(T);
        while (!queue.isEmpty()) {
            BiTree tree = queue.poll();
            stack.push(tree);
            if (tree.left != null) {
                ((LinkedBlockingQueue<BiTree>) queue).offer(tree.left);
            }
            if (tree.right != null) {
                ((LinkedBlockingQueue<BiTree>) queue).offer(tree.right);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().data + " ");
        }
    }

    /**
     * 递归计算树的高度
     *
     * @param T
     * @return
     */
    public int BiTreeDepth(BiTree T) {
        if (T == null) {
            return 0;
        }
        int ldep = BiTreeDepth(T.left);
        int rdep = BiTreeDepth(T.right);
        return ldep > rdep ? ldep + 1 : rdep + 1;
    }


    public static void main(String[] args) {
        BiTree test = new BiTree(null, null, null);
        System.out.print("先序遍历：");
        test.preOrder(BiTree.construct());
        System.out.print("\n中序遍历：");
        test.inOrder(BiTree.construct());
        System.out.print("\n中序遍历（非递归）：");
        test.inOrderByRecursive(BiTree.construct());
        System.out.print("\n后序遍历：");
        test.postOrder(BiTree.construct());
        System.out.print("\n后序遍历（非递归）：");
        test.postOrderByRecursive(BiTree.construct());
        System.out.print("\n层次遍历-从上到下、从左至右：");
        test.levelOrder(BiTree.construct());
        System.out.print("\n层次遍历-从下到上、从右至左：");
        test.levelOrderReverse(BiTree.construct());

        System.out.print("\n树的高度：");
        System.out.println(test.BiTreeDepth(BiTree.construct()));
    }

}
