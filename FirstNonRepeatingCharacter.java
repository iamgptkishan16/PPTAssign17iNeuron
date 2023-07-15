/*
<aside>
💡 **Question 1**

Given a string `s`, *find the first non-repeating character in it and return its index*. If it does not exist, return `-1`.

**Example 1:**

Input: s = "leetcode"
Output: 0

*/

package Java_DSA.Queues.Assingment17;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String s = "leetcode";
        int index = findFirstNonRepeatingCharIndex(s);
        System.out.println("Index of the first non-repeating character: " + index);
    }
    
    public static int findFirstNonRepeatingCharIndex(String s) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        
        // Count the occurrences of each character in the string
        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        
        // Find the first non-repeating character and return its index
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charCountMap.get(c) == 1) {
                return i;
            }
        }
        
        return -1; // No non-repeating character found
    }
}
