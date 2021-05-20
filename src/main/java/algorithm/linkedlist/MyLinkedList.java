package algorithm.linkedlist;

import lombok.Data;

/**
 * @author admin
 * @date 2019/8/24 10:59
 */
@Data
public class MyLinkedList {

    class Node {
        Object data;
        Node next = null;

        public Node(Object data) {
            this.data = data;
        }
    }

    public Node head = null;
    public Node tail = null;

    /**
     * 尾插
     *
     * @param data
     */
    public void addTailNode(Object data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        tail = node;
    }

    /**
     * 头插
     *
     * @param data
     */
    public void addHeadNode(Object data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }

    /**
     * 构造单链表
     */
    public Node createLinkedList(Object[] objects) {
        head = null;
        for (Object obj : objects) {
            addTailNode(obj);
            //addHeadNode(aChar);
        }
        return head;
    }

    public void showReverse(Node head) {
        if (head.next != null) {
            showReverse(head.next);
        }
        System.out.print(head.data + " ");
    }

    public void show(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * 删除链表中所有值为data的节点
     *
     * @param head
     * @param data
     */
    public void delete(Node head, Object data) {
        Node pre = head;
        while (head != null) {
            if (head.data.equals(data)) {
                pre.next = head.next;
            } else {
                pre = head;
            }
            head = head.next;
        }
    }

    public int length(Node head) {
        int count = 0;
        while (head != null) {
            ++count;
            head = head.next;
        }
        return count;
    }

    public Node findCommonSuffix(Node p, Node q) {
        int m = length(p);
        int n = length(q);
        for (; m >= n; m--) {
            p = p.next;
        }
        for (; m < n; m++) {
            q = q.next;
        }
        while (p.next != null && p.next != q.next) {
            p = p.next;
            q = q.next;
        }
        return p;
    }

    /**
     * 删除链表中最小值的节点
     *
     * @param head
     */
    public void deleteMin(Node head) {
        Node p = head;
        Node pre = head;
        Node minpre = head;
        Node minp = head;
        while (p != null) {
            if ((Integer) p.data < (Integer) minp.data) {
                minp = p;
                minpre = pre;
            }
            pre = p;
            p = p.next;
        }
        System.out.println("最小值是：" + minp.data);
        minpre.next = minp.next;
    }

    public Node constrLinkedList(Object[] objects) {
        for (Object object : objects) {
            Node node = new Node(object);
            if (head == null) {
                head = node;
                tail = node;
            }
            tail.next = node;
            tail = node;
        }
        tail.next = null;
        return head;
    }

    /**
     * 逆置单链表
     */
    public void reverseList() {
        Node pre, p = head, r = p.next;
        //p.next = null;
        while (r != null) {
            pre = p;
            p = r;
            r = r.next;
            p.next = pre;
        }
        head = p;
    }

    /**
     * 使单链表递增有序
     */
    public void sortASC(Node head) {
        Node p = head;
        Node pre;
        Node r = p;
        while (p != null) {
            r = p.next;
            pre = head;
            while (pre != null && (Integer) pre.data > (Integer) p.data) {
                pre = pre.next;
            }
            p.next = pre.next;
            pre.next = p;
            p = r;
        }
    }


    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        Character[] chars = {'l','o','d','b','w','g'};
        Node p = linkedList.createLinkedList(chars);
        linkedList.show(p);

        /*Character[] chars1 = {'b','e','k','z','e','d','i','n','v'};
        Node q = linkedList.createLinkedList(chars1);
        linkedList.show(q);

        System.out.println("删除节点");
        linkedList.delete(q,'e');
        linkedList.show(q);
        System.out.println("反向输出");
        linkedList.showReverse(q);*/

        /*Integer[] a = {32, 45, 12, 17, 84, 39, 73, 56};
        Node root = linkedList.constrLinkedList(a);
        linkedList.deleteMin(linkedList.head);
        System.out.println("删除之后");
        linkedList.show(linkedList.head);*/

        linkedList.show(linkedList.head);
        System.out.println("逆置链表");
        linkedList.reverseList();
        linkedList.show(linkedList.head);

        /*Node r = linkedList.createLinkedList(a);
        linkedList.show(r);
        linkedList.deleteMin(r);
        linkedList.show(r);
        linkedList.reverseList(r);
        linkedList.show(r);*/


    }

}
