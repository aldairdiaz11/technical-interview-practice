package com.iasdiaz.interviewprep.datastructures.nonlinear.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class EdgeTest {

    @Test
    void constructor_shouldStoreStartEndAndWeight() {
        final Vertex<String> start = new Vertex<>("A");
        final Vertex<String> end = new Vertex<>("B");

        final Edge<String> edge = new Edge<>(start, end, 10);

        assertSame(start, edge.getStart());
        assertSame(end, edge.getEnd());
        assertEquals(10, edge.getWeight());
    }

    @Test
    void constructor_shouldAllowNullWeight() {
        final Vertex<String> start = new Vertex<>("A");
        final Vertex<String> end = new Vertex<>("B");

        final Edge<String> edge = new Edge<>(start, end, null);

        assertSame(start, edge.getStart());
        assertSame(end, edge.getEnd());
        assertNull(edge.getWeight());
    }
}
