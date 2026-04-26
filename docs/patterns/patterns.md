# Problem Classification Framework

Before jumping into coding, classify the problem:

1. **Input type**
    - Array / string → likely linear patterns
    - Tree / graph → DFS, BFS
    - Matrix → graph or DFS/BFS

2. **Goal**
    - Find pair → Two Pointers / Hash Map
    - Contiguous segment → Sliding Window
    - Optimal value → DP / Greedy
    - All combinations → Backtracking

3. **Constraints**
    - `O(n^2)` too slow? → optimize (Two Pointers, Binary Search)
    - Small constraints? → brute force may pass

4. **Key signals**
    - "Sorted" → Binary Search / Two Pointers
    - "Shortest path" → BFS
    - "All possibilities" → Backtracking
    - "Reuse subproblems" → DP

# Problem Patterns

Problem-solving patterns help you recognize that different interview questions often reuse the same underlying idea.
Instead of memorizing solutions, focus on identifying the pattern, the data structure it needs, and the conditions that
make it a good fit.

---

# Linear

Linear patterns usually process arrays, strings, or linked lists in a mostly sequential way.

## Two Pointers

Two pointers use two indices to scan a sequence while maintaining some relationship between them. This pattern is common
when the input is sorted, when you need to compare pairs, or when you want to shrink a search space without checking
every combination.

**Good signals:**

- Sorted array or string
- Find a pair or compare elements from both ends
- Remove duplicates or move elements in-place
- Need `O(n)` instead of `O(n^2)`

### Same direction

Both pointers move from left to right, but one pointer usually advances faster than the other. This is useful for
compaction, deduplication, partitioning, or tracking a valid region.

**Typical use cases:**

- Remove duplicates from sorted array
- Move zeros to the end
- Partition positives and negatives
- Merge-like scans

**Tip:** One pointer often represents the "next write position" while the other represents the "current read
position".

**Common mistake:** Forgetting whether the slow pointer points to the last valid element or the next slot to write.

**Example: remove duplicates from a sorted array**

```python
def remove_duplicates(nums):
    if not nums:
        return 0

    write = 1
    for read in range(1, len(nums)):
        if nums[read] != nums[read - 1]:
            nums[write] = nums[read]
            write += 1

    return write
```

**Complexity:**

- Time: `O(n)`
- Space: `O(1)`

### Opposite direction

One pointer starts at the left, the other at the right. This works especially well when the array is sorted and the
decision to move a pointer can be made from the current values.

**Typical use cases:**

- Two sum in a sorted array
- Check if a string is a palindrome
- Container with most water
- 3Sum after sorting

**Tip:** Move the pointer that gives you a chance to improve the answer. In sorted-sum problems, move left to increase
the sum and move right to decrease it.

**Common mistake:** Using this on unsorted data without first sorting, when the ordering is required for the logic.

**Example: two sum in a sorted array**

```python
def two_sum_sorted(nums, target):
    left = 0
    right = len(nums) - 1

    while left < right:
        total = nums[left] + nums[right]
        if total == target:
            return [left, right]
        if total < target:
            left += 1
        else:
            right -= 1

    return [-1, -1]
```

**Complexity:**

- Time: `O(n)`
- Space: `O(1)`

## Sliding Window

Sliding window is used when you need information about a contiguous subarray or substring. Instead of recomputing from
scratch for every range, you expand and shrink a window while maintaining the needed state.

**Good signals:**

- Longest, shortest, or count of a contiguous segment
- Subarray or substring language
- Constraint on sum, frequency, distinct characters, or window size
- You can update the answer incrementally as the window moves

**Two common forms:**

- Fixed-size window: window length never changes
- Variable-size window: expand until invalid, then shrink until valid

**Tip:** The key is not the two pointers themselves, but the state inside the window: sum, counts, max frequency,
distinct elements, and so on.

**Common mistakes:**

