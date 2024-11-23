package com.xv.DataStruction.BSTTree;

public class BSTTree2<T extends Comparable<T>>{
    public static class BSTNode<T>{
        T key;
        Object val;
        BSTNode<T> left;
        BSTNode<T> right;
        public BSTNode(T key,Object val){
            this.key = key;
            this.val = val;
        }
        public BSTNode(T key){
            this.key = key;
        }
        public BSTNode(T key,Object val,BSTNode<T> left,BSTNode<T> right){
            this.key = key;
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public Object Min(BSTNode<T> root){
        if(root == null){
            return null;
        }
        if(root.left == null){
            return root.val;
        }
        return Min(root.left);
    }
    public Object Max(BSTNode<T> root){
        if(root == null){
            return null;
        }
        if(root.right == null){
            return root.val;
        }
        return Max(root.right);
    }
    public Object min(BSTNode<T> root){
        if(root == null){
            return null;
        }
        while(root.left != null){
            root = root.left;
        }
        return root.val;
    }
    public Object max(BSTNode<T> root){
        if(root == null){
            return null;
        }
        while(root.right != null){
            root = root.right;
        }
        return root.val;
    }

}
