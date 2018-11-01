package ru.geekbrains.Alg_SD.dz.dz7;

public class Vertex {
    private final String label;
    private boolean wasVisited;

    public Vertex(String label) {
        this.label = label;
        this.wasVisited = false;
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

    @Override
    public String toString() {
        return "Vertex{" +
                "label='" + label + '\'' +
                '}';
    }
}
