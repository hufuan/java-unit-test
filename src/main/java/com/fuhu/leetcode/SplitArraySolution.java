package com.fuhu.leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
//split one array into two sum equal arrays, if can't split , return null, if it can be, return one of the sub arrays
public class SplitArraySolution {
    List<Integer> res = null;
    List<Integer> getPart(int[] input){
        int sum = Arrays.stream(input).reduce(0, Integer::sum);
        System.out.println("sum = " + sum);
        if (sum % 2 != 0 ){
            return res;
        }
        List<Integer> list = new ArrayList<>();
        for (int i: input) {
            list.add(i);
        }
        List<Integer> currentList = new ArrayList<>();
        List<Integer> toBeProcessList = new ArrayList<>();
        toBeProcessList.addAll(list);
        getPartWrapper(toBeProcessList, currentList, 0, sum/2);
        return res;
    }

    private List<Integer> cloneNextProcessed(List<Integer> toBeProcessd, int value){
        List<Integer> newList = new ArrayList<>();
        newList.addAll(toBeProcessd);
        Iterator<Integer> iterator = newList.iterator();
        while (iterator.hasNext()){
            Integer item = iterator.next();
            if (item.intValue() == value){
                iterator.remove();
                break;
            }
        }
        return newList;
    }

    private void printArray(List<Integer> list, String tag){
        String combined = list.stream().map(val -> { return val + "";}).collect(Collectors.joining(",", tag + " = [", "]"));
        System.out.println(combined);
    }
    private void printArrayList(int[] nums, String tag){
        String combined = Arrays.stream(nums).boxed().map(val -> { return val + "";}).collect(Collectors.joining(",", tag + " = [", "]"));
        System.out.println(combined);
    }

    private List<Integer> cloneCurrentList(List<Integer> currentList, int value){
        List<Integer> newList = new ArrayList<>();
        newList.addAll(currentList);
        newList.add(value);
        return newList;
    }
    private void getPartWrapper(List<Integer> toBeProcessd, List<Integer> currentList, int currentSum, int target) {
        System.out.println("###############");
        printArray(toBeProcessd, "toBeProcessd");
        printArray(currentList, "currentList");
        System.out.println("currentSum: " + currentSum + " target= " + target);
        if (res != null){
            return;
        }
        if (currentSum == target){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  find result");
            res = currentList;
            printArray(currentList, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> result is");
            return;
        }
        for (int item: toBeProcessd){
            getPartWrapper(cloneNextProcessed(toBeProcessd, item),
                    cloneCurrentList(currentList, item),
                    currentSum+item,
                    target);
        }
        return;
    }


    public static void main(String[] args) {
        SplitArraySolution sol = new SplitArraySolution();
        int[] input = {0,1,7,4,6,3,9,2};
        List<Integer> res = sol.getPart(input);
        if (res != null)
            sol.printArray(res, "answer: ");
        else
            System.out.println("can't split");

        return;
    }
}
