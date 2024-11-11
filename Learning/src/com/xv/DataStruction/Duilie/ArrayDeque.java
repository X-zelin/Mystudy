package com.xv.DataStruction.Duilie;
import java.util.Iterator;
public class ArrayDeque<E> implements Deque<E>,Iterable<E> {
    static int inv(int i,int length){
        if(i+1 >= length){
            return 0;
        }
        return i+1;
    }
    static int dev(int i,int length){
        if(i-1<0){
            return length-1;
        }
        return i-1;
    }
    E[] array;
    int head;
    int tail;
    @SuppressWarnings("all")
    public ArrayDeque(int capacity){
        array = (E[])new Object[capacity+1];
    }
    public boolean isEmpty(){
        return head == tail;
    }
    public boolean isFull(){
        if(head<tail){
            return tail-head == array.length-1;
        }else if(head >tail){
            return head-tail == 1;
        }
        return false;
    }
    public boolean offerFirst(E e){
        if(isFull()){
            return false;
        }
        head = dev(head,array.length);
        array[head] = e;
        return true;
    }
    public boolean offerLast(E e){
        if(isFull()){
            return false;
        }
        array[tail] = e;
        tail = inv(tail,array.length);
        return true;
    }
    public E pollFirst(){
        if(isEmpty()){
            return null;
        }
        E val = array[head];
        head = inv(head,array.length);
        val = null;
        return val;
    }
    public E pollLast(){
        if(isEmpty()){
            return null;
        }
        tail = dev(tail,array.length);
        E val = array[tail];
        val = null;
        return val;
    }
    public E peekFirst(){
        if(isEmpty()){
            return null;
        }
        return array[head];
    }
    public E peekLast(){
        if(isEmpty()){
            return null;
        }
        return array[dev(tail,array.length)];
    }
    public Iterator<E> iterator(){
        return new Iterator<E>(){
            int p = head;
            public boolean hasNext(){
                return p!=tail;
            }
            public E next(){
                E val = array[p];
                p = dev(p,array.length);
                return val;
            }
        };
    }



}
