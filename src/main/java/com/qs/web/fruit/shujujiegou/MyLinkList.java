package com.qs.web.fruit.shujujiegou;

/**
 * 自己实现单链表
 *
 * 添加向链表尾部添加数据
 *
 * @author shuaion 2018/3/8
 **/
public class MyLinkList {
    //首节点
    Node firstNode;

    //添加元素
    public void add(String data){

        Node n = new Node(null,data);

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
    //获取首节点 但不弹出首节点
    public String getFirst(){
        String data = firstNode.data;
        return data;
    }
    //弹出首节点
    public String pollFirst(){

        Node temp = firstNode;

        String data = firstNode.data;
        //将首节点下一个节点 赋值给 首节点 就移除首节点
        temp = temp.next;

        firstNode = temp;

        return data;
    }

    //定义节点
    static class Node{
        //下一个节点
        Node next;
        //存储数据
        String data;

        public Node(Node node,String data){
            this.next = node;
            this.data = data;
        }

    }


    public static void main(String[] args) {
        MyLinkList list = new MyLinkList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.println(list);

        System.out.println(list.pollFirst());
        System.out.println();
    }
}
