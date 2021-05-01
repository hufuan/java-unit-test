package com.fuhu.algo.sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
思路：通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。可以理解为玩扑克牌时的理牌；
 */
public class InsertSorting {
    public void sort(int[] array) {
        int length = array.length;
        for (int i =1; i < length; i++) {
            //get the first item in the unsorted list,then this space can be overwritten
            int new_item = array[i];
            int j = i -1; //the last item in the sorted list
            while (j >=0 && array[j] > new_item) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = new_item;
        }

    }
    public static void main(String argv[]) {
        int[] testArray = new int[] {2,10,9,5,4,50,999,200,7,103};
        BulbleSorting bulble = new BulbleSorting();
        bulble.sort(testArray);
        String output = Arrays.stream(testArray).boxed().map(val-> { return val+"";})
                .collect(Collectors.joining(",","[", "]"));
        System.out.println("Output result is: " + output);
    }
}
