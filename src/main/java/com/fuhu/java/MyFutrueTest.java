package com.fuhu.java;

import java.util.concurrent.CompletableFuture;

public class MyFutrueTest {
    public void test2() {
        //创建一个已经有任务结果的CompletableFuture
        CompletableFuture<String> f1 = CompletableFuture.completedFuture("return value");
        //异步处理任务,有返回值
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(this::get);
        //异步处理任务,没有返回值
        CompletableFuture<Void> f3 = CompletableFuture.runAsync(System.out::println);
        //需要等待所有的异步任务都执行完毕,才会返回一个新的CompletableFuture
//        CompletableFuture<Void> all = CompletableFuture.allOf(f1, f2, f3);
        //任意一个异步任务执行完毕,就会返回一个新的CompletableFuture
        CompletableFuture<Object> any = CompletableFuture.anyOf(f1, f2, f3);
        Object result = any.join();
        System.out.println("result = " + result);//result = return value
    }

    public String get() {
        delay();
        return "异步任务结果";
    }

    public void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

