package com.iasdiaz.interviewprep.algorithms.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.iasdiaz.interviewprep.datastructures.nonlinear.graphs.Graph;
import com.iasdiaz.interviewprep.datastructures.nonlinear.graphs.Vertex;

class GraphTraverserTest {

    @Test
    void depthFirstTraversal_shouldVisitReachableVerticesInDepthFirstOrder() {
        final Graph<String> graph = new Graph<>(true, true);
        final Vertex<String> a = graph.addVertex("A");
        final Vertex<String> b = graph.addVertex("B");
        final Vertex<String> c = graph.addVertex("C");
        final Vertex<String> d = graph.addVertex("D");
        final Vertex<String> e = graph.addVertex("E");

        graph.addEdge(a, b, 1);
        graph.addEdge(a, c, 1);
        graph.addEdge(b, d, 1);
        graph.addEdge(c, e, 1);

        final GraphTraverser<String> traverser = new GraphTraverser<>();
        final List<Vertex<String>> visited = traverser.depthFirstTraversal(a);

        assertEquals(List.of("A", "B", "D", "C", "E"), toDataList(visited));
    }

    @Test
    void breadthFirstTraversal_shouldVisitReachableVerticesInBreadthFirstOrder() {
        final Graph<String> graph = new Graph<>(true, true);
        final Vertex<String> a = graph.addVertex("A");
        final Vertex<String> b = graph.addVertex("B");
        final Vertex<String> c = graph.addVertex("C");
        final Vertex<String> d = graph.addVertex("D");
        final Vertex<String> e = graph.addVertex("E");

        graph.addEdge(a, b, 1);
        graph.addEdge(a, c, 1);
        graph.addEdge(b, d, 1);
        graph.addEdge(c, e, 1);

        final GraphTraverser<String> traverser = new GraphTraverser<>();
        final List<Vertex<String>> visited = traverser.breadthFirstTraversal(a);

        assertEquals(List.of("A", "B", "C", "D", "E"), toDataList(visited));
    }

    @Test
    void depthFirstTraversal_cycleGraph_shouldVisitEachVertexOnce() {
        final Graph<String> graph = new Graph<>();
        final Vertex<String> a = graph.addVertex("A");
        final Vertex<String> b = graph.addVertex("B");
        final Vertex<String> c = graph.addVertex("C");

        graph.addEdge(a, b, null);
        graph.addEdge(b, c, null);
        graph.addEdge(c, a, null);

        final GraphTraverser<String> traverser = new GraphTraverser<>();
        final List<Vertex<String>> visited = traverser.depthFirstTraversal(a);
        assertEquals(3, visited.size());
        assertTrue(visited.contains(a));
        assertTrue(visited.contains(b));
        assertTrue(visited.contains(c));
    }

    @Test
    void breadthFirstTraversal_disconnectedGraph_shouldVisitOnlyReachableVertices() {
        final Graph<String> graph = new Graph<>(true, true);
        final Vertex<String> a = graph.addVertex("A");
        final Vertex<String> b = graph.addVertex("B");
        final Vertex<String> c = graph.addVertex("C");
        final Vertex<String> d = graph.addVertex("D");
        final Vertex<String> e = graph.addVertex("E");

        graph.addEdge(a, b, 1);
        graph.addEdge(b, d, 1);
        graph.addEdge(c, e, 1);

        final GraphTraverser<String> traverser = new GraphTraverser<>();
        final List<Vertex<String>> visited = traverser.breadthFirstTraversal(a);

        assertEquals(List.of("A", "B", "D"), toDataList(visited));
    }

    private List<String> toDataList(final List<Vertex<String>> vertices) {
        final List<String> data = new ArrayList<>();
        for (final Vertex<String> vertex : vertices) {
            data.add(vertex.getData());
        }
        return data;
    }
}
