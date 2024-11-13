package com.xv.DataStruction.Duilie;
import java.util.Iterator;


public class LinkedListDeque<E> implements Iterable<E>,Deque<E>{
    static class Node<E>{
        E val;
        Node<E> next;
        Node<E> prev;
        public Node(E val,Node<E> prev,Node<E> next){
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
    int size;
    int capacity;
    Node<E> sentinel = new Node<>(null,null,null);
    public LinkedListDeque(int capacity){
        this.capacity = capacity;
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E pollFirst() {
        if(isEmpty()){
            return null;
        }
        Node<E> removed = sentinel.next;
        Node<E> next = removed.next;
        sentinel.next = next;
        next.prev = sentinel;
        size--;
        return removed.val;

    }

    @Override
    public E pollLast() {
        if(isEmpty()){
            return null;
        }
        Node<E> removed = sentinel.prev;
        Node<E> prev = removed.prev;
        prev.next = sentinel;
        sentinel.prev = prev;
        size--;
        return removed.val;
    }

    @Override
    public E peekFirst() {
        if(isEmpty()){
            return null;
        }
        Node<E> first = sentinel.next;
        return first.val;
    }
    public E peekLast(){
        if(isEmpty()){
            return null;
        }
        Node<E> last = sentinel.prev;
        return last.val;
    }
    public boolean isFull(){
        return size == capacity;
    }

    @Override
    public boolean offerFirst(E val) {
        if(isFull()){
            return false;
        }
        Node<E> next = sentinel.next;
        Node<E> first = new Node<>(val,sentinel,next);
        sentinel.next = first;
        next.prev = first;
        size++;
        return true;
    }

    @Override
    public boolean offerLast(E val) {
        if(isFull()){
            return false;
        }
        Node<E> prev = sentinel.prev;
        Node<E> last = new Node<>(val,prev,sentinel);
        prev.next = last;
        sentinel.prev = last;
        size++;
        return true;
    }

    public Iterator<E> iterator(){
        return new Iterator<E> (){
            Node<E> p = sentinel.next;
            public boolean hasNext(){
                return p!=sentinel;
            }
            public E next(){
                E value = p.val;
                p = p.next;
                return value;
            }
        };
    }



}
