package com.xv.LeetCode.LianBiao.LeetCode23;
class ListNode{
    int val;
    ListNode next;
    public ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}
public class MinHeap {
    ListNode[] array;
    int size;
    public MinHeap(int capacity){
        array = new ListNode[capacity];
    }
    public boolean offer(ListNode e){
        if(isEmpty()){
            return false;
        }
        int child = size-1;
        int parent = (child-1)/2;
        while(child>0&&e.val<array[parent].val){
            array[child] = array[parent];
            child = parent;
            parent = (child - 1)/2;
        }
        array[child] = e;
        return true;
    }
    public void swap(int i,int j){
        ListNode temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public ListNode poll(){
        if(isEmpty()){
            return null;
        }
        int child = size-1;
        swap(child,0);
        size--;
        ListNode m = array[size];
        array[size] = null;
        down(0);
        return m;
    }
    public void down(int i){
        int min = i;
        int left = 2*i+1;
        int right = left+1;
        if(left<size&&array[left].val<array[min].val){
            min = left;
        }
        if(right<size&&array[right].val<array[min].val){
            min = right;
        }
        if(min !=i){
            swap(min,i);
            down(min);
        }
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public boolean isFull(){
        return size == array.length;
    }
}
