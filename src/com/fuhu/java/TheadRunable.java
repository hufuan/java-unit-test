package com.fuhu.java;
class Worker implements Runnable
{
    @Override
    public void run() {
        for (int i = 0; i < 3; i++)
        {
            try {
            Thread.sleep(500);
            } catch (Exception e) {
            }
            System.out.println("This is thread :" + Thread.currentThread().getName() + " tick id" + i);
        }
        System.out.println("local thread finished");
    }
}
public class TheadRunable {
    public static void main(String argv[])
    {
        Worker myWoker = new Worker();
        Thread myThread = new Thread(myWoker);
        myThread.start();
        System.out.println("main thread finished1");
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
        }
        myWoker.run();
        //myThread.start();//IllegalThreadStateException
        System.out.println("main thread finished2");
        return;
    }
}
