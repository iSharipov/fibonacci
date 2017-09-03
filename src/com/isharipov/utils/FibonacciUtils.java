package com.isharipov.utils;

import com.isharipov.action.FibonacciTask;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;

public class FibonacciUtils {
    private static final ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
    private static final Map<Integer, Long> cache = new ConcurrentHashMap<>();


    public static long getSeq(int n) {
        if (n <= 1) {
            return n;
        } else {
            if (cache.containsKey(n)) {
                return cache.get(n);
            }
            long seq = getSeq(n - 1) + getSeq(n - 2);
            cache.put(n, seq);
            return seq;
        }
    }

    public static long getParallel(int n) {
        FibonacciTask fibonacciTask = new FibonacciTask(n);
        return pool.invoke(fibonacciTask);
    }
}