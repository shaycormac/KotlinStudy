package com.assassin.noder;

/**
 * Author:      Shay-Patrick-Cormac
 * Email:       android_shay@outlook.com
 * CreateDate:  2023/03/01 20:25
 * Version:     1.0
 * Description: 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排
 * 序的。
 * <p>
 * 二、解题思路
 * Step1.定义一个指向新链表的指针，暂且让它指向NULL;
 * Step2.比较两个链表的头结点，让较小的头结点作为新链表的头结点;
 * Step3.有两种方法。
 * 1递归比较两个链表的其余节点，让较小的节点作为上一个新节点的后一个节点;
 * 2循环比较两个链表的其余节点，让较小的节点作为上一个新节点的后一个节点。 直到有一个链表没有节点，然后将新链表的最后一个节点直接指向剩余链表的节 点。
 */
public class MergeTwoSortedNode {


    public static void main(String[] args) {

        Node node13 = new Node(8, null);
        Node node12 = new Node(5, node13);
        Node node11 = new Node(3, node12);

        Node node23 = new Node(9, null);
        Node node22 = new Node(4, node23);
        Node node21 = new Node(1, node22);

        Node mergeNode = mergeTwoNode(node11, node21);

        printNode(mergeNode);


    }

    /**
     * 2.循环比较两个链表的其余节点，让较小的节点作为上一个新节点的后一个节点。
     * 直到有一个链表没有节点，然后将新链表的最后一个节点直接指向剩余链表的节点。
     *
     * @param head1 第一个有序链表
     * @param head2 第二个有序链表
     * @return
     */
    public static Node mergeTwoNode(Node head1, Node head2) {
        // 输入的边界检查
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }
        // 记录两个链表中头部较小的结点
        Node tmp = head1;
        // 如果第一个链表的头结点小，就递归处理第一个链表的下一个结点 和第二个链表的头结点
        if (tmp.value < head2.value) {
            tmp.next = mergeTwoNode(head1.next, head2);
        } else {
            // 如果第二个链表的头结点小，就递归处理第一个链表的头结点和第二个链表的头结点的下一个结点
            tmp = head2;
            tmp.next = mergeTwoNode(head1, head2.next);
        }
// 返回处理结果
        return tmp;
    }


    private static class Node {
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        int value;
        Node next;

        @Override
        public String toString() {
            return "Node{" + "value=" + value + ", next=" + next + '}';
        }
    }

    public static void printNode(Node node) {
        while (node != null) {
            System.out.println(node);
            node = node.next;
        }
    }
}
