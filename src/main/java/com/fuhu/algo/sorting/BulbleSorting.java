package com.fuhu.algo.sorting;

import java.util.Arrays;
import java.util.stream.Collectors;
/*
思路：外层循环控制趟数，共n-1趟，
内循环控制比较次数出现逆序就交换，通过与相邻元素的比较和交换来把小的数交换到最前面。
 */
public class BulbleSorting {
    public void sort(int[] array) {
        int length = array.length;
        //外层循环控制排序趟数
        for (int i =0; i < length -1; i++) {
            //内层循环控制每一趟排序多少次
            for (int j = 0; j < length -1 -i; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
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
