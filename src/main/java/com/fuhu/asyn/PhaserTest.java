package com.fuhu.asyn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserTest {
    public static void main(String argv[]) {
        final int LOOP = 3;
        ///创建时，就需要指定参与的parties个数
        int parties = 5;
        //可以在创建时不指定parties
        // 而是在运行时，随时注册和注销新的parties
        Phaser phaser = new Phaser();
        //主线程先注册一个
        //对应下文中，主线程可以等待所有的parties到达后再解除阻塞（类似与CountDownLatch）
        phaser.register();
        //phaser.register();
        ExecutorService executor = Executors.newFixedThreadPool(parties);
        for(int i = 0; i < parties; i++) {
            phaser.register();//每创建一个task，我们就注册一个party
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        int i = 0;
                        while (i < LOOP && !phaser.isTerminated()) {
                            System.out.println("Generation:" + phaser.getPhase());
                            Thread.sleep(3000);
                            //等待同一周期内，其他Task到达
                            //然后进入新的周期，并继续同步进行
                            phaser.arriveAndAwaitAdvance();
                            i++;//我们假定，运行三个周期即可
                        }
                        System.out.println(Thread.currentThread().getId() + " exited");
                    } catch (Exception e) {
                            e.printStackTrace();
                    }
                    finally {
                        phaser.arriveAndDeregister();
                    }
                }
            });
        }
        //主线程到达，且注销自己
        for (int loop = 0 ; loop < LOOP; loop++) {
            phaser.arriveAndAwaitAdvance();
            System.out.println("loop: " + loop + " sync in main");
        }
        //此后线程池中的线程即可开始按照周期，同步执行。
        System.out.println("main arriveAndDeregister");
        phaser.arriveAndDeregister();
        executor.shutdown();
        if (!executor.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("main ended");
        return;
    }
}
