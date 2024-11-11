package com.xv.DataStruction.Duilie;

public class YouxuDuiLie<E extends Priority> {
    Priority[] array;
    int size;
    @SuppressWarnings("all")
    public YouxuDuiLie(int capacity) {
        array = new Priority[capacity];
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public boolean isFull(){
        return size == array.length;
    }
    public void insert(E e){
        int i = 0;
        for(i = size-1;i>=0;i--){
            if(array[i].priority()>e.priority()){
                array[i+1] = array[i];
            }
            else{
                array[i+1] = e;
            }
        }
    }
    public boolean offer(E e){
        if(isFull()){
            return false;
        }
        insert(e);
        return true;
    }
    public E poll(){
        if(isEmpty()){
            return null;
        }
        E val = (E)array[--size];
        array[size] = null;
        return val;
    }
    public E peek(){
        if(isEmpty()){
            return null;
        }
        return (E)array[size-1];
    }

}
