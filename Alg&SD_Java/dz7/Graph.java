package ru.geekbrains.Alg_SD.dz.dz7;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    private Vertex[] vertexes;
    private boolean [][] adjMatrix;
    private int size;

    public Graph(int maxSize) {
        this.size = 0;
        this.vertexes = new Vertex[maxSize];
        this.adjMatrix = new boolean[maxSize][maxSize];
        for (int i=0; i<maxSize; i++)
            for (int j=0; j<maxSize; j++)
                adjMatrix[i][j] = false;
    }

    public void addVertex (String label) {
        vertexes[size++] = new Vertex(label);
    }

    public void addEdge (int start, int end) {
        adjMatrix[start][end] = true;
        adjMatrix[end][start] = true;
    }

    public void display() {
        for (int i=0; i<size; i++) {
            for (int j=0; j<size;j++) {
                if (adjMatrix[i][j])
                    System.out.println(vertexes[i] + " - " + vertexes[j]);
            }
        }
    }

    public void dfs() {
        Stack <Integer> st = new Stack();
        vertexes[0].setWasVisited(true);
        System.out.println(vertexes[0]);;
        st.push(0);
        while (!st.isEmpty()) {
            int v = getAdjUnvisVertex(st.peek());
            if (v == -1) {
                st.pop();
            } else {
                vertexes[v].setWasVisited(true);
                System.out.println(vertexes[v]);
                st.push(v);
            }
        }
        clearVisited();
    }

    public void findShotWay(int start, int end) {
        Queue <Integer> queue = new ArrayDeque<>();
        vertexes[start].setWasVisited(true);
        queue.add(start);
        while (!queue.isEmpty()) {
            int v = getAdjUnvisVertex(queue.peek());
            if (v == -1) {
                queue.remove();
            } else {
                vertexes[v].setWasVisited(true);
                queue.add(v);
                vertexes[v].setPrevious(queue.peek());
                if (v == end) {
                    Stack <Integer> st = new Stack<>();
                    while (true) {
                        st.push(v);
                        if (v == start) {
                            System.out.println("Кратчайший путь от города " + vertexes[start] + " до города " + vertexes [end] + ":");
                            System.out.print(vertexes[st.pop()]);
                            while (!st.empty()){
                                System.out.print(" -> " + vertexes[st.pop()]);
                            }
                            System.out.println();
                            return;
                        } else {
                            v=vertexes[v].getPrevious();
                        }
                    }
                }
            }
        }
        clearVisited();
    }


    public void bfs() {
        Queue <Integer> queue = new ArrayDeque<>();
        vertexes[0].setWasVisited(true);
        System.out.println(vertexes[0]);;
        queue.add(0);
        while (!queue.isEmpty()) {
            int v = getAdjUnvisVertex(queue.peek());
            if (v == -1) {
                queue.remove();
            } else {
                vertexes[v].setWasVisited(true);
                System.out.println(vertexes[v]);
                queue.add(v);
            }
        }
        clearVisited();
    }

    private int getAdjUnvisVertex(int vert) {
        for (int i=0; i<size; i++) {
            if (adjMatrix[vert][i] && !vertexes[i].isWasVisited())
                return i;
        }

        return -1;
    }

    private void clearVisited() {
        for (int i =0; i<size; i++)
            vertexes[i].setWasVisited(false);
    }

}
