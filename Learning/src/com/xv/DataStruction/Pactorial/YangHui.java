package com.xv.DataStruction.Pactorial;

public class YangHui {
    public static void main(String[] args){
//        for(int i = 0;i<5;i++){
//            for(int j = 0;j<1+i;j++){
//                System.out.print(element(i,j));
//            }
//            System.out.println();
//        }
        int[][] trangle = new int[5][];
        for(int i=0;i<5;i++){
            trangle[i] = new int[i+1];
            for(int j = 0;j<i+1;j++){
                System.out.print(element(trangle,i,j));
            }
            System.out.println();
        }
    }
    public static int element(int[][] trangle,int i,int j){
        if(trangle[i][j]>0){
            return trangle[i][j];
        }
        if(j == 0||i == j){
           return 1;
        }
        trangle[i][j] = element(trangle,i-1,j)+element(trangle,i-1,j-1);
        return trangle[i][j];

    }



}
