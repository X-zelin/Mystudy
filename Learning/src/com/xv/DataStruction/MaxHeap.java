package com.xv.DataStruction;
import java.util.Arrays;
public class MaxHeap {
    private int[] array;
    private int size;
    private void heapify(){
        for(int i = size/2-1;i>=0;i--){
            down(i);
        }
    }
    public MaxHeap(int[] array){
        this.array = array;
        this.size = array.length;
        heapify();
    }
    private void down(int parent){
        int left = parent*2+1;
        int right = left + 1;
        int max = parent;
        if(left<size&&array[left]>array[parent]){
            max =left;
        }
        if(right<size&&array[right]>array[left]){
            max = right;
        }
        if(max!=parent){
            swap(parent,max);
            down(max);
        }
    }
    private void swap(int i,int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public int peek(){
        return array[0];
    }
    public int poll(){
        int val = array[0];
        swap(0,size-1);
        size--;
        down(0);
        return val;
    }
    public int poll(int index){
        int val = array[index];
        if(index != size-1){
            swap(index,size-1);
            size--;
            down(index);
        }
        return val;
    }
    public void replace(int replaced){
        if(isFull()){
            return;
        }
        array[size] = replaced;
        swap(size,0);
        size--;


    }

    public boolean isFull(){
        return size == array.length;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6};
        MaxHeap maxHeap = new MaxHeap(array);
        System.out.println(Arrays.toString(maxHeap.array));
    }

}
