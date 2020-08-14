package com.example.lib_java.link;

/**
 * @author zhouchao
 * @date 2020/8/14
 */
class LinkNodeMain {
    private void test1() {
        LinkNodeMain linkNodeMain = new LinkNodeMain();
        SingleNode<Integer> singleNode = new SingleNode<>();
        singleNode.setNext(null);
        singleNode.setData(0);
//        linkNodeMain.insertLinkStart(singleNode, 1);
        linkNodeMain.printlnLink(linkNodeMain.insertLinkStart(singleNode, 1));
    }

    private void test2() {
        LinkNodeMain linkNodeMain = new LinkNodeMain();
        SingleNode<Integer> singleNode = new SingleNode<>();
        singleNode.setNext(null);
        singleNode.setData(0);
        linkNodeMain.insertLinkEnd(singleNode, 1);
        linkNodeMain.printlnLink(singleNode);
    }

    private void test3() {
        LinkNodeMain linkNodeMain = new LinkNodeMain();
        SingleNode<Integer> singleNode = new SingleNode<>();
        singleNode.setNext(null);
        singleNode.setData(0);
        linkNodeMain.afterInsert(singleNode, 1);
        linkNodeMain.printlnLink(singleNode);//输出的结果  ： 0 ->10 ->9 ->8 ->7 ->6 ->5 ->4 ->3 ->2 ->1 ->
    }

    public static void main(String[] args) {
        LinkNodeMain linkNodeMain = new LinkNodeMain();
//        linkNodeMain.test1();
//        linkNodeMain.test2();
        linkNodeMain.test3();
    }


    public void insertLinkEnd(SingleNode<Integer> singleNode, int data) {
        if (data > 10) {
            return;
        }
        SingleNode<Integer> curNode = new SingleNode<>();
        curNode.setData(data);
        curNode.setNext(null);
        singleNode.setNext(curNode);
        data++;
        insertLinkEnd(curNode, data);
    }

    //在最前面 插入 新的节点
    public SingleNode<Integer> insertLinkStart(SingleNode<Integer> singleNode, int data) {
        if (data > 10) {
            return singleNode;
        }
        SingleNode<Integer> curNode = new SingleNode<>();
        curNode.setNext(singleNode);
        curNode.setData(data);
        data++;
        return insertLinkStart(curNode, data);
    }

    //将 初始化的时传入的 结点认为是 头结点，然后没次都在 头结点的后面插入 新的结点
    private void afterInsert(SingleNode<Integer> node, int data) {
        if (data > 10) {
            return;
        }
        SingleNode<Integer> curNode = new SingleNode<>();
        curNode.setNext(node.getNext());
        curNode.setData(data);
        node.setNext(curNode);
        data ++;
        afterInsert(node,data);
    }


    private void printlnLink(SingleNode<Integer> singleNode) {
        if (singleNode == null) {
            System.out.println("single is null");
            return;
        }
        System.out.print("single link : ");
        SingleNode<Integer> curNode = singleNode;
        while (curNode != null) {
            System.out.print(curNode.getData() + " ->");
            curNode = curNode.getNext();
        }
    }
}
