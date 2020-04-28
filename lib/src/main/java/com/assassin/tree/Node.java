package com.assassin.tree;

/**
 * Author: Shay-Patrick-Cormac
 * Email: fang47881@126.com
 * Ltd: 金螳螂企业（集团）有限公司
 * Date: 2020/3/19 16:49
 * Version: 1.0
 * Description: 类说明
 */
public class Node {
    int data; // 节点数据
    Node leftChild; // 左子节点的引用
    Node rightChild; // 右子节点的引用
    boolean isDelete;// 表示节点是否被删除

    public Node(int data) {
        this.data = data;
    }

    // 打印节点内容
    public void display() {
        System.out.println(data);
    }

} 