- Updating the answer before the window becomes valid
- Forgetting to shrink in a loop for variable-size windows
- Losing track of what condition defines a valid window

**Example: longest substring without repeating characters**

```python
def length_of_longest_substring(s):
    seen = {}
    left = 0
    best = 0

    for right, ch in enumerate(s):
        if ch in seen and seen[ch] >= left:
            left = seen[ch] + 1

        seen[ch] = right
        best = max(best, right - left + 1)

    return best
```

**Complexity:**

- Time: `O(n)`
- Space: `O(k)`, where `k` is the number of tracked distinct elements

## Binary Search

Binary search is not just for finding a target in a sorted array. More generally, it applies when the answer space is
ordered and you can check whether a candidate answer is too small, valid, or too large.

**Good signals:**

- Sorted input
- Need faster than linear search
- "Find first", "find last", "smallest valid", "largest possible"
- A monotonic condition exists

**Important idea:** Binary search works on a monotonic property. Once a condition becomes true, it stays true, or once
it becomes false, it stays false.

**Common variations:**

- Find exact target
- Find insertion point
- First/last occurrence
- Search answer space, not array positions

**Tip:** Decide whether your interval is closed `[left, right]` or half-open `[left, right)`, and stay consistent.

**Common mistake:** Off-by-one errors caused by unclear loop invariants.

**Example: classic binary search**

```python
def binary_search(nums, target):
    left = 0
    right = len(nums) - 1

    while left <= right:
        mid = left + (right - left) // 2

        if nums[mid] == target:
            return mid
        if nums[mid] < target:
            left = mid + 1
        else:
            right = mid - 1

    return -1
```

**Complexity:**

- Time: `O(log n)`
- Space: `O(1)`

## Prefix Sum

Prefix sum precomputes cumulative totals so that any range sum query can be answered in `O(1)` after `O(n)`
preprocessing. It is one of the most underrated patterns at big tech interviews.

**Good signals:**

- Range sum queries on a static array
- Count subarrays with a given sum
- 2D grid sum queries
- "Sum between index i and j"

**Core idea:** Build an array `prefix` where `prefix[i]` is the sum of all elements from index `0` to `i - 1`.
Then `sum(i, j) = prefix[j + 1] - prefix[i]`.

**Tip:** When counting subarrays with a target sum, combine prefix sums with a hash map to track how many times
each prefix sum has appeared. This turns an `O(n^2)` scan into `O(n)`.

**Common mistake:** Off-by-one errors in the prefix array indexing. Using a 1-indexed prefix array (length `n + 1`)
avoids most of them.

**Example: range sum queries**

```python
def build_prefix(nums):
    prefix = [0] * (len(nums) + 1)
    for i, val in enumerate(nums):
        prefix[i + 1] = prefix[i] + val
    return prefix

def range_sum(prefix, left, right):
    # sum of nums[left..right] inclusive
    return prefix[right + 1] - prefix[left]
```

**Example: count subarrays with sum equal to k**

```python
def subarray_sum(nums, k):
    count = 0
    running = 0
    seen = {0: 1}  # prefix sum -> frequency

    for num in nums:
        running += num
        count += seen.get(running - k, 0)
        seen[running] = seen.get(running, 0) + 1

    return count
```

**Complexity:**

- Time: `O(n)` build, `O(1)` per query
- Space: `O(n)`

## Monotonic Stack

A monotonic stack maintains elements in strictly increasing or decreasing order. Whenever a new element violates
the order, you pop until the invariant is restored. This gives you efficient access to the "next greater",
"next smaller", "previous greater", or "previous smaller" element for every position.

**Good signals:**

- "Next greater element" or "next smaller element"
- Largest rectangle in histogram
- Daily temperatures
- Trapping rain water
- Stock span problems

**Two forms:**

- Monotonic increasing stack: pop when current element is smaller → useful for "next smaller"
- Monotonic decreasing stack: pop when current element is larger → useful for "next greater"

