package algorithm.offer;

/**
 * @author admin
 * @date 2020/2/23 14:11
 */
public class DelListNode {


    public ListNode head = new ListNode(-1);
    public ListNode temp;

    static class ListNode {
        public int data;
        public ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    /**
     * 添加节点
     *
     * @param node
     */
    public void addNode(ListNode node) {
        temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    /**
     * 返回链表的长度
     *
     * @return
     */
    public int getLength() {
        temp = head;
        int length = 0;
        while (temp.next != null) {
            ++length;
            temp = temp.next;
        }
        return length;
    }

    public void deleteNode(ListNode node) {
        temp = head.next;
        if (node.next != null) {
            //删除的不是尾节点
            while (temp != null) {
                if (temp.data == node.data) {
                    temp.data = temp.next.data;
                    temp.next = temp.next.next;
                    return;
                }
                temp = temp.next;
            }
        } else if (node == head) {
            //删除头结点
            head = null;
        } else {
            //删除尾节点
            while (temp != null) {
                if (temp.next.data == node.data) {
                    temp.next = null;
                    return;
                }
                temp = temp.next;
            }
        }
    }

    /**
     * 打印链表
     */
    public void printList() {
        temp = head.next;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    /**
     * 在O(n)复杂度的情况下删除节点
     *
     * @param head
     * @param delNode
     */
    public static void deleteNode_1(ListNode head, ListNode delNode) throws Exception {
        if (head == null || delNode == null) {
            throw new Exception("链表为空，无法删除！");
        }
        if (head == delNode) {
            ListNode next = delNode.next;
            delNode.data = next.data;
            delNode.next = next.next;
            return;
        }
        for (ListNode node = head; node != null; node = node.next) {
            if (node.data == delNode.data) {
                node.next = delNode.next;
                break;
            }
        }
        showLink(head);
    }

    public static void deleteNode_2(ListNode head, ListNode delNode) {
        if (head == null || delNode == null) {
            return;
        }

        //删除的节点是非尾节点
        if (delNode.next != null) {
            ListNode node = delNode.next;
            delNode.data = node.data;
            delNode.next = node.next;
        } else if (head == delNode) {
            //链表只有一个节点
            head = null;
            delNode = null;
        } else {
            //链表有多个节点，删除尾节点
            ListNode node = head;
            while (node.next.data != delNode.data) {
                node = node.next;
            }
            node.next = null;
        }

    }

    public static void showLink(ListNode head) {
        ListNode temp = head.next;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        /*ListNode head = new ListNode();
        ListNode temp = head;
        for (int i = 1; i <= 10; i++) {
            ListNode node = new ListNode();
            node.data = i;
            temp.next = node;
            temp = node;
        }
        System.out.println("删除之前");
        showLink(head);

        ListNode node = new ListNode();
        node.data = 7;
        deleteNode_2(head,node);
        showLink(head);*/

        DelListNode demo = new DelListNode();
        for (int i = 1; i < 6; i++) {
            demo.addNode(new ListNode(i));
        }
        demo.printList();
        System.out.println("---链表长度：" + demo.getLength());
        demo.deleteNode(new ListNode(5));
        System.out.println("\n删除之后");
        demo.printList();
        System.out.println("---链表长度：" + demo.getLength());


    }


}
