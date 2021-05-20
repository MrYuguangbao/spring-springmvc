package algorithm.tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author admin
 * @date 2019/8/23 16:12
 */
public class BiTree_WPL {

    //层次遍历
    public static Object calWPLLevel(BiTree T) {
        Queue<BiTree> queue = new LinkedBlockingQueue<>();
        BiTree lastNode = T;
        BiTree newLastNode = null;
        Integer wpl = 0;
        int deep = 0;
        ((LinkedBlockingQueue<BiTree>) queue).offer(T);//根节点入队
        while (!queue.isEmpty()) {
            BiTree biTree = queue.poll();
            if (biTree.left == null && biTree.right == null) {
                wpl += deep * (Integer) biTree.data;
            }
            if (biTree.left != null) {
                ((LinkedBlockingQueue<BiTree>) queue).offer(biTree.left);
                newLastNode = biTree.left;
            }
            if (biTree.right != null) {
                ((LinkedBlockingQueue<BiTree>) queue).offer(biTree.right);
                newLastNode = biTree.right;
            }
            if (biTree == lastNode) {
                lastNode = newLastNode;
                ++deep;
            }
        }
        return wpl;
    }

    private static int wpl = 0;

    public static int calWPLLevelPreSearch(BiTree T, int deep) {
        if (T.left == null && T.right == null) {
            wpl += deep * (Integer) T.data;
        } else {
            if (T.left != null) {
                wpl = calWPLLevelPreSearch(T.left, deep + 1);
            }
            if (T.right != null) {
                wpl = calWPLLevelPreSearch(T.right, deep + 1);
            }
        }
        return wpl;
    }


    public static void main(String[] args) {
        BiTree tree = BiTree.construct1();
        System.out.println("层次遍历求得的wpl:" + calWPLLevel(tree));
        System.out.println("先序遍历求得的wpl:" + calWPLLevelPreSearch(tree, 0));
    }

}
