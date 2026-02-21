package com.iasdiaz.interviewprep.algorithms.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.iasdiaz.interviewprep.datastructures.linear.Queue;
import com.iasdiaz.interviewprep.datastructures.nonlinear.graphs.Edge;
import com.iasdiaz.interviewprep.datastructures.nonlinear.graphs.Vertex;

public class GraphTraverser<T> {

    public GraphTraverser() {}

    public List<Vertex<T>> depthFirstTraversal(final Vertex<T> start) {
        final Set<Vertex<T>> visited = new HashSet<>();
        final List<Vertex<T>> result = new ArrayList<>();
        dfs(start, visited, result);
        return result;
    }

    private void dfs(final Vertex<T> start, final Set<Vertex<T>> visitedVertices, final List<Vertex<T>> result) {
        visitedVertices.add(start);
        result.add(start);

        for (final Edge<T> e : start.getEdges()) {
            final Vertex<T> neighbor = e.getEnd();

            if (!visitedVertices.contains(neighbor)) {
                dfs(neighbor, visitedVertices, result);
            }
        }
    }

    public List<Vertex<T>> breadthFirstTraversal(final Vertex<T> start) {

        final Set<Vertex<T>> visited = new HashSet<>();
        final Queue<Vertex<T>> queue = new Queue<>();
        final List<Vertex<T>> result = new ArrayList<>();

        visited.add(start);
        queue.enqueue(start);

        while (!queue.isEmpty()) {
            final Vertex<T> current = queue.dequeue();
            result.add(current);

            for (final Edge<T> e : current.getEdges()) {
                final Vertex<T> neighbor = e.getEnd();

                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.enqueue(neighbor);
                }
            }
        }
        return result;
    }
}
