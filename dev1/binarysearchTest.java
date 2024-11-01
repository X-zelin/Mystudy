package com.xv.Binarysearch;

import org.junit.Test;

import static org.junit.Assert.*;
public class binarysearchTest {

    @Test
    public void mySqrt() {
        binarysearch bs = new binarysearch();
        int j = bs.mySqrt(2147483647);
        System.out.println(j);
    }
}