/*
💡 **Question 3**

The school cafeteria offers circular and square sandwiches at lunch break, referred to by numbers `0` and `1` respectively. All students stand in a queue. Each student either prefers square or circular sandwiches.

The number of sandwiches in the cafeteria is equal to the number of students. The sandwiches are placed in a **stack**. At each step:

- If the student at the front of the queue **prefers** the sandwich on the top of the stack, they will **take it** and leave the queue.
- Otherwise, they will **leave it** and go to the queue's end.

This continues until none of the queue students want to take the top sandwich and are thus unable to eat.

You are given two integer arrays `students` and `sandwiches` where `sandwiches[i]` is the type of the `ith` sandwich in the stack (`i = 0` is the top of the stack) and `students[j]` is the preference of the `jth` student in the initial queue (`j = 0` is the front of the queue). Return *the number of students that are unable to eat.*

**Example 1:**
Input: students = [1,1,0,0], sandwiches = [0,1,0,1]
Output: 0
Explanation:
- Front student leaves the top sandwich and returns to the end of the line making students = [1,0,0,1].
- Front student leaves the top sandwich and returns to the end of the line making students = [0,0,1,1].
- Front student takes the top sandwich and leaves the line making students = [0,1,1] and sandwiches = [1,0,1].
- Front student leaves the top sandwich and returns to the end of the line making students = [1,1,0].
- Front student takes the top sandwich and leaves the line making students = [1,0] and sandwiches = [0,1].
- Front student leaves the top sandwich and returns to the end of the line making students = [0,1].
- Front student takes the top sandwich and leaves the line making students = [1] and sandwiches = [1].
- Front student takes the top sandwich and leaves the line making students = [] and sandwiches = [].
Hence all students are able to eat.


*/

package Java_DSA.Queues.Assingment17;

import java.util.*;

public class StudentsAndSandwiches {
    public static void main(String[] args) {
        int[] students = {1,1,0,0};
        int[] sandwiches = {0,1,0,1};
        int unableToEat = countStudents(students, sandwiches);
        System.out.println("Number of students unable to eat: " + unableToEat);
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        Queue<Integer> studentQueue = new LinkedList<>();
        Stack<Integer> sandwichStack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            studentQueue.add(students[i]);
            sandwichStack.push(sandwiches[i]);
        }

        int unableToEat = 0;
        int count = 0;

        while (!studentQueue.isEmpty() && count < n) {
            int student = studentQueue.poll();
            int sandwich = sandwichStack.pop();

            if (student == sandwich) {
                count = 0; // Reset count since student got preferred sandwich
            } else {
                studentQueue.add(student); // Student unable to eat, go to the end of the queue
                count++; // Increase count of students unable to eat
            }
        }

        unableToEat = studentQueue.size(); // Remaining students are unable to eat
        return unableToEat;
    }
}