**Tip:** When you pop an element, the element that caused the pop is the answer for the popped element.
That relationship is the core of every monotonic stack problem.

**Common mistake:** Confusing which direction (next vs. previous) and which order (increasing vs. decreasing)
you need. Draw a small example first.

**Example: next greater element**

```python
def next_greater(nums):
    result = [-1] * len(nums)
    stack = []  # stores indices, monotonic decreasing by value

    for i, val in enumerate(nums):
        while stack and nums[stack[-1]] < val:
            idx = stack.pop()
            result[idx] = val
        stack.append(i)

    return result
```

**Complexity:**

- Time: `O(n)` — each element is pushed and popped at most once
- Space: `O(n)`

---

# Non-Linear

Non-linear patterns are common when the problem is better modeled as a tree, graph, state space, or a set of decisions.

## Hash Map / Set

Used to store and retrieve information in `O(1)` average time. One of the most frequently used patterns at big tech
interviews — almost every medium problem touches it.

**Good signals:**

- Need fast lookup or membership check
- Duplicate detection
- Complement problems (e.g., Two Sum unsorted)
- Frequency counting
- Grouping elements by a computed key

**Tip:** Trade space for time. When you see `O(n^2)` from nested loops, ask whether a hash map can eliminate the
inner loop.

**Common mistake:** Overusing it when ordering matters — then you may need sorting or a heap instead.

**Example: two sum (unsorted)**

```python
def two_sum(nums, target):
    seen = {}  # value -> index

    for i, num in enumerate(nums):
        complement = target - num
        if complement in seen:
            return [seen[complement], i]
        seen[num] = i

    return []
```

**Example: group anagrams**

```python
from collections import defaultdict

def group_anagrams(strs):
    groups = defaultdict(list)

    for s in strs:
        key = tuple(sorted(s))  # canonical form
        groups[key].append(s)

    return list(groups.values())
```

**Complexity:**

- Time: `O(n)` for two sum; `O(n * k log k)` for group anagrams where `k` is average string length
- Space: `O(n)`

## Union-Find (Disjoint Set)

Union-Find tracks which elements belong to the same connected component. With path compression and union by rank,
nearly every operation runs in amortized `O(α(n))` time — effectively constant.

**Good signals:**

- Connectivity or "same group" queries
- Cycle detection in undirected graphs
- Number of connected components
- Grouping problems where merging happens incrementally

**Tip:** Union-Find is often faster and simpler than BFS/DFS when you only need to answer "are these two nodes
connected?" and don't need the actual path.

**Common mistake:** Forgetting to apply path compression, which degrades performance to `O(log n)` per operation.

**Example: Union-Find with path compression and union by rank**

```python
class UnionFind:
    def __init__(self, n):
        self.parent = list(range(n))
        self.rank = [0] * n

    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])  # path compression
        return self.parent[x]

    def union(self, x, y):
        rx, ry = self.find(x), self.find(y)
        if rx == ry:
            return False  # already connected
        # union by rank
        if self.rank[rx] < self.rank[ry]:
            rx, ry = ry, rx
        self.parent[ry] = rx
        if self.rank[rx] == self.rank[ry]:
            self.rank[rx] += 1
        return True

    def connected(self, x, y):
        return self.find(x) == self.find(y)
```

**Complexity:**

- Time: `O(α(n))` per operation — amortized nearly `O(1)`
- Space: `O(n)`

## Linked List

Linked list problems frequently appear at big tech interviews. Most of them reduce to a small set of techniques:
fast/slow pointers, reversal, and dummy nodes.

**Good signals:**

- Cycle detection
- Finding the middle of a list
- Merging or reversing lists
- Removing the nth node from the end

### Fast / Slow Pointers (Floyd's Algorithm)

Move one pointer one step at a time and another two steps at a time. Their relative speeds create useful
meeting conditions.

**Typical use cases:**

- Detect a cycle
- Find the start of a cycle
- Find the middle node
- Check if a linked list is a palindrome

