package com.xv.DataStruction.binarytree;
import java.util.LinkedList;
public class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
    public TreeNode(TreeNode left,int val, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public void preorder(TreeNode node){ //前序遍历
        if(node == null){
            return;
        }
        System.out.print(node.val+"\t");
        preorder(node.left);
        preorder(node.right);
    }
    public void inorder(TreeNode node){
        if(node == null){
            return;
        }
        inorder(node.left);
        System.out.print(node.val+"\t");
        inorder(node.right);
    }
    public void postorder(TreeNode node){
        if(node == null){
            return ;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.val+"\t");
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(new TreeNode(new TreeNode(4),2,null),
                1,
                new TreeNode(new TreeNode(5),3,new TreeNode(6)));
        TreeNode curr = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(curr != null || !stack.isEmpty()){
            if(curr!=null){
                stack.push(curr);
                System.out.println("go"+curr.val);
                curr = curr.left;
            }else{
                TreeNode pop = stack.pop();
                System.out.println("back"+pop.val);
                curr = pop.right;
            }
        }

    }
}
