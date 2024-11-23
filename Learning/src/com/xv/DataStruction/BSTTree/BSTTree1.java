package com.xv.DataStruction.BSTTree;

public class BSTTree1<T extends Comparable<T>> {
    static class BSTNode<T>{
        T key;
        T val;
        BSTNode<T> left;
        BSTNode<T> right;
        public BSTNode(T key,T val){
            this.key = key;
            this.val = val;
        }
        public BSTNode(T key,T val,BSTNode<T> left,BSTNode<T> right){
            this.key = key;
            this.val = val;
            this.left = left;
            this.right = right;
        }
        public BSTNode(T key){
            this.key = key;
        }
    }
    BSTNode<T> root;
    private Object get(T key){
        return doget(root,key);
    }
    private Object doget(BSTNode<T> root,T key){
        if(root == null){
            return null;
        }
        BSTNode<T> left = root.left;
        BSTNode<T> right = root.right;
        int m = key.compareTo(root.val);
        if(m>0){
            return doget(right,key);
        }
        else if(m<0){
            return doget(left,key);
        }
        else{
            return root.val;
        }
    }
    private Object doget01(BSTNode<T> root,T key){
        while(root!=null){
            int m = key.compareTo(root.val);
            if(m>0){
                root = root.right;
            }else if(m<0){
                root = root.left;
            }else{
                return root.val;
            }
        }
        return null;
    }



}
