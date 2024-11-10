package com.xv.DataStruction.Stack;
import java.util.LinkedList;

public class ZhongZuiToHouZhui {
    public static  int priority(char c){
        switch(c){
            case '+','-' ->{
                return 1;
            }
            case '*','/'->{
                return 2;
            }
            default ->{
                throw new IllegalArgumentException("wrong");
            }

        }

    }
    public static String infixToSuffix(String exp) {
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder(exp.length());
        for(int i = 0;i<exp.length();i++){
            char c = exp.charAt(i);
            switch(c){
                case '+','-','*','/' ->{
                    if(stack.isEmpty()){
                        stack.push(c);
                    }else if(priority(c)>priority(stack.peek())){
                        stack.push(c);
                    }else{
                        while(!stack.isEmpty()&&priority(stack.peek())>=priority(c)){
                            sb.append(stack.pop());
                            stack.push(c);
                        }
                    }
                }default ->{
                    sb.append(exp.charAt(i));
                }
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(infixToSuffix("3-6"));
    }
}
