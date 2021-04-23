package com.fuhu.java;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class Sample2 {
    public static int generate(){
            System.out.println("doing work "+ Thread.currentThread());
            //Sleep.sleep(2000);
            return 2;
    }
    public static void pintIt(int value){
        System.out.println(value + " " + Thread.currentThread());
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool1 = new ForkJoinPool(10);
        ForkJoinPool pool2 = new ForkJoinPool(5);
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(Sample2::generate, pool1);

        Sleep.sleep(1000);
        future.thenAcceptAsync(Sample2::pintIt, pool2);
        Sleep.sleep(5000);
        System.out.println("In main");
    }
}
