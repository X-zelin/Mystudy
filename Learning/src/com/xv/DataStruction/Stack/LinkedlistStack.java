package com.xv.DataStruction.Stack;
import java.util.Iterator;
public class LinkedlistStack<E> implements Iterable<E>  {
    private int capacity;
    private int size;
    public LinkedlistStack(int capacity){
        this.capacity = capacity;
    }
    public  class Node<E>{
        E val;
        Node<E> next;
        public Node(E val,Node<E> next){
            this.val = val;
            this.next = next;
        }
    }
    Node<E> head = new Node<>(null,null);
    public boolean push(E val){
        if(isFull()){
            return false;
        }
        head.next = new Node<E>(val,head.next);
        size++;
        return true;
    }
    public E pop(){
        if(isEmpty()){
            return null;
        }
        Node<E> first = head.next;
        head.next = first.next;
        size--;
        return first.val;
    }
    public boolean isEmpty(){
        return head.next == null;
    }
    public boolean isFull(){
        return size == capacity;
    }
    public E peak(){
        if(isEmpty()){
            return null;
        }
        return head.next.val;
    }
    public Iterator<E> iterator(){
        return new Iterator<E>(){
            Node<E> p = head.next;
            public boolean hasNext(){
                return p!=null;
            }
            public E next(){
                E value = p.val;
                p = p.next;
                return value;
            }

        };
    }
}
