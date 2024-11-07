package com.xv.DataStruction.Duilie;
import java.util.Iterator;
public class Arrayqueue<E> implements Queue<E>,Iterable<E>{
    private E[] array;
    private int head = 0;
    private int tail = 0;
    public Arrayqueue(int capacity){
        array = (E[])new Object[capacity];
    }
    @Override
    public boolean offer(E value) {
        if(isfull()){
            return false;
        }
        array[tail] = value;
        tail = (tail+1)%array.length;
        return true;

    }

    @Override
    public E poll() {
        if(isEmpty()){
            return null;
        }
        E value = array[head];
        head = (head+1)%array.length;
        return value;
    }

    @Override
    public E peal() {
        return null;
    }

    @Override
    public E peak() {
        if(isEmpty()){
            return null;
        }
        return array[head];
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
    public boolean isfull(){
        return (tail+1)%array.length == head;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>(){
            int p = head;
            public boolean hasNext(){
                return p!=tail;
            }
            public E next(){
                E value = array[p];
                p = (p+1)%array.length;
                return array[p];
            }
        };
    }
}
