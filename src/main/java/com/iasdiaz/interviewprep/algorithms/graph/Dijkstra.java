package com.iasdiaz.interviewprep.algorithms.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

import com.iasdiaz.interviewprep.datastructures.nonlinear.graphs.Edge;
import com.iasdiaz.interviewprep.datastructures.nonlinear.graphs.Graph;
import com.iasdiaz.interviewprep.datastructures.nonlinear.graphs.Vertex;

public class Dijkstra<K> {

    public record DijkstraResult<K>(
            HashMap<Vertex<K>, Integer> distances,
            HashMap<Vertex<K>, Vertex<K>> predecessors) {
    }

    public record ShortestPathResult<K>(
            int distance, List<Vertex<K>> path) {
    }

    public Dijkstra() {
    }

    public DijkstraResult<K> dijkstra(final Graph<K> graph, final Vertex<K> startingVertex) {

        final HashMap<Vertex<K>, Integer> distances = new HashMap<>();
        final HashMap<Vertex<K>, Vertex<K>> predecessors = new HashMap<>();
        final PriorityQueue<QueueObject<K>> queue = new PriorityQueue<>();
        queue.add(new QueueObject<>(startingVertex, 0));

        for (final Vertex<K> vertex : graph.getVertices()) {
            distances.put(vertex, Integer.MAX_VALUE);
            predecessors.put(vertex, null);
        }

        distances.put(startingVertex, 0);

        while (!queue.isEmpty()) {
            final QueueObject<K> current = queue.poll();
            if (current == null) {
                continue;
            }

            final Vertex<K> currentVertex = current.vertex;
            final Integer currentDistance = distances.get(currentVertex);

            if (current.priority > currentDistance) {
                continue;
            }

            for (final Edge<K> edge : currentVertex.getEdges()) {
                final Integer weight = edge.getWeight();
                if (weight == null) {
                    throw new IllegalArgumentException("Dijkstra requires weighted edges");
                } else if (weight < 0) {
                    throw new IllegalArgumentException("Dijkstra does not support negative weights");
                }

                if (currentDistance == Integer.MAX_VALUE) continue;
                final int alternate = currentDistance + weight;
                final Vertex<K> neighborValue = edge.getEnd();

                if (alternate < distances.get(neighborValue)) {
                    distances.put(neighborValue, alternate);
                    predecessors.put(neighborValue, currentVertex);
                    queue.add(new QueueObject<>(edge.getEnd(), alternate));
                }

            }
        }

        return new DijkstraResult<>(distances, predecessors);
    }

    public ShortestPathResult<K> shortestPathBetween(
            final Graph<K> graph,
            final Vertex<K> startingVertex,
            final Vertex<K> targetVertex
    ) {
        final DijkstraResult<K> dijkstraResult = this.dijkstra(graph, startingVertex);
        final HashMap<Vertex<K>, Integer> distances = dijkstraResult.distances();
        final HashMap<Vertex<K>, Vertex<K>> previous = dijkstraResult.predecessors();

        final Integer distance = distances.get(targetVertex);

        if (distance == null || distance == Integer.MAX_VALUE) {
            return new ShortestPathResult<>(Integer.MAX_VALUE, Collections.emptyList());
        }

        final ArrayList<Vertex<K>> path = new ArrayList<>();
        Vertex<K> tempVertex = targetVertex;

        while (tempVertex != null) {
            path.add(tempVertex);
            tempVertex = previous.get(tempVertex);
        }

        Collections.reverse(path);
        return new ShortestPathResult<>(distance, path);
    }
}
