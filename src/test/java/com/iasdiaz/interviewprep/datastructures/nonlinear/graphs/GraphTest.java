package com.iasdiaz.interviewprep.datastructures.nonlinear.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class GraphTest {

    @Test
    void addVertex_shouldStoreAndReturnVertex() {
        final Graph<String> graph = new Graph<>();

        final Vertex<String> added = graph.addVertex("A");

        assertEquals(1, graph.getVertices().size());
        assertSame(added, graph.getVertices().getFirst());
        assertEquals("A", added.getData());
    }

    @Test
    void getVertexByValue_shouldReturnMatchingVertex() {
        final Graph<String> graph = new Graph<>();
        final Vertex<String> a = graph.addVertex("A");
        graph.addVertex("B");

        final Vertex<String> result = graph.getVertexByValue("A");

        assertSame(a, result);
    }

    @Test
    void getVertexByValue_missingValue_shouldReturnNull() {
        final Graph<String> graph = new Graph<>();
        graph.addVertex("A");

        assertNull(graph.getVertexByValue("Z"));
    }

    @Test
    void addEdge_unweightedUndirected_shouldCreateTwoEdgesWithNullWeight() {
        final Graph<String> graph = new Graph<>();
        final Vertex<String> a = graph.addVertex("A");
        final Vertex<String> b = graph.addVertex("B");

        graph.addEdge(a, b, 99);

        assertEquals(1, a.getEdges().size());
        assertEquals(1, b.getEdges().size());
        assertSame(b, a.getEdges().getFirst().getEnd());
        assertSame(a, b.getEdges().getFirst().getEnd());
        assertNull(a.getEdges().getFirst().getWeight());
        assertNull(b.getEdges().getFirst().getWeight());
    }

    @Test
    void addEdge_weightedDirected_shouldCreateSingleEdgeWithWeight() {
        final Graph<String> graph = new Graph<>(true, true);
        final Vertex<String> a = graph.addVertex("A");
        final Vertex<String> b = graph.addVertex("B");

        graph.addEdge(a, b, 7);

        assertEquals(1, a.getEdges().size());
        assertEquals(0, b.getEdges().size());
        assertEquals(7, a.getEdges().getFirst().getWeight());
    }

    @Test
    void removeEdge_undirected_shouldRemoveBothDirections() {
        final Graph<String> graph = new Graph<>();
        final Vertex<String> a = graph.addVertex("A");
        final Vertex<String> b = graph.addVertex("B");
        graph.addEdge(a, b, null);

        graph.removeEdge(a, b);

        assertTrue(a.getEdges().isEmpty());
        assertTrue(b.getEdges().isEmpty());
    }

    @Test
    void removeEdge_directed_shouldRemoveOnlySourceToTarget() {
        final Graph<String> graph = new Graph<>(true, true);
        final Vertex<String> a = graph.addVertex("A");
        final Vertex<String> b = graph.addVertex("B");

        graph.addEdge(a, b, 1);
        b.addEdge(a, 2);
        assertFalse(b.getEdges().isEmpty());

        graph.removeEdge(a, b);

        assertTrue(a.getEdges().isEmpty());
        assertEquals(1, b.getEdges().size());
        assertSame(a, b.getEdges().getFirst().getEnd());
    }

    @Test
    void removeVertex_shouldDeleteVertexAndIncomingEdges() {
        final Graph<String> graph = new Graph<>();
        final Vertex<String> a = graph.addVertex("A");
        final Vertex<String> b = graph.addVertex("B");
        final Vertex<String> c = graph.addVertex("C");

        graph.addEdge(a, b, null);
        graph.addEdge(c, b, null);
        assertNotNull(graph.getVertexByValue("B"));

        graph.removeVertex(b);

        assertNull(graph.getVertexByValue("B"));
        assertEquals(2, graph.getVertices().size());
        assertTrue(a.getEdges().isEmpty());
        assertTrue(c.getEdges().isEmpty());
    }
}
