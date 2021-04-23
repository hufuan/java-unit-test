package com.fuhu.java;

import org.w3c.dom.ls.LSOutput;

import java.io.StringReader;
import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < primes.length ; i++) {
            pq.add(new int[]{primes[i], 0, i});
        }
        for (int i = 1; i < n; i++) {
            int[] tmp = pq.poll();
            ugly[i] = tmp[0];
            tmp[0] = ugly[++tmp[1]]*primes[tmp[2]];
            pq.add(tmp);
            if (ugly[i]==ugly[i-1]) i--;
        }
        return ugly[n-1];
    }

    public static void main(String argv[]) {

        String content = "hello";
        StringReader in=new StringReader(content);
        int s;
        String sb = "";
        try {
            while ((s = in.read()) != -1) {
                sb += (char) s;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            in.close();
        }
        System.out.println("sb =" + sb);
        Solution sol = new Solution();
        int[] primes = {2,7,13,19};
        int ret = sol.nthSuperUglyNumber(12, primes);

        System.out.println("res = "+  ret);
    }
}
