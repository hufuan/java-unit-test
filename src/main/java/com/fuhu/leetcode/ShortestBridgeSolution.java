package com.fuhu.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShortestBridgeSolution {
    enum MoveDirection {
        LEFT(-1,0), RIGHT(1, 0), UP(0, 1), DOWN(0, -1);
        private int moveX;
        private int moveY;
        private MoveDirection(int x, int y){
            moveX = x;
            moveY = y;
        }
        public int getMoveX() {
            return moveX;
        }
        public int getMoveY() {
            return moveY;
        }
    }

    class Point {
        int x;
        int y;
        int xMax;
        int yMax;
        public Point(int x, int y, int[][] A){
            this.x = x;
            this.y = y;
            this.xMax = A.length;
            this.yMax = A[0].length;
        }
        boolean canMove(MoveDirection dir){
            int nx = x + dir.getMoveX();
            int ny = y + dir.getMoveY();
            if(nx < 0 || nx >= xMax || ny < 0 || ny>= yMax)
                return false;
            return true;
        }
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
    }

    public int shortestBridge(int[][] A) {
        Deque<Point> queue = new ArrayDeque<>();
        int ans = -1;
        boolean [][] visited = new boolean[A.length][A[0].length];
        boolean flag = true;
        for(int i=0;i<A.length&&flag;i++){
            for(int j=0;j<A[0].length;j++) {
                if (A[i][j] == 1) {
                    dfs(  A, new Point(i, j, A), queue, visited);
                    flag = false;
                    break;
                }
            }
        }
        System.out.println("queue.size = " + queue.size());
        while (!queue.isEmpty()){
            int size = queue.size();
            ans++;
            System.out.println("ans = " + ans + " queue.size: " + size);
            for(int i=0;i<size;i++){
                Point node = queue.poll();
                System.out.println("pull node: x: " + node.getX()+ " ny: " + node.getY());
                for (MoveDirection dir : MoveDirection.values()){
                    int nx = node.x + dir.getMoveX();
                    int ny = node.y + dir.getMoveY();
                    if (!node.canMove((dir)) || visited[nx][ny])
                        continue;
                    if(A[nx][ny]==1)    return ans;
                    visited[nx][ny] = true;
                    queue.add(new Point(nx,ny, A));
                    System.out.println("add node: x: " + nx + " ny: " + ny);
                }
            }
        }
        return ans;
    }
    private void dfs(int [][]A,Point point,Deque queue,boolean[][]visited){
        int x = point.getX();
        int y = point.getY();
        if ( visited[x][y] || A[x][y]!=1 )
            return;
        visited[x][y] = true;
        queue.add(point);
        for (MoveDirection dir : MoveDirection.values()){
            if (point.canMove((dir))){
                dfs(A, new Point(x + dir.getMoveX(), y + dir.getMoveY(), A), queue, visited);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] input = {{0,1,1},{0,0,0},{0,0,1}};
        int res = sol.shortestBridge(input);
        System.out.println("res = " + res);
        return;
    }
}
