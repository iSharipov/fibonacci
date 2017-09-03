package com.isharipov.action;

import com.isharipov.utils.FibonacciUtils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RecursiveTask;

public class FibonacciTask extends RecursiveTask<Long> {
    private final int n;
    private final ConcurrentHashMap<Integer, Long> cache = new ConcurrentHashMap<>();

    public FibonacciTask(int n) {
        this.n = n;
    }

    @Override
    protected Long compute() {
        if (n <= 70) {
            return FibonacciUtils.getSeq(n);
        } else {
            FibonacciTask fib1 = new FibonacciTask(n - 1);
            FibonacciTask fib2 = new FibonacciTask(n - 2);
            fib1.fork();
            return fib2.compute() + fib1.join();
        }
    }
}