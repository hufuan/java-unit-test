package com.fuhu.java;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Sample3 {
    public static int generate(){
        System.out.println("doing work "+ Thread.currentThread());
        Sleep.sleep(10000);
        System.out.println("doing work finish");
        return 2;
    }
    public static int processError(Throwable th) {
        System.out.println("Error: " + th.getMessage());
        throw new RuntimeException("I hate to tell you");
    }

    public static void printIt(int value){
        System.out.println(value + " " + Thread.currentThread());
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(Sample3::generate);
        future.orTimeout(5, TimeUnit.SECONDS)
                .thenApply(data->data+2)
                .thenAccept(data->printIt(data));
        //future.completeOnTimeout(77, 5, TimeUnit.SECONDS);
        System.out.println("hehe1");
        Sleep.sleep(2000);
        System.out.println("hehe2");
    }
}