**Tip:** When finding the middle, if the list has even length, `slow` lands on the first of the two middle nodes.
Adjust by one step if you need the second.

**Common mistake:** Not handling the `None` check for `fast` and `fast.next` before advancing — this crashes on
lists with even length or no cycle.

**Example: detect cycle**

```python
def has_cycle(head):
    slow = head
    fast = head

    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
        if slow is fast:
            return True

    return False
```

**Example: find middle node**

```python
def find_middle(head):
    slow = head
    fast = head

    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next

    return slow
```

**Complexity:**

- Time: `O(n)`
- Space: `O(1)`

### In-place reversal

Reverse a linked list (or a portion of it) without extra space by relinking nodes as you traverse.

**Example: reverse a linked list**

```python
def reverse_list(head):
    prev = None
    curr = head

    while curr:
        nxt = curr.next
        curr.next = prev
        prev = curr
        curr = nxt

    return prev
```

**Complexity:**

- Time: `O(n)`
- Space: `O(1)`

## Breadth-First Search

Breadth-First Search (BFS) explores level by level. It is the right choice when you need the shortest path in an
unweighted graph or want to process nodes in order of distance from a source.

**Good signals:**

- Minimum number of moves, edges, or steps
- Level-order traversal
- Unweighted graph
- "Nearest" or "fewest transformations"

**Core data structure:** Queue

**Tip:** Mark nodes as visited when you enqueue them, not when you dequeue them. That avoids adding duplicates.

**Common mistake:** Using BFS on weighted graphs where edge costs differ. That usually needs Dijkstra instead.

**Example: shortest path in an unweighted graph**

```python
from collections import deque


def shortest_path(graph, start, target):
    queue = deque([(start, 0)])
    visited = {start}

    while queue:
        node, distance = queue.popleft()
        if node == target:
            return distance

        for neighbor in graph[node]:
            if neighbor not in visited:
                visited.add(neighbor)
                queue.append((neighbor, distance + 1))

    return -1
```

**Complexity:**

- Time: `O(V + E)`
- Space: `O(V)`

## Depth-First Search

Depth-First Search (DFS) explores as far as possible before backtracking. It is useful for traversing trees and graphs,
checking connectivity, detecting cycles, and exploring all possibilities in a structure.

**Good signals:**

- Traverse entire tree or graph
- Need recursive structure
- Explore connected components
- Need subtree information

**Core data structure:** Recursion stack or explicit stack

**Tip:** In trees, DFS is often simpler than BFS because recursive code maps naturally to left/right or parent/child
relationships.

**Common mistake:** Forgetting a visited set in graphs, which can cause infinite loops on cyclic input.

**Example: DFS traversal of a graph**

```python
def dfs(graph, node, visited):
    if node in visited:
        return

    visited.add(node)

    for neighbor in graph[node]:
        dfs(graph, neighbor, visited)
```

**Complexity:**

- Time: `O(V + E)`
- Space: `O(V)`

## Backtracking

Backtracking explores candidates incrementally, abandoning a path as soon as it becomes invalid or cannot lead to a
solution. It is a DFS over a decision tree.

**Good signals:**

- Generate all combinations, permutations, or subsets
- Need every valid arrangement
- Constraint satisfaction problems
- The phrase "try all possibilities", but with pruning

**Core idea:** Choose → explore → undo

**Tip:** Backtracking becomes much more effective when you prune early. The earlier you reject invalid states, the
faster the search.

**Common mistake:** Mutating shared state without undoing it before returning to the previous call.

**Example: generate all subsets**

```python
def subsets(nums):
    result = []
    path = []

    def backtrack(index):
        result.append(path[:])

        for i in range(index, len(nums)):
            path.append(nums[i])
            backtrack(i + 1)
            path.pop()

    backtrack(0)
    return result
```

**Complexity:**

- Time: Often exponential, depending on the number of valid states
- Space: `O(n)` recursion depth, not counting output

