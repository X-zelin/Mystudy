package com.xv.DataStruction.Pactorial;
import java.util.Arrays;
import java.util.LinkedList;
public class EO6Fibonacci {
    public static  int  f(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return f(n-1)+f(n-2);
    }
    public static int rubbish(int n){//斐波那契兔子问题
        if(n == 1){
            return 2;
        }
        if(n == 2){
            return 2;
        }
        return rubbish(n-1)+rubbish(n-2);
    }
    public static int qingwa(int n ){
      if(n==1){
          return 1;
      }
      if(n==2){
          return 2;
      }
      return qingwa(n-1)+qingwa(n-2);
    }//斐波那契青蛙爬楼梯问题
    public static int fibonacci(int n){
        int[] cache = new int[n+1];
        Arrays.fill(cache,-1);
        cache[0] = 0;
        cache[1] = 1;
        return f(n,cache);

    }
    public static int f(int n,int[] cache){
        if(cache[n]!=-1){
            return cache[n];
        }
        cache[n] = f(n-1,cache)+f(n-2,cache);
        return cache[n];
    }
    static LinkedList<Integer> a = new LinkedList<>();
    static LinkedList<Integer> b = new LinkedList<>();
    static LinkedList<Integer> c = new LinkedList<>();
    public static void move(int n,LinkedList<Integer> a,LinkedList<Integer> b,LinkedList<Integer> c){
        if(n==0){
            return;
        }
        move(n-1,a,c,b);
        c.addLast(a.removeLast());
        move(n-1,b,a,c);
    }

}
