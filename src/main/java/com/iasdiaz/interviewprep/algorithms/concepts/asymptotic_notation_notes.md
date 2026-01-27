# Asymptotic Notation — Notes

## 1. What is Asymptotic Notation?

Asymptotic notation is a mathematical way to describe the **time complexity** and **space complexity** of an algorithm
as the input size `n` grows large.

It focuses on:

- Growth rate, not exact running time
- Behavior for large inputs
- Ignoring constants and lower-order terms

## 2. Why Use Asymptotic Analysis?

- Machine-independent
- Language-independent
- Allows fair comparison between algorithms
- Helps predict scalability

## 3. Common Asymptotic Notations

### Big-O (O)

Upper bound (worst-case).

### Big-Omega (Ω)

Lower bound (best-case).

### Big-Theta (Θ)

Tight bound.

### Little-o (o)

Strict upper bound.

### Little-omega (ω)

Strict lower bound.

## 4. Common Time Complexities

| Complexity   | Name         |
|--------------|--------------|
| `O(1)`       | Constant     |
| `O(log n)`   | Logarithmic  |
| `O(n)`       | Linear       |
| `O(n log n)` | Linearithmic |
| `O(n²)`      | Quadratic    |
| `O(n³)`      | Cubic        |
| `O(2ⁿ)`      | Exponential  |
| `O(n!)`      | Factorial    |

**Examples(Big-O) :**

- Linear search → `O(n)`
- Binary search → `O(log n)`
- Bubble sort (worst case) → `O(n²)`

**Use case:** Most commonly used in interviews and design discussions.

## 5. Simplification Rules

- Drop constants
- Drop lower-order terms
- Keep dominant term only

## 6. Time vs Space Complexity

- **Time Complexity:** How runtime grows with input size
- **Space Complexity:** How memory usage grows with input size

Example:

- Recursive Fibonacci:
    - Time: `O(2ⁿ)`
    - Space: `O(n)` (call stack)

## 7. Best, Average, and Worst Case

- **Best case:** Minimum time
- **Average case:** Expected time
- **Worst case:** Maximum time (commonly used)

Example: Linear Search

- Best: `O(1)`
- Average: `O(n)`
- Worst: `O(n)`

## 8. Asymptotic Notation vs Real Performance

- Asymptotic notation does **not** give exact runtime
- Constants matter for small inputs
- Cache, hardware, and implementation still matter
