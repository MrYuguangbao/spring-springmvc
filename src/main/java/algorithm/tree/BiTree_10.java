package algorithm.tree;

/**
 * @author admin
 * @date 2019/8/23 15:47
 */
public class BiTree_10 {
    public static int i = 1;

    public static Object preNode(BiTree T, int k) {
        if (T == null) {
            return "#";
        }
        if (i == k) {
            return T.data;
        }
        ++i;
        if (!"#".equals(preNode(T.getLeft(), k))) {
            return preNode(T.getLeft(), k);
        } else {
            return preNode(T.getRight(), k);
        }
    }

    public static void preSearch(BiTree T) {
        if (T != null) {
            System.out.print(T.data + " ");
            preSearch(T.left);
            preSearch(T.right);
        }
    }

    public static void main(String[] args) {
        BiTree root = BiTree.construct();
        System.out.println("先序遍历");
        preSearch(root);
        System.out.println();
        System.out.println(preNode(root, 4));

    }
}
