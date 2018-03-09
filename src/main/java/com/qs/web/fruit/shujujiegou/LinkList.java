package com.qs.web.fruit.shujujiegou;

import java.util.LinkedList;

/**
 * 自己实现双向链表
 *
 * @author shuaion 2018/3/8
 **/
public class LinkList {
    //首节点
    Node firstNode;
    //尾节点
    Node lastNode;

    //添加元素
    public void add(String data){

        Node n = new Node(lastNode,data,null);

        Node temp = firstNode;//遍历开始于头结点

        if (temp == null){
            firstNode = n;
        }else {
            //遍历节点 直到找到最后一个节点
            while (temp.next!=null){
                temp = temp.next;
            }
            temp.next = n;
        }
    }

    //定义节点
    static class Node{
        //前一个节点
        Node pre;
        //下一个节点
        Node next;
        //存储数据
        String data;

        public Node(Node next,String data){
            this.next = next;
            this.data = data;
        }

        public Node(Node pre,String data,Node next){
            this.next = next;
            this.data = data;
            this.pre = pre;
        }

    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.println(list.pollLast());

    }
}
