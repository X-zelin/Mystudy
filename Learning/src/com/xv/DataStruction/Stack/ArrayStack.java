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
        return array[top-1];
    }
}
class Leetcode20{
    public boolean isValid(String s){
        ArrayStack<Character> stack = new ArrayStack<>(s.length());
        int i = 0;
        for(i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else if(c == '{'){
                stack.push('}');
            }else{
                if(c == stack.peak()){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        Leetcode20 s = new Leetcode20();
        System.out.println(s.isValid("({()"));
        System.out.println(s.isValid("([])"));
    }
}
