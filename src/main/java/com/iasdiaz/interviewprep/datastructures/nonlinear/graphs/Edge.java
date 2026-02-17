package com.iasdiaz.interviewprep.datastructures.nonlinear.graphs;

public class Edge<T> {

    private final Vertex<T> start;
    private final Vertex<T> end;
    private final Integer weight;

    public Edge(final Vertex<T> start, final Vertex<T> end, final Integer weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public Vertex<T> getStart() {
        return start;
    }

    public Vertex<T> getEnd() {
        return end;
    }

    public Integer getWeight() {
        return weight;
    }
}
