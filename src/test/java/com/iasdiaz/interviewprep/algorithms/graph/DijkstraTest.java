package com.iasdiaz.interviewprep.algorithms.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.iasdiaz.interviewprep.datastructures.nonlinear.graphs.Graph;
import com.iasdiaz.interviewprep.datastructures.nonlinear.graphs.Vertex;

class DijkstraTest {

    @Test
    void dijkstra_shouldComputeShortestDistancesAndPredecessors() {
        final Graph<String> graph = new Graph<>(true, true);
        final Vertex<String> a = graph.addVertex("A");
        final Vertex<String> b = graph.addVertex("B");
        final Vertex<String> c = graph.addVertex("C");
        final Vertex<String> d = graph.addVertex("D");

        graph.addEdge(a, b, 4);
        graph.addEdge(a, c, 1);
        graph.addEdge(c, b, 2);
        graph.addEdge(b, d, 1);
        graph.addEdge(c, d, 5);

        final Dijkstra<String> dijkstra = new Dijkstra<>();
        final Dijkstra.DijkstraResult<String> result = dijkstra.dijkstra(graph, a);

        assertEquals(0, result.distances().get(a));
        assertEquals(3, result.distances().get(b));
        assertEquals(1, result.distances().get(c));
        assertEquals(4, result.distances().get(d));

        assertSame(c, result.predecessors().get(b));
        assertSame(a, result.predecessors().get(c));
        assertSame(b, result.predecessors().get(d));
    }

    @Test
    void shortestPathBetween_shouldReturnDistanceAndPathInOrder() {
        final Graph<String> graph = new Graph<>(true, true);
        final Vertex<String> a = graph.addVertex("A");
        final Vertex<String> b = graph.addVertex("B");
        final Vertex<String> c = graph.addVertex("C");
        final Vertex<String> d = graph.addVertex("D");

        graph.addEdge(a, b, 4);
        graph.addEdge(a, c, 1);
        graph.addEdge(c, b, 2);
        graph.addEdge(b, d, 1);
        graph.addEdge(c, d, 5);

        final Dijkstra<String> dijkstra = new Dijkstra<>();
        final Dijkstra.ShortestPathResult<String> result = dijkstra.shortestPathBetween(graph, a, d);

        assertEquals(4, result.distance());
        assertEquals(List.of("A", "C", "B", "D"), toDataList(result.path()));
    }

    @Test
    void shortestPathBetween_unreachableTarget_shouldReturnInfinityAndEmptyPath() {
        final Graph<String> graph = new Graph<>(true, true);
        final Vertex<String> a = graph.addVertex("A");
        final Vertex<String> b = graph.addVertex("B");
        final Vertex<String> c = graph.addVertex("C");

        graph.addEdge(a, b, 2);

        final Dijkstra<String> dijkstra = new Dijkstra<>();
        final Dijkstra.ShortestPathResult<String> result = dijkstra.shortestPathBetween(graph, a, c);

        assertEquals(Integer.MAX_VALUE, result.distance());
        assertTrue(result.path().isEmpty());
    }

    @Test
    void shortestPathBetween_startEqualsTarget_shouldReturnZeroAndSingleVertexPath() {
        final Graph<String> graph = new Graph<>(true, true);
        final Vertex<String> a = graph.addVertex("A");
        final Vertex<String> b = graph.addVertex("B");
        graph.addEdge(a, b, 2);

        final Dijkstra<String> dijkstra = new Dijkstra<>();
        final Dijkstra.ShortestPathResult<String> result = dijkstra.shortestPathBetween(graph, a, a);

        assertEquals(0, result.distance());
        assertEquals(List.of("A"), toDataList(result.path()));
    }

    @Test
    void dijkstra_unweightedGraph_shouldThrowIllegalArgumentException() {
        final Graph<String> graph = new Graph<>();
        final Vertex<String> a = graph.addVertex("A");
        final Vertex<String> b = graph.addVertex("B");
        graph.addEdge(a, b, 100);

        final Dijkstra<String> dijkstra = new Dijkstra<>();

        final IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> dijkstra.dijkstra(graph, a)
        );

        assertEquals("Dijkstra requires weighted edges", exception.getMessage());
    }

    @Test
    void dijkstra_negativeWeightEdge_shouldThrowIllegalArgumentException() {
        final Graph<String> graph = new Graph<>(true, true);
        final Vertex<String> a = graph.addVertex("A");
        final Vertex<String> b = graph.addVertex("B");
        graph.addEdge(a, b, -1);

        final Dijkstra<String> dijkstra = new Dijkstra<>();

        final IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> dijkstra.dijkstra(graph, a)
        );

        assertEquals("Dijkstra does not support negative weights", exception.getMessage());
    }

    @Test
    void shortestPathBetween_negativeWeightEdge_shouldThrowIllegalArgumentException() {
        final Graph<String> graph = new Graph<>(true, true);
        final Vertex<String> a = graph.addVertex("A");
        final Vertex<String> b = graph.addVertex("B");
        graph.addEdge(a, b, -5);

        final Dijkstra<String> dijkstra = new Dijkstra<>();

        final IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> dijkstra.shortestPathBetween(graph, a, b)
        );

        assertEquals("Dijkstra does not support negative weights", exception.getMessage());
    }

    private List<String> toDataList(final List<Vertex<String>> vertices) {
        final List<String> data = new ArrayList<>();
        for (final Vertex<String> vertex : vertices) {
            data.add(vertex.getData());
        }
        return data;
    }
}
