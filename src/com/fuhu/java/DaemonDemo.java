package com.fuhu.java;

public class DaemonDemo {
    public static void main(String[] args) {
        WeiXin weiXin = new WeiXin("微信");
        weiXin.setDaemon(true);
        System.out.println(weiXin.isDaemon());
        weiXin.start();
        for (int i = 0; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("main quit!");
    }
}
class WeiXin extends Thread {
    public WeiXin(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 1; i <= 100; i++) {
                System.out.println("下载进度" + i + "%");
                if (i == 100) {
                    System.out.println("下载完成");
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}