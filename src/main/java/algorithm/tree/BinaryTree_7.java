package algorithm.tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author admin
 * @date 2019/8/23 15:04
 */
public class BinaryTree_7 {

    //判断是否是一个完全二叉树
    public static boolean isComplate(BiTree T) {
        Queue<BiTree> queue = new LinkedBlockingQueue<>();
        if (T == null) {
            return true;
        }
        queue.offer(T);
        while (!queue.isEmpty()) {
            BiTree tree = queue.poll();
            System.out.println(tree.data);
            if (tree != null) {
                if (tree.getLeft() != null)
                    ((LinkedBlockingQueue<BiTree>) queue).offer(tree.getLeft());
                if (tree.getRight() != null)
                    ((LinkedBlockingQueue<BiTree>) queue).offer(tree.getRight());
            } else {
                while (!queue.isEmpty()) {//判断该节点后面是否有其它节点
                    BiTree tree1 = queue.poll();
                    if (tree1 != null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BiTree root = BiTree.construct();
        System.out.println(isComplate(root));

    }

}
