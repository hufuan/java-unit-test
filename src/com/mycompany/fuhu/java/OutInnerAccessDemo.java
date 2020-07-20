package com.mycompany.fuhu.java;

class Outer{
    private int m;
    private class Inner{
        private int n;
        private int k;

        public void setN(int n) {
            this.n = n;
        }

        public void setK(int k) {
            this.k = k;
        }

        public int getN() {
            return n;
        }

        public int getK() {
            return k;
        }

        @Override
        public String toString() {
            return "K: " + k + ", N: " + n;
        }
    }
    void printMe()
    {
        Inner in = new Inner();
        in.setK(5);
        in.setN(10);
        //outer class access inner private member
        in.k = 7;
        System.out.println(in);
    }
}
public class OutInnerAccessDemo {
    public static void main(String argv[])
    {
        Outer out = new Outer();
        out.printMe();
    }
}
