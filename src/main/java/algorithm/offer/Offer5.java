package algorithm.offer;

import algorithm.graph.Prim;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author admin
 * @date 2020/2/18 17:10
 */
public class Offer5 {

    public static Node head = null;

    /**
     * 定义链表的节点
     */
    static class Node {
        Node next = null;
        int data;

        Node(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }


    public void addNode(Node node) {
        if (head == null) {
            head = node;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void showLink(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    /**
     * 反转链表
     */
    public Node reverseLink() {
        if (head == null || head.getNext() == null) {
            return head;

        }
        Node pre = null;
        Node cur = head;
        Node tempNext = null;
        while (cur != null) {
            tempNext = cur.next;
            cur.setNext(pre);
            pre = cur;
            cur = tempNext;
        }
        return pre;
    }

    /**
     * 逆向输出链表
     *
     * @param node
     * @return
     */
    public ArrayList<Integer> reverseDisplay(Node node) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Node temp = node;
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            result.add(pop);
        }
        return result;
    }

    public static void main(String[] args) {
        Offer5 offer5 = new Offer5();
        for (int i = 0; i < 6; i++) {
            offer5.addNode(new Node(i + 1));
        }
        offer5.showLink(head);
        System.out.println();
        Node node = offer5.reverseLink();
        offer5.showLink(node);

    }


}
