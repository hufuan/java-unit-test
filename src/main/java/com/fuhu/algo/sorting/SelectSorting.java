package com.fuhu.algo.sorting;

import java.util.Arrays;
import java.util.stream.Collectors;
/*
冒泡排序是通过相邻的比较和交换，每次找个最小值。
选择排序是：首先在未排序序列中找到最小元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小元素，
然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
选择排序为不稳定排序，举个例子，序列5 8 5 2 9，我们知道第一遍选择第1个元素5会和2交换，
那么原序列中2个5的相对前后顺序就被破坏了，所以选择排序不是一个稳定的排序算法。
 */
public class SelectSorting {
    public void sort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length -1; i++) {
            int min_index = i;
            boolean swapFlag = false;
            for (int j = i+1; j < length; j++) {
                if (array[j] < array[min_index]) {
                    min_index = j;
                    swapFlag = true;
                }
            }
            if (swapFlag) {
                int temp = array[i];
                array[i] = array[min_index];
                array[min_index] = temp;
            }
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
