package com.xv.DataStruction.Duilie;

public class PriorityQueue<E extends Priority> {
    Priority[] array;
    int size;
    public PriorityQueue(int capacity){
        array = new Priority[capacity];
        size = 0;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public boolean isFull(){
        return size == array.length;
    }
    public boolean offer(E e){
        if(isFull()){
            return false;
        }
        int child = size;
        int parent = (child-1)/2;
        while(child>0&&e.priority()>array[parent].priority()){
            array[child] = array[parent];
            child = parent;
            parent = (child-1)/2;
        }
        array[child] = e;
        size++;
        return true;
    }
    public void swap(int i,int j){
        Priority tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public E poll(){
        if(isEmpty()){
            return null;
        }
        swap(0,size-1);
        size--;
        Priority val = array[size];
        array[size] = null;
        down(0);
        return (E)val;
    }
    public void down(int parent){
        int left = parent * 2 + 1;
        int right = parent * 2 + 2;
        int max = parent;
        if (left < size && array[left].priority() > array[max].priority()) {
            max = left;
        }
        if (right < size && array[right].priority() > array[max].priority()) {
            max = right;
        }
        if(max != parent){
            swap(parent,max);
            down(max);
        }

    }
    public E peek(){
        if(isEmpty()){
            return null;
        }
        return (E)array[0];
    }
}
