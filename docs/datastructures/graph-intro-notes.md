# Introduction to Graphs

Graphs are a fundamental data structure used to model **relationships** between entities. They appear across many
domains in computer science, including **networks, databases, operating systems, compilers, artificial intelligence, and
social networks**.

At a high level, a graph represents how things are **connected** rather than how they are **stored sequentially**.

---

## Basic Terminology

A graph is defined as **G = (V, E)** where:

- **V (Vertices / Nodes):** The entities or objects in the graph
- **E (Edges):** The connections between vertices

### Example
    
- Vertices: cities
- Edges: roads connecting the cities

---

## Why Graphs Matter

Graphs are ideal for modeling:

- Social networks (users and friendships)
- Web pages and hyperlinks
- Maps and navigation systems
- Dependency graphs (build systems, package managers)
- Communication networks

Many real-world problems reduce to **graph traversal or optimization problems**.

---

## Graph Connectivity

### Connected vs Disconnected Graphs

Graphs vary in how connected their vertices are.

- A graph is **connected** if there exists **at least one path between every pair of vertices**
- A graph is **disconnected** if **no path exists between some vertices**

Example:

- A road map where some cities are isolated → disconnected graph

---

### Degree of Connectivity

The **degree of connectivity** depends on the ratio of edges to vertices:

- **Sparse graph**: Few edges compared to vertices
- **Dense graph**: Many edges relative to vertices

📌 As the number of edges increases, the graph becomes more connected.

---

### Vertex Degree

- **Degree (undirected graph):** Number of edges connected to a vertex
- **In-degree (directed graph):** Number of incoming edges
- **Out-degree (directed graph):** Number of outgoing edges

---

## Types of Graphs

### Undirected Graphs

In an undirected graph:

- Edges have **no direction**
- Connection is **bidirectional**

Example:

A – B

If A is connected to B, then B is connected to A.

Common uses:

- Social networks
- Undirected maps

---

## Directed Graphs (Digraphs)

In a directed graph:

- Edges have a **direction**
- Connections are **one-way**

Example:

A → B

This means you can go from A to B, but not necessarily from B to A.

Common uses:

- Web page links
- Task scheduling
- Dependency resolution
- Control flow graphs

---

## Weighted Graphs

In a weighted graph:

- Each edge has an associated **weight**
- The weight represents cost, distance, time, or priority

Example:

A --5--> B

This could represent:

- 5 kilometers
- $5 cost
- 5 minutes of travel time

📌 Weights are essential for optimization problems like **shortest path**.

---

### Unweighted vs Weighted Graphs

| Feature      | Unweighted Graph | Weighted Graph |
|--------------|------------------|----------------|
| Edge values  | Implicit (1)     | Explicit value |
| Path meaning | Fewest edges     | Minimum cost   |
| Algorithms   | BFS              | Dijkstra       |

---

## Cyclic vs Acyclic Graphs

### Cyclic Graph

- Contains at least one cycle
- You can start at a vertex and return to it

### Acyclic Graph

- Contains no cycles
- **DAG (Directed Acyclic Graph)** is especially important

Common DAG applications:

- Build systems
- Version control history
- Scheduling problems
- Topological sorting

---

## Graph Representation in Memory

### Adjacency List (Preferred)

```text
A → B, C
B → A
C → A 
```

* Space-efficient
* Ideal for sparse graphs
* Most commonly used in practice

## Adjacency Matrix

```text
A B C
A  0 1 1
B  1 0 0
C  1 0 0
```

* Fast edge lookup
* Higher space cost (O(V²))
* Useful for dense graphs

## Real-World Graph Examples

| Domain       | Vertices  | Edges                 |
|--------------|-----------|-----------------------|
| Social Media | Users     | Friendships           |
| Internet     | Routers   | Network links         |
| Maps         | Locations | Roads                 |
| OS           | Processes | Resource dependencies |
| AI           | States    | Transitions           |

## Key Takeaways

* Graphs model relationships, not sequences
* Connectivity determines how reachable vertices are
* Directed graphs encode direction and dependency
* Weighted graphs encode cost and optimization
* Choosing the right graph type and representation matters
