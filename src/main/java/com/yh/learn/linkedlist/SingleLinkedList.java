package com.yh.learn.linkedlist;

/**
 * Created by yanghua on 2019/4/6.
 */
public class SingleLinkedList<T> implements MyList<T>{

    transient Node<T> first;

    transient int size;

    private static class Node<T> {
        T data;

        Node<T> next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public void add(T t) {
        Node addNode = new Node(t, null);
        if(size == 0) {
            first = addNode;
        } else if(size == 1){
            first.next = addNode;
        } else {
            Node lastNode = first.next;
            while (lastNode != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = addNode;
        }
        size ++;
    }

    public T get(int i) {
        if(size == 0) {
            return null;
        }
        if(i == 0) {
            return first.data;
        } else {
            Node<T> searchNode = null;
            int searchCount = 0;
            while(searchCount == i) {
                searchNode = first.next;
                searchCount ++;
            }
            return searchNode.data;
        }

    }

    public void remove(int i) {
        if(!checkIndex(i)) {

        }

//        while()
    }

    private boolean checkIndex(int i) {
        return i > 0 && i < size;
    }
}