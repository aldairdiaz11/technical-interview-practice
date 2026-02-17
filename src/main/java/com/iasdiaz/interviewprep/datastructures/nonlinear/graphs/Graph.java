package com.iasdiaz.interviewprep.datastructures.nonlinear.graphs;

import java.util.ArrayList;

public class Graph<T> {
    private final ArrayList<Vertex<T>> vertices;
    private final boolean isWeighted;
    private final boolean isDirected;

    public Graph(boolean isWeighted, boolean isDirected) {
        this.vertices = new ArrayList<>();
        this.isWeighted = isWeighted;
        this.isDirected = isDirected;
    }

    public Graph() {
        this.vertices = new ArrayList<>();
        this.isWeighted = false;
        this.isDirected = false;
    }

    public ArrayList<Vertex<T>> getVertices() {
        return vertices;
    }

    public Vertex<T> addVertex(final T data) {
        final Vertex<T> newVertex = new Vertex<>(data);
        vertices.add(newVertex);
        return newVertex;
    }

    public void removeVertex(final Vertex<T> vertex) {
        vertices.remove(vertex);
        for (Vertex<T> existingVertex : vertices) {
            existingVertex.removeEdge(vertex);
        }
    }

    public void addEdge(final Vertex<T> source, final Vertex<T> target, Integer weight) {
        if (!isWeighted) {
            weight = null;
        }

        source.addEdge(target, weight);
        if (!isDirected) {

            target.addEdge(source, weight);
        }
    }

    public void removeEdge(final Vertex<T> source, final Vertex<T> target) {
        source.removeEdge(target);
        if (!isDirected) {
            target.removeEdge(source);
        }
    }

    public Vertex<T> getVertexByValue(final T value) {
        for (Vertex<T> vertex : vertices) {
            if (vertex.getData().equals(value)) {
                return vertex;
            }
        }
        return null;
    }
}
