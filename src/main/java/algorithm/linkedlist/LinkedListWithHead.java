package algorithm.linkedlist;

import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author admin
 * @date 2019/8/24 19:30
 */
public class LinkedListWithHead {


    class Node {
        protected Object data;
        protected Node next = null;

        public Node() {
            data = null;
        }

        public Node(Object data) {
            this.data = data;
        }
    }

    public Node head = new Node();
    public Node tail = null;

    /**
     * 头插法建立单链表
     *
     * @param objects
     */
    public void createListHead(Object[] objects) {
        head = null;
        for (Object object : objects) {
            Node node = new Node(object);
            if (head == null) {
                head = node;
                continue;
            }
            node.next = head;
            head = node;
        }
    }

    /**
     * 添加节点到单链表尾部
     *
     * @param node
     */
    public void addNodeTail(Node node) {
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        tail = node;
    }

    /**
     * 尾插法创建单链表
     *
     * @param objects
     */
    public Node createListTail(Object[] objects) {
        head = null;
        for (Object object : objects) {
            Node node = new Node(object);
            if (head == null) {
                head = node;
                tail = node;
                continue;
            }
            tail.next = node;
            tail = node;
        }
        return head;
    }

    /**
     * 打印单链表
     */
    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    /**
     * 找到并删除单链表的最小值
     */
    public void deleteMin() {
        Node pre = head, p = pre.next;
        Node minpre = head, minp = minpre.next;
        while (p != null) {
            if ((Integer) p.data < (Integer) minp.data) {
                minp = p;
                minpre = pre;
            }
            pre = p;
            p = p.next;
        }
        System.out.println("最小值的节点是：" + minp.data);
        minpre.next = minp.next;
    }

    /**
     * 单链表排序
     */
    public void sortLink() {
        Node curNode = head;
        while (curNode != null) {
            Node nextNode = curNode.next;
            while (nextNode != null) {
                if ((Integer) nextNode.data < (Integer) curNode.data) {
                    int tmp = (Integer) curNode.data;
                    curNode.data = nextNode.data;
                    nextNode.data = tmp;
                }
                nextNode = nextNode.next;
            }
            curNode = curNode.next;
        }
    }

    /**
     * 获取单链表的长度
     *
     * @return
     */
    public int queryLength() {
        int len = 0;
        Node p = head;
        while (p != null) {
            ++len;
            p = p.next;
        }
        return len;
    }

    /**
     * 去掉重复元素
     */
    public void deleteSameNode() {
        Node temp = head;
        Node pre = null;
        Map<Integer, Object> map = new ConcurrentHashMap<>();
        while (temp != null) {
            if (map.containsKey(temp.data)) {
                pre.next = temp.next;
            } else {
                map.put((Integer) temp.data, 1);
                pre = temp;
            }
            temp = temp.next;
        }
    }

    /**
     * 以O(1)的时间复杂度删除指定节点
     * 1.如果不是尾部节点，把要删除的节点的下一个节点的值赋给该节点，然后让当前节点指向下一个节点
     * 2.如果是尾部节点：若只有一个元素，则直接删除；遍历找到尾节点的前一个节点，让它指向NULL
     *
     * @param node
     */
    public void delete(Node node) {
        if (head == null || node == null) return;
        if (node.next != null) {
            Node nextNode = node.next;
            node.data = nextNode.data;
            node.next = nextNode.next;
        } else {
            Node temp = head;
            if (queryLength() > 1) {
                while (temp != null && temp.next.next != null) {
                    temp = temp.next;
                }
                temp.next = null;
            } else {//只有一个节点
                head = null;
            }
        }
    }

    /**
     * 查询倒数第k个节点
     *
     * @param k
     */
    public void findNode(int k) {
        if (k > queryLength()) {
            System.out.println("大于单链表长度");
            return;
        }
        Node p = head;
        Node q = head;
        int index = 0;
        while (p != null) {
            if (index < k) {
                ++index;
            } else q = q.next;
            p = p.next;
        }
        System.out.println("倒数第" + k + "个节点是:" + q.data);
    }

    /**
     * 反转链表
     */
    public void reverse(Node L) {
        Node curNode = L;
        Node preNode = null;
        while (curNode != null) {
            Node nextNode = curNode.next;//保存当前节点的下个节点
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        head = preNode;
    }

    /**
     * 反向输出链表
     * 方法1：逆置链表
     * 方法2：借助栈
     * 方法3：利用递归
     */
    public void reversePrintByStack() {
        Stack<Node> stack = new Stack<>();
        Node temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.data + " ");
        }
        System.out.println();
    }

    public void reversePringByRecur(Node node) {
        if (node != null) {
            reversePringByRecur(node.next);
            System.out.print(node.data + " ");
        }
    }

    /**
     * 寻找链表的中间节点
     */
    public void findMidNode() {
        Node quick = head;
        Node slow = head;
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        System.out.println("中间节点是:" + slow.data);
    }

    /**
     * 合并两个有序链表，使结果链表单调有序
     *
     * @param L1
     * @param L2
     */
    public void mergeSortedList(Node L1, Node L2) {


    }

    /**
     * 合并两个任意排序的链表，使结果链表单调有序
     *
     * @param L1
     * @param L2
     * @return
     */
    public void mergeList(Node L1, Node L2) {
        head = null;
        Node p = L1, q = L2;
        while (p != null && q != null) {
            if ((Integer) p.data < (Integer) q.data) {
                addNodeTail(p);
                p = p.next;
            } else {
                addNodeTail(q);
                q = q.next;
            }
        }
        while (p != null) {
            addNodeTail(p);
            p = p.next;
        }
        while (q != null) {
            addNodeTail(q);
            q = q.next;
        }
        System.out.println("合并结果:");
        printList(head);
    }

    /**
     * 递归：合并两个任意排序的链表，使结果链表单调有序
     *
     * @param L1
     * @param L2
     * @return
     */
    public Node mergeListByRecursive(Node L1, Node L2) {
        if (L1 == null) {
            return L2;
        }
        if (L2 == null) {
            return L1;
        }
        Node p = L1, q = L2;
        Node newHead = null;
        if ((Integer) p.data < (Integer) q.data) {
            newHead = L1;
            newHead.next = mergeListByRecursive(L1.next, L2);
        } else {
            newHead = L2;
            newHead.next = mergeListByRecursive(L1, L2.next);
        }
        return newHead;
    }

    public static void main(String[] args) {
        LinkedListWithHead test = new LinkedListWithHead();
        Integer[] array1 = {32, 45, 73};//{32,45,12,17,84,15,30,73,39,56};
        Node L1 = test.createListTail(array1);
        System.out.println("L1:");
        test.printList(L1);

        Integer[] array2 = {11, 60, 93};//{13,65,11,60,37,74,93,89,75,25};
        Node L2 = test.createListTail(array2);
        System.out.println("L2:");
        test.printList(L2);

        //test.mergeList(L1,L2);
        test.head = null;
        Node mergeResult = test.mergeListByRecursive(L1, L2);
        test.printList(mergeResult);

        test.reverse(mergeResult);
        test.printList(test.head);

    }

}
