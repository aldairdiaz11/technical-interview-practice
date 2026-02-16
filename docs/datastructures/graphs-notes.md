# Graphs and Graph Traversal

Graphs are fundamental data structures used to model relationships between entities. They consist of **vertices (nodes)
** and **edges (connections)**. Graph traversal refers to the process of visiting vertices in a systematic way to
search, analyze, or extract information from the graph.

Graph traversal algorithms are foundational in computer science and appear frequently in **interviews, networking,
routing, AI, and systems design**.

In this section, we focus on three core traversal/search algorithms:

- **Depth-First Search (DFS)**
- **Breadth-First Search (BFS)**
- **Dijkstra’s Algorithm**

---

## Graph Basics (Quick Recap)

### Types of Graphs

- **Directed vs Undirected**
- **Weighted vs Unweighted**
- **Cyclic vs Acyclic**
- **Connected vs Disconnected**

### Common Representations

- **Adjacency List** (most common, space-efficient)
- **Adjacency Matrix** (fast edge lookup, higher space cost)

---

## Depth-First Search (DFS)

### Concept

Depth-First Search explores a graph by **going as deep as possible along one path before backtracking**. It prioritizes
depth over breadth.

### How It Works

1. Start at a source vertex
2. Visit an unvisited neighbor
3. Continue until no unvisited neighbors remain
4. Backtrack and explore alternative paths

DFS can be implemented using:

- **Recursion (implicit call stack)**
- **Explicit stack (iterative)**

---

### Characteristics

- Traverses deeply before exploring siblings
- Does **not guarantee shortest path**
- Efficient for exhaustive searches

---

### Time & Space Complexity

- **Time:** `O(V + E)`
- **Space:** `O(V)` (stack or recursion)

Where:

- `V` = number of vertices
- `E` = number of edges

---

### Common Applications

- Path existence checks
- Cycle detection
- Topological sorting
- Solving puzzles with a single valid solution (e.g., Sudoku, mazes)
- Strongly connected components

---

### Strengths & Weaknesses

**Pros**

- Simple implementation
- Low memory overhead compared to BFS
- Good for deep exploration problems

**Cons**

- Can get stuck exploring deep but irrelevant paths
- Not optimal for shortest path problems

---

## Breadth-First Search (BFS)

### Concept

Breadth-First Search explores a graph **level by level**, visiting all neighboring vertices before moving deeper.

### How It Works

1. Start at a source vertex
2. Visit all immediate neighbors
3. Move to neighbors of neighbors
4. Continue until all reachable vertices are visited

BFS uses a **queue** to manage traversal order.

---

### Characteristics

- Explores evenly across levels
- **Guarantees shortest path** in unweighted graphs
- More memory-intensive than DFS

---

### Time & Space Complexity

- **Time:** `O(V + E)`
- **Space:** `O(V)` (queue + visited set)

---

### Common Applications

- Shortest path in unweighted graphs
- Navigation and routing (e.g., maps)
- Network broadcasting
- Peer-to-peer systems
- Web crawlers

---

### Strengths & Weaknesses

**Pros**

- Finds shortest path (fewest edges)
- Predictable traversal order

**Cons**

- Higher memory usage
- Inefficient if only *any* path is needed

---

## DFS vs BFS (Quick Comparison)

| Aspect          | DFS                       | BFS                       |
|-----------------|---------------------------|---------------------------|
| Traversal style | Deep first                | Level by level            |
| Data structure  | Stack / recursion         | Queue                     |
| Shortest path   | ❌ No                      | ✅ Yes (unweighted graphs) |
| Memory usage    | Lower                     | Higher                    |
| Typical use     | Exploration, backtracking | Routing, shortest paths   |

---

## Dijkstra’s Algorithm

### Concept

Dijkstra’s algorithm computes the **shortest distance from a single source vertex to all other vertices** in a *
*weighted graph with non-negative edge weights**.

It is essentially:
> **BFS + greedy distance relaxation**

---

### How It Works

1. Initialize distances to infinity (`∞`)
2. Set source distance to `0`
3. Repeatedly:
    - Select the unvisited vertex with the smallest known distance
    - Relax (update) distances to its neighbors
4. Continue until all vertices are processed

Uses a **priority queue (min-heap)** for efficiency.

---

### Key Properties

- Works only with **non-negative weights**
- Guarantees shortest paths
- Greedy algorithm

---

### Time & Space Complexity

| Implementation            | Time Complexity    |
|---------------------------|--------------------|
| Array-based               | `O(V²)`            |
| Min-heap (priority queue) | `O((V + E) log V)` |

- **Space:** `O(V)`

---

### Common Applications

- GPS and navigation systems
- Network routing protocols
- Logistics and supply chains
- Game AI pathfinding
- Traffic optimization

---

### Limitations

- Does not handle negative edge weights
- Slower than BFS for unweighted graphs
- For negative weights, use **Bellman–Ford**

---

## BFS vs Dijkstra’s Algorithm

| Feature        | BFS           | Dijkstra              |
|----------------|---------------|-----------------------|
| Graph type     | Unweighted    | Weighted              |
| Shortest path  | Fewest edges  | Minimum total weight  |
| Data structure | Queue         | Priority queue        |
| Edge weights   | Assumed equal | Non-negative required |

---

## Choosing the Right Algorithm

- **Path existence only?** → DFS
- **Shortest path, unweighted graph?** → BFS
- **Shortest path, weighted graph?** → Dijkstra
- **Negative weights?** → Bellman–Ford
- **All-pairs shortest paths?** → Floyd–Warshall

---

## Takeaways

> DFS explores deeply, BFS explores broadly, and Dijkstra optimizes distance.  
> The choice depends on **graph type**, **edge weights**, and **problem constraints**.
