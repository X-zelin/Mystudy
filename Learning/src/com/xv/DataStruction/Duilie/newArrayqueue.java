package com.xv.DataStruction.Duilie;

import java.util.Iterator;
public class newArrayqueue<E> implements Queue<E>,Iterable<E>{
    private E[] array;
    private int head = 0;
    private int tail = 0;
    private int size = 0;
    public newArrayqueue(int capacity){
        array = (E[])new Object[capacity];
    }
    @Override
    public boolean offer(E value) {
        if(isfull()){
            return false;
        }
        array[tail&(array.length-1)] = value;
        tail++;
        size++;
        return true;

    }

    @Override
    public E poll() {
        if(isEmpty()){
            return null;
        }
        E value = array[head%array.length];
        head++;
        size--;
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
        return array[head%array.length];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }
    public boolean isfull(){
        return tail-head==array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>(){
            int p = head;
            int count = 0;
            public boolean hasNext(){
                return count<size;
            }
            public E next(){
                E value = array[p];
                p = (p+1)%array.length;
                return array[p];
            }
        };
    }
    public static void main(String[] args) {
        int head = 2147483647;
        for(int i = 0;i<2;i++){
            System.out.println(Integer.toUnsignedLong(head+i));
        }
    }
}