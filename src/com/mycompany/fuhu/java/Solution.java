package com.mycompany.fuhu.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        int res = 0;
        for (int i = 0; i < s.length();i++) {
            if (i+1 < s.length() && map.containsKey(s.substring(i, i+2))) {
                res += map.get(s.substring(i, i+2));
                i+=2;
            } else {
                res += map.get(s.substring(i,i+1));
                i++;
            }
        }
        return res;
    }
    public static void main(String argv[])
    {
        Solution sol = new Solution();
    }
}
/*
   void printLine(List<Integer> tem)
    {
        for (Integer item2: tem)
        {
            System.out.print(item2 + ",");
        }
    }
    void printMatrix(List<List<Integer>> res)
    {
        for (List<Integer> item: res)
        {
            for (Integer item2: item)
            {
                System.out.print(item2 + ",");
            }
            System.out.println("");
        }
    }
    public static void main(String argv[])
    {
        Solution sol = new Solution();
        List<List<Integer>> res = sol.generate(5);
        sol.printMatrix(res);
    }
 */
