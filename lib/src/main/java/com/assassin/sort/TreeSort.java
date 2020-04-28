package com.assassin.sort;

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2020/3/19 13:28
 * Version: 1.0
 * Description: 二叉树的基本知识
 */
public class TreeSort {

    private NodeTree root;

    //每一个节点
    static class NodeTree {
        //节点上储存的值，使用int替代，实际场景中为Object
        public int data;
        //左右叶子结点
        public NodeTree leftChild;
        public NodeTree rightChild;
        //是否已经删除（假删除）
        public boolean isDelete;

        public NodeTree(int data) {
            this.data = data;
        }
    }

    //
    public static void main(String[] args) {
        TreeSort binaryTree = new TreeSort();

        NodeTree first = binaryTree.insert(null, 1);
        NodeTree second = binaryTree.insert(first, 2);
        NodeTree three = binaryTree.insert(second, 3);
        NodeTree fourth = binaryTree.insert(three, 4);
        NodeTree fifth = binaryTree.insert(fourth, 5);
        NodeTree six = binaryTree.insert(fifth, 6);
        binaryTree.preOrder(six);

    }


    public boolean insertNode(int value) {
        NodeTree newNode = new NodeTree(value);
        //根节点没有的话，当作根节点。
        if (root == null) {
            root = newNode;
            return true;
        }

        //从根节点开始遍历，用一个临时变量来储存正在处理的节点
        NodeTree currentNode = root;
        //这个是每次遍历的时候，先把根节点临时储存起来，到后面要挂在这个节点上
        NodeTree parentNode = null;
        //死循环
        while (true) {
            //先储存起来
            parentNode = currentNode;
            //当前的临时节点大于要插入的节点，往左子树去遍历
            if (currentNode.data > value) {
                //临时的这个节点下方到左叶子节点
                currentNode = currentNode.leftChild;
                //左叶子结点是空的话，把newNode挂到父节点上
                if (currentNode == null) {
                    parentNode.leftChild = newNode;
                    //插入成功
                    return true;
                }

            } else {
                currentNode = currentNode.rightChild;
                if (currentNode == null) {
                    parentNode.rightChild = newNode;
                    return true;
                }
            }

        }

    }

    public void preOrder(NodeTree node) {
        System.out.println(node.data);
        preOrder(node.leftChild);
        preOrder(node.rightChild);

    }

    public NodeTree insert(NodeTree root, int data) {
        if (root == null) {// 当前树为空树，没有任何节点
            return new NodeTree(data);
        }
        if (root.data > data) {
            root.leftChild = insert(root.leftChild, data);
        } else {
            root.rightChild = insert(root.rightChild, data);
        }
        return root;
    }


    // 插入节点
   /* public boolean insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {// 当前树为空树，没有任何节点
            root = newNode;
            return true;
        } else {
            Node current = root;
            Node parentNode = null;
            while (current != null) {
                parentNode = current;
                if (current.data > data) {// 当前值比插入值大，搜索左子节点
                    current = current.leftChild;
                    if (current == null) {// 左子节点为空，直接将新值插入到该节点
                        parentNode.leftChild = newNode;
                        return true;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {// 右子节点为空，直接将新值插入到该节点
                        parentNode.rightChild = newNode;
                        return true;
                    }
                }
            }
        }
        return false;
    }*/
}
