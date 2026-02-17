package com.iasdiaz.interviewprep.datastructures.nonlinear.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class VertexTest {

    @Test
    void constructor_shouldInitializeDataAndEmptyEdges() {
        Vertex<String> vertex = new Vertex<>("A");

        assertEquals("A", vertex.getData());
        assertTrue(vertex.getEdges().isEmpty());
    }

    @Test
    void addEdge_shouldAppendEdgeWithExpectedValues() {
        Vertex<String> source = new Vertex<>("A");
        Vertex<String> target = new Vertex<>("B");

        source.addEdge(target, 5);

        assertEquals(1, source.getEdges().size());
        Edge<String> edge = source.getEdges().getFirst();
        assertSame(source, edge.getStart());
        assertSame(target, edge.getEnd());
        assertEquals(5, edge.getWeight());
    }

    @Test
    void removeEdge_shouldRemoveAllEdgesToMatchingTargetOnly() {
        Vertex<String> source = new Vertex<>("A");
        Vertex<String> targetB = new Vertex<>("B");
        Vertex<String> targetC = new Vertex<>("C");

        source.addEdge(targetB, 1);
        source.addEdge(targetB, 2);
        source.addEdge(targetC, 3);

        source.removeEdge(targetB);

        assertEquals(1, source.getEdges().size());
        assertSame(targetC, source.getEdges().getFirst().getEnd());
    }
}
