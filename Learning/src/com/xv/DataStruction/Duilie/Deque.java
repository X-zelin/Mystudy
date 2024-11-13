package com.xv.DataStruction.Duilie;

public interface Deque<E> {
    public boolean isEmpty();
    public E pollFirst();
    public E pollLast();
    public E peekFirst();
    public E peekLast();
    public boolean isFull();
    public boolean offerFirst(E val);
    public boolean offerLast(E val);
}
