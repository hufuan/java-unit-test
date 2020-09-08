package com.mycompany.fuhu.java;
import java.util.ArrayList;
import java.util.List;
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0|| cost.length ==0 || gas.length != cost.length)
        {
            return -1;
        }
        int total_try = gas.length;
        int num = gas.length;
        for (int i = 0; i < total_try; i++)
        {
            int cur_gas = 0;
            int j = 0;
            for (j = 0; j < num; j++)
            {
                int node_idx = (i + j) % num;
                int next_gas = cur_gas + gas[node_idx] - cost[node_idx];
                if (next_gas < 0)
                {
                    break;
                }
                cur_gas = cur_gas + gas[node_idx] - cost[node_idx];
            }
            if (j == num)
            {
                return i;
            }
        }
        return -1;
    }

    public static void main(String argv[])
    {
        Solution sol = new Solution();
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
        int res = sol.canCompleteCircuit(gas, cost);
        System.out.println("result is: " + res);
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
