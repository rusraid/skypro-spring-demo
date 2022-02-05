package pro.sky.skyprospringdemo.service.list;

import pro.sky.skyprospringdemo.data.Person;

public class Node<T> {
    Node<T> next;
    T item;

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