## Priority Queue

A priority queue is useful when you repeatedly need the smallest or largest item while new items are still being added.
It is often implemented with a heap.

**Good signals:**

- Repeatedly extract minimum or maximum
- Top `k` elements
- Process items by priority
- Graph shortest path variants

**Typical use cases:**

- K closest points
- Merge `k` sorted lists
- Dijkstra's algorithm
- Task scheduling

**Tip:** In Python, `heapq` is a min-heap. To simulate a max-heap, push negative values.

**Common mistake:** Sorting once when the set of candidates changes over time. A heap is better when inserts and
extracts are interleaved.

**Example: find the k largest elements**

```python
import heapq


def k_largest(nums, k):
    heap = []

    for num in nums:
        heapq.heappush(heap, num)
        if len(heap) > k:
            heapq.heappop(heap)

    return sorted(heap, reverse=True)
```

**Complexity:**

- Time: `O(n log k)`
- Space: `O(k)`

## Dynamic Programming

Dynamic Programming (DP) is used when a problem has overlapping subproblems and optimal substructure. Instead of solving
the same smaller problem many times, store the answer and reuse it.

**Good signals:**

- Count ways, maximize/minimize value, or determine possibility
- Recursive solution repeats the same inputs
- Choice at each step affects the rest of the problem
- Problem can be broken into smaller states

**Common DP patterns:**

- 1D DP (climbing stairs, house robber)
- 2D DP (grid problems, edit distance)
- Knapsack (0/1 and unbounded)
- Longest subsequence problems (LCS, LIS)

**Two main styles:**

- Top-down: recursion + memoization
- Bottom-up: iterative table building

**How to think about DP:**

1. Define the state — what does `dp[i]` represent?
2. Write the recurrence — how does `dp[i]` depend on smaller states?
3. Decide base cases
4. Choose memoization or tabulation

**Optimization tip:** Reduce space from `O(n)` to `O(1)` when only the previous one or two states are needed.

**Tip:** Most DP mistakes come from a bad state definition. If the state does not capture everything needed to make the
next decision, the recurrence will be wrong.

**Common mistake:** Jumping straight into a table without first writing the recursive relation in plain language.

**Example: climbing stairs**

```python
def climb_stairs(n):
    if n <= 2:
        return n

    prev2 = 1
    prev1 = 2

    for _ in range(3, n + 1):
        prev2, prev1 = prev1, prev1 + prev2

    return prev1
```

**Complexity:**

- Time: Usually depends on number of states times transitions per state
- Space: Often reducible after identifying which previous states are actually needed

---

## Greedy

Make the locally optimal choice at each step. Greedy works when a local decision never needs to be revisited —
meaning the optimal substructure holds without needing to explore all possibilities.

**Good signals:**

- Maximize or minimize a value with a clear ordering
- Interval problems (scheduling, merging)
- No dependency between future and past choices
- Sorting the input unlocks a greedy strategy

**Typical use cases:**

- Interval scheduling / merge intervals
- Jump Game
- Activity selection
- Assign cookies / task scheduling

**How to verify greedy is safe:** Ask "if I make this choice now, can it ever hurt me later?" If the answer is no,
greedy is likely correct. If yes, you probably need DP.

**Common mistake:** Using greedy when the problem actually requires DP. A classic trap: coin change with arbitrary
denominations — greedy fails, DP is needed.

**Example: interval scheduling (maximum non-overlapping intervals)**

```python
def erase_overlap_intervals(intervals):
    if not intervals:
        return 0

    # sort by end time — finish early, leave room for more
    intervals.sort(key=lambda x: x[1])

    count = 0
    last_end = intervals[0][1]

    for start, end in intervals[1:]:
        if start < last_end:
            count += 1  # overlap — remove this interval
        else:
            last_end = end  # no overlap — keep it, update boundary

    return count
```

**Complexity:**

