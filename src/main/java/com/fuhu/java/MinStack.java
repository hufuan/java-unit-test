package com.fuhu.java;

import java.util.ArrayList;
import java.util.List;

class MinStack {
    List<Integer> list = new ArrayList<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int val) {
        list.add(val);
    }

    public void pop() {
        if (!list.isEmpty()) {
            list.remove(list.size() -1);
        }
    }

    public int top() {
        return list.get(list.size() -1);
    }

    public int getMin() {
        //return   list.stream().reduce(Integer::min).get();
        int tmp = list.stream().mapToInt(m->m.intValue()).min().getAsInt();
        return tmp;
    }
    public static void main(String argv[]) {
        List<Integer> list = new ArrayList<>();
        list.add(23);
        list.add(789);
        list.add(-1);
        list.add(41);
        list.add(1234);
        list.add(102);
        Integer max = list.stream().min((list1,list2) -> list1<list2 ? -1:1).get();
        System.out.println(max);
    }
}
