package com.iasdiaz.interviewprep.algorithms.graph;

import com.iasdiaz.interviewprep.datastructures.nonlinear.graphs.Vertex;

public class QueueObject<K> implements Comparable<QueueObject<K>> {
    public Vertex<K> vertex;
    public int priority;

    public QueueObject(Vertex<K> v, int p) {
        this.vertex = v;
        this.priority = p;
    }

    @Override
    public int compareTo(QueueObject o) {
        return Integer.compare(this.priority, o.priority);
    }
}
