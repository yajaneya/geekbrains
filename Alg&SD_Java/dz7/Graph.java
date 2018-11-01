package ru.geekbrains.Alg_SD.dz.dz7;

public class Graph {

    private Vertex[] vertexes;
    private int[][] adjMatrix;
    private int size;

    public Graph(int maxSize) {
        this.size = 0;
        this.vertexes = new Vertex[maxSize];
        this.adjMatrix = new int[maxSize][maxSize];
        for (int i=0; i<maxSize; i++)
            for (int j=0; j<maxSize; j++)
                adjMatrix[i][j] = 0;
    }

    public void addVertex (String label) {
        vertexes[size++] = new Vertex(label);
    }


}
