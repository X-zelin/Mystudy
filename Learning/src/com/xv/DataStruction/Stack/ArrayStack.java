package com.xv.DataStruction.Stack;
import java.util.Iterator;
public class ArrayStack<E> implements Iterable<E>{
    private E[] array;
    private int top;
    @SuppressWarnings("all")
    public ArrayStack(int capacity){
        array = (E[])new Object[capacity];
    }
    public Iterator<E> iterator(){
        return new Iterator<E>(){
            int p = top-1;
            public boolean hasNext(){
                return p>=0;
            }
            public E next(){
                E value = array[p--];
                return value;
            }

        };
    }
    public boolean push(E val){
        if(isFull()) {
            return false;
        }
        array[top++] = val;
        return true;
    }
    public E pop(){
        if(isEmpty()){
            return null;
        }
        return array[--top];

    }
    public boolean isEmpty(){
        return top == 0;
    }
    public boolean isFull(){
        return top == array.length;
    }
    public E peak(){
        if(isEmpty()){
            return null;
        }
        return head.next.val;
    }
}
