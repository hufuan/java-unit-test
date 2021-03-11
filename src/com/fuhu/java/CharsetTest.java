package com.fuhu.java;

import java.nio.charset.Charset;

public class CharsetTest {
    public static void main(String[] args) {

        String encoding = System.getProperty("file.encoding");

        System.out.println("current  file.encoding :" + encoding); // UTF-8
        System.out.println(
                "此 Java 虚拟机的默认 charset :" + Charset.defaultCharset().name()); // UTF-8

        /* 尝试重置 file.encoding */
        encoding = System.setProperty("file.encoding", "GBK");

        /* 重置失败,依然是默认的UTF-8 */
        System.out.println("previous encoding is: " + encoding); // UTF-8

        encoding = System.getProperty("file.encoding");

        System.out.println("current file.encoding :" + encoding); // UTF-8

        /* 尝试获取测试属性 */
        System.out.println(System.getProperty("testkey")); // null
        System.setProperty("testkey", "张三");
        System.out.println(System.getProperty("testkey")); // 张三

        System.out.println("张三".getBytes().length); // 6
    }
}
