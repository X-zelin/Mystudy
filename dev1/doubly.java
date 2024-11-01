package com.xv.huan;
import java.util.function.Consumer;

public class doubly {
    private static class Node{
        int value;
        Node next;
        Node prev;
        public Node(Node prev,int value,Node next){
            this.prev = prev;
            this.value = value ;
            this.next = next;
        }
    }
    private Node sentinel = new Node(null,0,null);
    public doubly(){
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }
    public void addfirst(int value){
        Node a = sentinel;
        Node b = sentinel.next;
        Node add = new Node(a,value,b);
        a.next = add;
        b.prev = add;
    }
    public void removefirst(){
        Node remove = sentinel.next;
        if(remove == sentinel){

        }
        Node next = remove.next;
        sentinel.next = next;
        next.prev = sentinel;
    }
    public Node findByvalue(int value){
        Node p = sentinel.next;
        while(p!=sentinel){
            if(p.value == value){
                return p ;
            }
            p = p.next;
        }
        return null;
    }
    public void removebyvalue(int value){
        Node remove = findByvalue(value);
        if(remove == null){

        }
        Node prev = remove.prev;
        Node next = remove.next;
        prev.next = next;
        next.prev = prev;
    }
//    public void loop3(Consumer<Integer> before,Consumer<Integer> after){
//        recursion(head,before,after);
//    }
//    private void recursion()



}
