package com.xv.DataStruction.Duilie;

public class PriorityDeque<E extends Priority> implements Deque<E{
    E[] array;
    int size;
    @SuppressWarnings("all")
    public PriorityDeque(int capacity){
        array = (E[])new Object[capacity];
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
        array[size++] = e;
        return true;
    }
    public int selectPriority(E[] array){
        int max = 0;
        for(int i= 0;i<size;i++){
            if(array[i].priority()>array[max].priority()){
                max = i;
            }
        }
        return max;
    }
    public void remove(int x,E[] array){
        System.arraycopy(array,x+1,array,x,size-(x+1));
    }
    public E poll(){
        if(isEmpty()){
            return null;
        }
        if()
        int max = selectPriority(array);
        remove(max,array);



    }
}
