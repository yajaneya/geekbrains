package ru.geekbrains.Alg_SD.dz.dz7;

public class Vertex {
    private final String label;
    private boolean wasVisited;
    private int previous;

    public Vertex(String label) {
        this.label = label;
        this.wasVisited = false;
        this.previous = -1;
    }

    public String getLabel() {
        return label;
    }

    public boolean isWasVisited() {
        return wasVisited;
    }

    public void setWasVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }

    public int getPrevious() {
        return previous;
    }

    public void setPrevious(int previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return label;
    }
}
