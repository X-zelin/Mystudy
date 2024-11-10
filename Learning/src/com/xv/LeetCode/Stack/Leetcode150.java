package com.xv.LeetCode.Stack;

import java.util.LinkedList;

public class Leetcode150 {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        for(String t:tokens){
            switch(t){
                case "+"->{
                    Integer a = stack.pop();
                    Integer b = stack.pop();
                    stack.push(a+b);
                }
                case "-"->{
                    Integer a = stack.pop();
                    Integer b = stack.pop();
                    stack.push(a-b);
                }
                case "*"->{
                    Integer a = stack.pop();
                    Integer b = stack.pop();
                    stack.push(a*b);
                }
                case "/"->{
                    Integer a = stack.pop();
                    Integer b = stack.pop();
                    stack.push(a/b);
                }
                default->{
                    stack.push(Integer.parseInt(t));
                }


            }
        }
        return stack.pop();
    }
}
