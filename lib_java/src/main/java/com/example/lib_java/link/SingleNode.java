package com.example.lib_java.link;

/**
 * 单链表 结点
 */
class SingleNode<T> {
    private SingleNode<T> next;// 指针
    private T data;  // 数据域

    public SingleNode<T> getNext() {
        return next;
    }

    public void setNext(SingleNode<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
