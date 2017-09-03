package com.isharipov;

import com.isharipov.utils.FibonacciUtils;

public class Main {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(FibonacciUtils.getParallel(120));
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        System.out.println(FibonacciUtils.getSeq(1000));
        System.out.println(System.currentTimeMillis() - start);
    }
}