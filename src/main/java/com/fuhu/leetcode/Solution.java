package com.fuhu.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 1; i < m ; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != matrix[i-1][j-1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String str = null;
        int[][] matrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        int[] arr = {1,2,3,4};
        //String combined = Arrays.stream(arr).boxed().map(val -> { return val + "";}).collect(Collectors.joining(",", "[", "]"));
        Arrays.stream(matrix).forEach(currArray ->{
            String line = Arrays.stream(currArray).boxed().map(val -> { return val + "";})
                    .collect(Collectors.joining(",", "[", "]"));
            System.out.println(line);
        });
        return;
    }
}
