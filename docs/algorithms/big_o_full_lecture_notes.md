# Big-O Notation — Full Lecture Notes

Great resource: [here](https://adrianmejia.com/how-to-find-time-complexity-of-an-algorithm-code-big-o-notation/)

## 1. Introduction to Big-O

Big-O notation is a mathematical tool used to describe the **worst-case growth rate** of an algorithm’s resource usage (
time or space) as the input size `n` increases.

Key idea:
> Big-O focuses on *how fast an algorithm grows*, not how fast it runs for a specific input.

<img src="https://adrianmejia.com/images/time-complexity-examples.png">
---

## 2. Why Big-O Matters

Big-O allows us to:

- Compare algorithms independently of hardware
- Reason about scalability
- Predict performance for large inputs
- Choose efficient algorithms and data structures

Example:

- `O(n)` will always scale better than `O(n²)` as `n` grows.

---

## 3. What Big-O Ignores

Big-O intentionally ignores:

- Constant factors
- Lower-order terms
- Machine-specific optimizations

Example:

```
T(n) = 3n² + 10n + 500
Big-O → O(n²)
```

---

## 4. Formal Definition

A function `T(n)` is in `O(f(n))` if there exist constants `c > 0` and `n₀` such that:

```
T(n) ≤ c · f(n)   for all n ≥ n₀
```

Interpretation:

- `f(n)` is an asymptotic upper bound
- `T(n)` does not grow faster than `f(n)` beyond some point

---

## 5. Common Big-O Time Complexities

### O(1) — Constant Time

Runtime does not depend on input size.

Examples:

- Accessing an array element
- HashMap get/put (average case)

```
int x = arr[5];
```

---

### O(log n) — Logarithmic Time

Input size is reduced by a constant factor each step.

Examples:

- Binary search
- Balanced BST operations

```
while (low <= high) {
    mid = (low + high) / 2;
}
```

---

### O(n) — Linear Time

Runtime grows proportionally with input size.

Examples:

- Linear search
- Iterating through an array

```
for (int i = 0; i < n; i++) {}
```

---

### O(n log n) — Linearithmic Time

Common in efficient comparison-based algorithms.

Examples:

- Merge sort
- Quick sort (average case)

---

### O(n²) — Quadratic Time

Often caused by nested loops.

Examples:

- Bubble sort
- Selection sort

```
for (int i = 0; i < n; i++)
  for (int j = 0; j < n; j++) {}
```

---

### O(2ⁿ) — Exponential Time

Grows extremely fast; usually infeasible.

Examples:

- Naive recursive Fibonacci
- Brute-force subset generation

---

### O(n!) — Factorial Time

Explores all permutations.

Examples:

- Traveling Salesman (brute force)

---

## 6. Rules for Calculating Big-O

### Rule 1: Drop Constants

```
O(2n) → O(n)
O(1000) → O(1)
```

---

### Rule 2: Drop Lower-Order Terms

```
O(n² + n) → O(n²)
O(n log n + n) → O(n log n)
```

---

### Rule 3: Sequential Statements

Take the dominant term:

```
O(n) + O(n²) → O(n²)
```

---

### Rule 4: Nested Loops

Multiply complexities:

```
O(n) inside O(n) → O(n²)
```

---

### Rule 5: Different Inputs

Use different variables:

```
O(n + m)
```

---

## 7. Big-O and Recursion

### Recursive Example

```
T(n) = T(n - 1) + O(1)
→ O(n)
```

### Divide-and-Conquer

```
T(n) = 2T(n/2) + O(n)
→ O(n log n)
```

---

## 8. Big-O: Best, Average, Worst Case

Big-O usually refers to **worst-case** complexity.

Example (Linear Search):

- Best: O(1)
- Average: O(n)
- Worst: O(n)

---

## 9. Time vs Space Big-O

Big-O can describe:

- Time complexity
- Space complexity

Example:

- Merge Sort:
    - Time: O(n log n)
    - Space: O(n)

---

## 10. Common Mistakes

- Forgetting nested loops
- Ignoring recursion depth
- Assuming HashMap is always O(1)
- Mixing best-case with Big-O
