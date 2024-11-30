package com.xv.DataStruction.RedBlackTree;

public class RedBlackTree1 {
    enum Color {
        RED, BLACK;
    }

    private Node root;

    private static class Node {
        int key;
        Object val;
        Node left;
        Node right;
        Node parent;
        Color color = Color.RED;
        boolean isLeftChild() {
            return parent != null && parent.left == this;
        }

        boolean isRightChild() {
            return parent != null && parent.right == this;
        }

        Node uncle() {
            if (parent == null || parent.parent == null) {
                return null;
            } else if (parent.isLeftChild()) {
                return parent.parent.right;
            } else {
                return parent.parent.left;
            }
        }

        Node sibling() {   //兄弟节点
            if (parent == null) {
                return null;
            }else if(this.isLeftChild()){
                return parent.right;
            }else{
                return parent.left;
            }
        }
        public Node(int key,Object val){
            this.key = key;
            this.val = val;
        }
    }
    public boolean isRed(Node node){
        return node != null && node.color == Color.RED;
    }
    public boolean isBlack(Node node){
        return node == null || node.color == Color.BLACK;
    }
    public void rightRotate(Node pink){
        Node parent = pink.parent;
        Node yellow = pink.left;
        Node green = yellow.right;
        yellow.right = pink;
        pink.left = green;
        yellow.parent = pink.parent;
        pink.parent = yellow;
        if(green != null){
            green.parent = pink;
        }
        if(parent == null){
            root = yellow;
        }
        if(parent.left == pink){
            parent.left = yellow;
        }else if(parent.right == pink){
            parent.right = yellow;
        }
    }
    public void leftRotate(Node pink){
        Node parent = pink.parent;
        Node yellow = pink.right;
        Node green = yellow.left;
        yellow.left = pink;
        pink.right = green;
        if(green != null){
            green.parent = pink;
        }
        pink.parent = yellow;
        yellow.parent = parent;
        if(parent == null){
            root = yellow;
        }
        if(parent.left == pink){
            parent.left = yellow;
        }else if(parent.right == pink){
            parent.right = yellow;
        }
    }
    public void put(int key,Object val){
        Node parent = null;
        Node p = root;
        while(p != null){
            if(p.key == key){
                p.val = val;
                return;
            }else if(p.key>key){
                parent = p;
                p = p.left;
            }else{
                parent = p;
                p = p.right;
            }
        }
        if(parent == null){
            root = new Node(key,val);
        }else if(parent.left == p){
            parent.left = new Node(key,val);
        }else{
            parent.right = new Node(key,val);
        }

    }
    public void fixNode(Node x){
        if(x == root){
            x.color = Color.BLACK;
            return;
        }
        if(isBlack(x.parent)){
            return;
        }
        Node parent = x.parent;
         Node uncle = x.uncle();
        Node grand = parent.parent;
        if(isRed(uncle)){
            parent.color = Color.BLACK;
            uncle.color = Color.BLACK;
            grand.color = Color.RED;
            fixNode(grand);
            return;
        }
        if(x.isLeftChild()&&parent.isLeftChild()){
            if(isBlack(uncle)){
                parent.color = Color.BLACK;
                grand.color = Color.RED;
                rightRotate(grand);
            }
        }else if(x.isRightChild()&&parent.isLeftChild()) {
            leftRotate(parent);
            x.color = Color.BLACK;
            grand.color = Color.RED;
            rightRotate(grand);
        }else if(!x.isLeftChild()&&!parent.isLeftChild()){
            if(isBlack(uncle)){
                parent.color = Color.BLACK;
                grand.color = Color.RED;
                leftRotate(grand);

            }
        }else if(x.isLeftChild()&&!parent.isLeftChild()){
            rightRotate(parent);
            x.color = Color.BLACK;
            grand.color = Color.RED;
            leftRotate(grand);
        }

    }
    public Node find(int key){   //查找被删除的节点
        if(root == null){
            return null;
        }
        Node s = root;
        while(s!=null){
            if(s.key<key){
                s = s.right;
            }else if(s.key>key){
                s = s.left;
            }else{
                return s;
            }
        }
        return null;
    }
    public Node findReplace(Node delete){   //查找剩余节点
        if(delete.left == null && delete.right == null){
            return null;
        }
        if(delete.left == null){
            return delete.right;
        }
        if(delete.right == null){
            return delete.left;
        }
        Node s = delete.right;
        while(s.left!=null){
            s = s.left;
        }
        return s;
    }
    public void remove(int key){
        Node delete = find(key);
        if(delete == null){
            return;
        }
        doremove(delete);
    }
    public void doremove(Node delete){
        Node replace = findReplace(delete);
        Node parent = delete.parent;
        if(replace == null){
            if(delete == root){
                root = null;
            }else{
                if(delete.isLeftChild()){
                    parent.left = null;
                }else{
                    parent.right = null;
                }
                delete.parent = null;
            }
            return;
        }
        if(delete.left == null || delete.right == null){
            if(delete == root) {
                root.val = delete.val;
                root.key = delete.key;
                root.left = root.right = null;
            }else{
                if(delete.isLeftChild()){
                    parent.left = replace;
                }else{
                    parent.right = replace;
                }
                replace.parent = parent;
                delete.left = delete.right = delete.parent = null;
            }
            return;
        }
        int t = delete.key;
        delete.key = replace.key;
        replace.key = t;
        Object m = delete.val;
        delete.val = replace.val;
        replace.val = m;
        doremove(replace);
    }








}
