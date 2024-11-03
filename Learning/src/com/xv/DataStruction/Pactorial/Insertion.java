package com.xv.DataStruction.Pactorial;

public class Insertion {
    public static void insertion(int low,int[] a){
        if(low == a.length){
            return;
        }
        int t = a[low];
        int i = low-1;
        while(i>=0&&a[i]>t){
            a[i+1] = a[i];
            i--;
        }
        a[i+1] = t;
        insertion(low+1,a);

    }

}
