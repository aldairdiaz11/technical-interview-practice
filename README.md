# Technical Interview Practice

A **Java-based technical interview preparation repository** focused on implementing core data structures, algorithms,
and solving common coding interview problems with clean, test-driven code.

The goal of this repository is to function as both:

* a **learning knowledge base**
* a **systematic coding interview preparation toolkit**

---

# Tech Stack

* Java 25
* Maven
* JUnit 5

---

# Features

* Hand-built implementations of core **data structures**
* Classic **algorithm implementations**
* Structured **coding interview problems**
* Unit tests for every component
* Conceptual learning notes in `/docs`

---

# Project Structure

```text
src/main/java/com/iasdiaz/interviewprep

algorithms
 ├ graph
 ├ recursion
 ├ search
 └ sort

datastructures
 ├ linear
 │   ├ LinkedList
 │   ├ DoublyLinkedList
 │   ├ Stack
 │   └ Queue
 │
 └ nonlinear
     ├ graphs
     ├ hash
     └ trees

problems
 └ interview-style coding challenges
```

Tests mirror the same structure:

```
src/test/java/com/iasdiaz/interviewprep
```

---

# Implemented Data Structures

* Linked List
* Doubly Linked List
* Stack
* Queue
* Hash Map (chaining)
* Binary Search Tree
* Heap (MinHeap)
* Graph

---

# Implemented Algorithms

* Binary Search
* Bubble Sort
* Merge Sort
* Quick Sort
* Recursion fundamentals
* Graph traversal (DFS / BFS)
* Dijkstra shortest path

---

# Problem Solving

Current:

* FizzBuzz

Planned problem categories:

* Arrays
* Two Pointers
* Sliding Window
* Binary Search
* Backtracking
* Graph problems
* Dynamic Programming

---

# Running Tests

Run all tests:

```
mvn test
```

Run a specific test:

```
mvn -Dtest=ClassName test
```

---

# Learning Notes

Algorithm notes:

```
docs/algorithms/
```

Data structure notes:

```
docs/datastructures/
```

Future notes:

```
docs/patterns/
```

---

# Roadmap

* Add complexity analysis to all algorithms
* Expand problem-solving section
* Implement advanced algorithms
* Add dynamic programming problems
* Document algorithm patterns

---

# Purpose

This repository is intended as a **long-term technical study reference and interview preparation project**.
