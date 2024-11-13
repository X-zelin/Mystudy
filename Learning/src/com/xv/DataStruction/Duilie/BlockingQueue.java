package com.xv.DataStruction.Duilie;

public interface BlockingQueue {
    void offer(String e) throws InterruptedException;
    boolean isEmpty();
    boolean isFull();
}
