package com.xv.DataStruction.Duilie;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestThreadUnsafe {
    private final String[] array = new String[10];
    private int tail = 0;
    private int size = 0;
    ReentrantLock lock = new ReentrantLock();
    Condition tailwaits = lock.newCondition();
    public void offer(String val) throws InterruptedException{
        lock.lockInterruptibly();
        try {
            while(isFull()){
                tailwaits.await();
            }
            array[tail] = val;
            tail++;
        }
        finally{
            lock.unlock();
        }
    }
    public boolean isEmpty(){
        return size ==0;
    }
    public boolean isFull(){
        return size == array.length;
    }
    public String toString(){
        return Arrays.toString(array);
    }
    public static void main(String[] args){
        TestThreadUnsafe queue = new TestThreadUnsafe();
//        new Thread(()->{
//            try{
//                queue.offer("e2");
//
//            }catch(InterruptedException e){
//                throw new RuntimeException(e);
//            }
//        },"t2").start();
//        new Thread(()-> {
//            try {
//                queue.offer("e2");
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        },"t2").start();
        new Thread(()->{
            try{
                queue.offer("e10");

            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }

        },"t1").start();
        new Thread(()->{
            try{
                queue.lock.lockInterruptibly();
                queue.tailwaits.signal();
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }finally{
                queue.lock.unlock();
            }
        },"t2").start();
    }
}
