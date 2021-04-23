package com.fuhu.java.iostream;

import java.io.*;
import java.net.URL;

public class ObjectOutputStreamDemo {
    public static void main(String[] args) {
        String s = "hello world";
        int i = 897648764;
        String fileName = "test.txt";
        try {
            URL url = Thread.currentThread().getContextClassLoader().getResource("");
            String dir = url.toURI().getPath();
            String fullFileName = dir + fileName;
            System.out.println("fullFileName = " + fullFileName);
            FileOutputStream out = new FileOutputStream(
                    new File(fullFileName));
            ObjectOutputStream oout = new ObjectOutputStream(out);

            oout.writeObject(s);
            oout.writeObject(i);

            //close the stream
            oout.close();

            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(new File(fullFileName)) );
            System.out.println("#1: " + (String) ois.readObject());
            System.out.println("#2: " +  ois.readObject());

        } catch ( Exception e) {
            e.printStackTrace();
        }
    }
}