- Time: `O(n log n)` for sorting
- Space: `O(1)`

---

## Invariants (Key for Interviews)

An invariant is a condition that remains true throughout execution.

Examples:

- Sliding Window: window always satisfies the constraint
- Binary Search: target is always within `[left, right]`
- Two Pointers: elements before `write` are valid
- Monotonic Stack: stack is always sorted by value

**Tip:** State your invariant out loud before coding. It shows structured thinking and makes bugs easier to catch.

## Common Edge Cases

Always check:

- Empty input
- Single element
- All elements the same
- Large input size (overflow, TLE)
- Negative numbers
- Duplicates
- Already sorted / reverse sorted
- Disconnected graph (for BFS/DFS)
- Cycle in linked list or graph

**Interview tip:** Mention at least 2 edge cases before coding. It signals thoroughness without slowing you down.

---

# Interview Communication Strategy

Big tech interviews evaluate how you think, not just whether you get the right answer. Use this structure every time.

## The Framework

**1. Clarify before you code**

Ask about input constraints, edge cases, and expected output format. Example questions:
- "Can the array be empty?"
- "Are there duplicate values?"
- "Should I return indices or values?"
- "What's the expected time complexity?"

**2. Restate the problem**

Paraphrase in your own words: *"So I need to find the two indices that sum to the target, and I can assume exactly
one solution exists — is that right?"* This confirms understanding and buys thinking time.

**3. Identify the pattern out loud**

Say what you recognize: *"This looks like a sliding window problem because we're looking for a contiguous subarray
with a constraint."* Interviewers want to see pattern recognition, not just code.

**4. Start with brute force**

Always mention the naive solution first, even if you won't code it:
*"The brute force would be O(n²) with nested loops. I can do better with a hash map."*
This shows you understand the problem space and sets up your optimization.

**5. Optimize step by step**

Walk through your improvement: *"Instead of scanning for the complement each time, I'll store values I've seen in
a hash map so each lookup is O(1)."* Don't just jump to the optimal solution silently.

**6. State complexity before and after coding**

Announce time and space complexity for both your brute force and optimized solution. Be specific:
*"This is O(n) time and O(n) space because we store at most n entries in the map."*

**7. Code with narration**

Talk while you write. Name variables clearly. If you pause to think, say so:
*"I'm going to use a left pointer here to track the start of the valid window..."*

**8. Test with a concrete example**

Trace through your code manually with a small input before declaring it done. Use the example from the problem,
then try an edge case.

**9. Mention edge cases explicitly**

After testing the happy path, say: *"I should also check what happens with an empty array — in this case the loop
never runs and we return 0, which is correct."*

## FAANG-Specific Tips

- **Silence is the enemy.** Interviewers at big tech companies are trained to evaluate communication. A wrong answer
  explained clearly often scores better than a correct answer written in silence.
- **Don't optimize prematurely.** Get a working solution first, then improve it. Jumping to the optimal solution
  and getting stuck looks worse than a clean brute force.
- **Name your pattern.** Saying "I'll use a monotonic stack here" signals experience. It also helps the interviewer
  follow your reasoning.
- **Ask about trade-offs.** If there are multiple valid approaches, briefly mention them:
  *"I could use a heap for O(n log k) or sort for O(n log n) — since k is small, the heap is better here."*
- **Recover gracefully.** If you get stuck, say: *"Let me step back and think about what information I need at each
  step."* Interviewers can give hints if you ask — but only if you're communicating.
- **Write clean code.** Use meaningful variable names. Avoid single-letter names except for standard loop indices.
  Big tech interviewers read a lot of code and notice quality.

## Quick Reference Checklist

Before submitting your solution, verify:

- [ ] Clarified constraints and edge cases
- [ ] Stated brute force and its complexity
- [ ] Explained the optimization and why it works
- [ ] Coded with narration
- [ ] Traced through at least one example
- [ ] Checked at least two edge cases
- [ ] Stated final time and space complexity
