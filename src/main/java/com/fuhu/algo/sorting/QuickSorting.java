package com.fuhu.algo.sorting;

import java.util.Arrays;
import java.util.stream.Collectors;
/*
思路：通过一趟排序将待排记录分隔成独立的两部分，
其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。
 */
public class QuickSorting {
    public void quicksort(int[] array, int low, int high) {
        if (low < high) {
            int index = getIndex(array, low, high);
            quicksort(array, low, index-1);
            quicksort(array,index+1, high);
        }

    }
    private int getIndex(int[] array, int low, int high) {
        //let the first item as the standard
        int temp = array[low];
        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && array[high] >= temp) {
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            array[low] = array[high]; //这时
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && array[low] <= temp) {
                low++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            array[high] = array[low];
        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,而是最后一次重复拷贝值，所以需要将tmp赋值给arr[low]
        array[low] = temp;
        return low;
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
