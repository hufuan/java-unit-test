package com.fuhu.asyn;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
/**
 * 测试CyclicBarrier
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4,
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("广播 thread id  is " + Thread.currentThread().getId());
                        System.out.println("所有玩家进入第 2 关！");
                    }
                });
        for (int i = 1; i <= 4; i++) {
            new Thread(new Player(i, cyclicBarrier)).start();
        }
        System.out.println("main ended.");
    }
}

/**
 * 玩家类
 *
 * @author itmyhome
 */
class Player implements Runnable {
    private CyclicBarrier cyclicBarrier;
    private int id;

    public Player(int id, CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            System.out.println("玩家" + id + "正在玩第 1 关...");
            System.out.println("玩家" + id + " thread id" + Thread.currentThread().getId());
            cyclicBarrier.await();
            System.out.println("玩家" + id + "进入第 2 关...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}