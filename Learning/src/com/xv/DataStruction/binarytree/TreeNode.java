package com.xv.DataStruction.binarytree;
import java.util.LinkedList;
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(TreeNode left, int val, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void preorder(TreeNode node) { //前序遍历
        if (node == null) {
            return;
        }
        System.out.print(node.val + "\t");
        preorder(node.left);
        preorder(node.right);
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.val + "\t");
        inorder(node.right);
    }

    public void postorder(TreeNode node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.val + "\t");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6)));
        TreeNode curr = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                System.out.println("go" + curr.val);
                curr = curr.left;
            } else {
                TreeNode pop = stack.pop();
                System.out.println("back" + pop.val);
                curr = pop.right;
            }
        }

    }

    public int maxDepth(TreeNode node) {
        if(node == null){
            return 0;
        }
        if(node.left == null && node.right == null){
            return 1;
        }
        int d1 = maxDepth(node.left);
        int d2 = maxDepth(node.right);
        return Integer.max(d1,d2)+1;
    }
    public int MaxDepth(TreeNode root){
        TreeNode curr = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        int max = 0;
        TreeNode pop = null;
        while(curr !=null || !stack.isEmpty()){
            if(curr != null) {
                stack.push(curr);
                int size = stack.size();
                if(size>max){
                    max = size;
                }
                curr = curr.left;
            }else{
                if(stack.peek().right ==null ||stack.peek().right == pop){
                    pop = stack.pop();
                }
                else{
                    curr = stack.pop().right;
                }
            }
        }
        return max;
    }
    public int MinDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int d1 = MinDepth(root.left);
        int d2 = MinDepth(root.right);
        if(d1 == 0){
            return d2+1;
        }
        if(d2 == 0){
            return d1+1;
        }
        return Integer.min(d1,d2)+1;

    }


}
