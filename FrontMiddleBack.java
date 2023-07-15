/*
💡 **Question 7**

Design a queue that supports `push` and `pop` operations in the front, middle, and back.

Implement the `FrontMiddleBack` class:

- `FrontMiddleBack()` Initializes the queue.
- `void pushFront(int val)` Adds `val` to the **front** of the queue.
- `void pushMiddle(int val)` Adds `val` to the **middle** of the queue.
- `void pushBack(int val)` Adds `val` to the **back** of the queue.
- `int popFront()` Removes the **front** element of the queue and returns it. If the queue is empty, return `1`.
- `int popMiddle()` Removes the **middle** element of the queue and returns it. If the queue is empty, return `1`.
- `int popBack()` Removes the **back** element of the queue and returns it. If the queue is empty, return `1`.

**Notice** that when there are **two** middle position choices, the operation is performed on the **frontmost** middle position choice. For example:

- Pushing `6` into the middle of `[1, 2, 3, 4, 5]` results in `[1, 2, 6, 3, 4, 5]`.
- Popping the middle from `[1, 2, 3, 4, 5, 6]` returns `3` and results in `[1, 2, 4, 5, 6]`.

**Example 1:**
Input:
["FrontMiddleBackQueue", "pushFront", "pushBack", "pushMiddle", "pushMiddle", "popFront", "popMiddle", "popMiddle", "popBack", "popFront"]
[[], [1], [2], [3], [4], [], [], [], [], []]
Output:
[null, null, null, null, null, 1, 3, 4, 2, -1]

Explanation:
FrontMiddleBackQueue q = new FrontMiddleBackQueue();
q.pushFront(1);   // [1]
q.pushBack(2);    // [1,2]
q.pushMiddle(3);  // [1,3, 2]
q.pushMiddle(4);  // [1,4, 3, 2]
q.popFront();     // return 1 -> [4, 3, 2]
q.popMiddle();    // return 3 -> [4, 2]
q.popMiddle();    // return 4 -> [2]
q.popBack();      // return 2 -> []
q.popFront();     // return -1 -> [] (The queue is empty)

*/
package Java_DSA.Queues.Assingment17;

import java.util.ArrayDeque;
import java.util.Deque;

public class FrontMiddleBack {
    private Deque<Integer> frontHalf;
    private Deque<Integer> backHalf;

    public FrontMiddleBack() {
        frontHalf = new ArrayDeque<>();
        backHalf = new ArrayDeque<>();
    }

    public void pushFront(int val) {
        frontHalf.addFirst(val);
        balanceQueues();
    }

    public void pushMiddle(int val) {
        if (frontHalf.size() > backHalf.size()) {
            backHalf.addFirst(frontHalf.removeLast());
        }
        frontHalf.addLast(val);
        balanceQueues();
    }

    public void pushBack(int val) {
        backHalf.addLast(val);
        balanceQueues();
    }

    public int popFront() {
        if (frontHalf.isEmpty() && backHalf.isEmpty()) {
            return -1;
        }
        if (frontHalf.isEmpty()) {
            return backHalf.pollFirst();
        }
        int val = frontHalf.pollFirst();
        balanceQueues();
        return val;
    }

    public int popMiddle() {
        if (frontHalf.isEmpty() && backHalf.isEmpty()) {
            return -1;
        }
        if (frontHalf.size() == backHalf.size()) {
            return frontHalf.pollLast();
        }
        return frontHalf.pollFirst();
    }

    public int popBack() {
        if (frontHalf.isEmpty() && backHalf.isEmpty()) {
            return -1;
        }
        if (backHalf.isEmpty()) {
            return frontHalf.pollLast();
        }
        int val = backHalf.pollLast();
        balanceQueues();
        return val;
    }

    private void balanceQueues() {
        if (frontHalf.size() > backHalf.size() + 1) {
            backHalf.addFirst(frontHalf.pollLast());
        } else if (frontHalf.size() < backHalf.size()) {
            frontHalf.addLast(backHalf.pollFirst());
        }
    }
}
