package com.xv.singlylinklist;
import java.util.function.Consumer;
import java.util.Iterator;
import static java.lang.String.format;

public class text1 implements Iterable<Integer>{
    private Node head = null;

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>(){
            Node p = head;
            public boolean hasNext(){
                return p!= null;
            }
            public Integer next(){
                int v =p.value;
                p = p.next;
                return v;
            }
        };
    }

    private static class Node{
        int value;
        Node next;
        public Node(int value,Node next){
            this.value = value;
            this.next = next;
        }
    }
    public void addfirst(int value){
        head = new Node(value,head);
    }
    public void loop() {
        Node p = head;
        while (p != null) {
            System.out.println(p.value);
            p = p.next;
        }
    }
    public void loop2(Consumer<Integer> consumer){
        Node p = head;
        while(p !=null){
            consumer.accept(p.value);
            p = p.next;
        }
    }
    public Node findLast(){
        if(head == null){
            return null;
        }
        Node p ;
        for( p = head;p.next!=null;p = p.next){
        }
        return p;
    }
    public void addLast(int value){
        Node p = findLast();
        if(p == null){
            addfirst(value);
            return;
        }
        p.next = new Node(value,p);
    }
    public void text(){
        int i = 0;
        for(Node p = head;p !=null;p = p.next,i++ ){
            System.out.println(p.value+" "+i);
        }
    }
    private Node findIndex(int index){
        int i = 0;
        for(Node p = head;p != null;p = p.next,i++){
            if(i == index){
               return p;
            }
        }
        return null;
    }
    public Node get(int index ){
        Node p = findIndex(index);
        if(p == null){
            throw new IllegalArgumentException(String.format("不存在%d这个数",index));
        }
        return p;
    }
    public IllegalArgumentException illegal(){
        return new IllegalArgumentException(String.format("sorry"));
    }
    public void insert(int index,int value){
        if(index == 0){
            addfirst(value);
        }
        Node p = findIndex(index-1);
        if(p == null){
            throw illegal();
        }
        p.next = new Node(value,p.next);



    }
    public void removefitst(){
        if(head == null){
            throw illegal();
        }
        head = head.next;
    }
    public void loop3(Consumer<Integer> before,Consumer<Integer> after){
        recursion(head,before,after);
    }
    private void recursion(Node curr,Consumer<Integer> before,Consumer<Integer> after){
        if(curr == null){
            return;
        }
        before.accept(curr.value);
        recursion(curr.next,before,after);
        after.accept(curr.value);
    }




}
