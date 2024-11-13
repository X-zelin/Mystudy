package com.xv.DataStruction.Duilie;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueues implements BlockingQueue{
    private final String[] array = new String[10];
    private int size;
    private int tail;
    private int head;
    ReentrantLock lock = new ReentrantLock();
    Condition tailwaits = lock.newCondition();
    Condition headwaits = lock.newCondition();
    public void offer(String val) throws InterruptedException{
        lock.lockInterruptibly();
        try {
            while (isFull()) {
                tailwaits.await();
            }
            array[tail] = val;
            if(++tail == array.length){
                tail = 0;
            }
        }finally{
            lock.unlock();
        }
    }
    public boolean isFull(){
        return size == array.length;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public boolean offer(String val,long timeout) throws InterruptedException{
        lock.lockInterruptibly();
        long t = TimeUnit.MILLISECONDS.toNanos(timeout);
        try{
            while(isFull()){
                tailwaits.awaitNanos(t);
            }
            array[tail] = val;
            if(++tail == array.length){
                tail = 0;
            }
            size++;
            headwaits.signal();
        }finally{
            lock.unlock();
        }
        return true;
    }
    public String poll() throws InterruptedException{
        lock.lockInterruptibly();
        try {
            if (isEmpty()) {
                headwaits.await();
            }
            String val = array[head];
            if (++head == array.length) {
                head = 0;
            }
            array[head] = null;
            size--;
            tailwaits.signal();
            return val;
        }
        finally{
            lock.unlock();
        }



    }
    public static void main(String[] args){
        System.out.println(System.currentTimeMillis());
    }
}
