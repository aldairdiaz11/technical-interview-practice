# Sorting Algorithms Notes

## Introduction to Sorting

* Sorting is a fundamental operation in computer science that organizes data in a specific order (e.g., ascending or
  descending).
* Why sort? It enables efficient searching (e.g., binary search requires a sorted dataset and runs in O(log n) time).
* Efficiency matters: We evaluate sorting algorithms based on time complexity (best, worst, average cases) and space
  complexity.
* Key algorithms to know: Bubble Sort, Merge Sort, and Quicksort. Each has trade-offs in speed, stability, and memory
  use.
* Additional note: Other common algorithms include Insertion Sort, Selection Sort, Heap Sort, but we'll focus on these
  three as per the topic.

## Bubble Sort

How it works: Repeatedly iterates through the list, compares adjacent elements, and swaps them if they're in the wrong
order. Like bubbles rising to the top.

* Passes through the array multiple times until no more swaps are needed.
* Optimized version: Can stop early if the array is already sorted (adaptive).

* **Pros**: Simple to implement; in-place sorting (no extra space needed).
* **Cons**: Inefficient for large datasets due to quadratic time complexity.
* **Use cases**: Good for small or nearly sorted lists; educational purposes.
* **Time Complexity**:
    * Best: Ω(n) (already sorted)
    * Worst: O(n²) (reverse sorted)
    * Average: O(n²)

* **Space Complexity**: O(1) (constant space)

## Merge Sort

How it works: Divide-and-conquer approach. Splits the array into halves recursively, sorts each half, then merges them
back in order.

* Stable sort (preserves order of equal elements).
* Often implemented with a helper array for merging.

* **Pros**: Consistent performance across cases; efficient for large datasets; stable.
* **Cons**: Requires extra space; not in-place.
* **Use cases**: External sorting (e.g., large files on disk); when stability is needed (e.g., sorting objects by
  multiple keys).
* **Time Complexity**:
    * Best: Ω(n log n)
    * Worst: O(n log n)
    * Average: O(n log n)

* **Space Complexity**: O(n) (linear space for merging)

## Quicksort

How it works: Divide-and-conquer. Picks a "pivot" element, partitions the array so elements less than pivot are on left,
greater on right. Recursively sorts sub-arrays.

* Pivot selection affects efficiency (e.g., median-of-three to avoid worst case).
* In-place sorting possible.

* **Pros**: Very fast in practice (average case); low space overhead.
* **Cons**: Worst case can be quadratic if pivots are poorly chosen (e.g., already sorted array); not stable by default.
* **Use cases**: General-purpose sorting in libraries (e.g., Python's sorted() often uses a variant); when space is
  limited.
* **Time Complexity**:
    * Best: Ω(n log n)
    * Worst: O(n²) (poor pivots)
    * Average: O(n log n)

* **Space Complexity**: O(log n) (recursive call stack)

### Comparison Table

| Algorithm   | Best Case  | Worst case | Average Case | Space Complexity |
|-------------|------------|------------|--------------|------------------|
| Bubble Sort | Ω(n)       | O(n²)      | O(n²)        | O(1)             |
| Merge Sort  | Ω(n log n) | O(n log n) | O(n log n)   | O(n)             |
| QuickSort   | Ω(n log n) | O(n²)      | O(n log n)   | O(log n)         |

