package com.iasdiaz.interviewprep.datastructures.nonlinear.graphs;

import java.util.ArrayList;

public class Vertex<T> {

    private final T data;
    private final ArrayList<Edge<T>> edges;

    public Vertex(final T data) {
        this.data = data;
        this.edges = new ArrayList<>();
    }

    public T getData() {
        return data;
    }

    public ArrayList<Edge<T>> getEdges() {
        return edges;
    }

    public void addEdge(final Vertex<T> endVertex, final Integer weight) {
        final Edge<T> edge = new Edge<>(this, endVertex, weight);
        this.edges.add(edge);
    }

    public void removeEdge(final Vertex<T> endVertex) {
        edges.removeIf(edge -> edge.getEnd().equals(endVertex));
    }
}
