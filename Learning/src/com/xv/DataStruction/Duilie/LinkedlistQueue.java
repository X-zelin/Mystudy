package com.xv.DataStruction.Duilie;
public class LinkedlistQueue<E> implements Queue<E> {
    private static class Node<E>{
        E val;
        Node<E> next;
        public Node(E val,Node<E> next){
            this.val = val;
            this.next = next;
        }
    }
    Node<E> head = new Node<E>(null,null);
    Node<E> tail = head;
    public LinkedlistQueue(){
        tail.next = head;

    }
    @Override
    public boolean offer(E value) {
        Node<E> added = new Node<E>(value,head);
        tail.next = added;
        tail = added;
        return true;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E peal() {
        return null;
    }

    @Override
    public E peak() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

}
