# Technical Interview Practice

Java-based interview prep repository with hand-built data structures, algorithm implementations, and unit tests.
It is organized for iterative practice, clear code, and reference notes.

## Goals
- Practice core data structures and algorithms.
- Build clean, tested Java implementations.
- Track learning notes and problem-solving patterns.

## Tech Stack
- Java: 25
- Build tool: Maven
- Test framework: JUnit 5

## Getting Started

### Prerequisites
- JDK 25
- Maven 3.9+

### Clone and Run
```bash
git clone https://github.com/aldairdiaz11/technical-interview-practice
cd technical-interview-practice
mvn clean test
```

### Build
```bash
mvn clean package
```

## Project Structure
```text
src/
  main/java/com/iasdiaz/interviewprep/
    algorithms/
      graph/
      recursion/
      search/
      sort/
    datastructures/
      linear/
      nonlinear/
        hash/
        trees/
        graphs/
    problems/
  test/java/com/iasdiaz/interviewprep/
    algorithms/
      graph/
      recursion/
      search/
      sort/
    datastructures/
      linear/
      nonlinear/
        graphs/
        hash/
        trees/
docs/
  algorithms/
  datastructures/
```

## Implemented Topics

### Data Structures
- [x] Linked List
- [x] Doubly Linked List
- [x] Stack
- [x] Queue
- [x] Hash Map
- [x] Trees (BST, Heap, etc.)
- [x] Graphs

### Algorithms
- [x] Binary Search
- [x] Bubble Sort
- [x] Merge Sort
- [x] Quick Sort
- [x] Recursion fundamentals
- [x] Graph traversal (DFS, BFS)

### Problems
- [x] FizzBuzz
- [ ] <!-- Add more -->

## Testing
Run all tests:
```bash
mvn test
```

Run a specific test class:
```bash
mvn -Dtest=ClassName test
```

## Coding Conventions
- Keep implementations readable first, then optimize.
- Add/update tests with every behavior change.
- Prefer small methods with single responsibility.

## Learning Notes
- Algorithms notes: `docs/algorithms/`
- Data structure notes: `docs/datastructures/`

## Roadmap
- [ ] Add time/space complexity notes to each implementation.
- [ ] Add edge-case focused tests for every structure/algorithm.
- [ ] Add benchmark experiments for selected implementations.
- [x] Reorganize notes into `docs/`.

## Contributing
1. Create a feature branch.
2. Make changes with tests.
3. Run `mvn test`.
4. Open a pull request.
