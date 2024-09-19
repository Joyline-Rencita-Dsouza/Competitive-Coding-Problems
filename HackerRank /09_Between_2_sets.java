import java.util.*;

public class Solution {
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Step 1: Initialize variables
        int fact = b.get(0); // Smallest element from list 'b'
        int maxA = a.get(a.size() - 1); // Largest element from list 'a'
        List<Integer> factNumsA = new ArrayList(); // List to hold numbers divisible by all elements in 'a'
        List<Integer> factNums = new ArrayList(); // List to hold valid factors for both 'a' and 'b'
        
        // Step 2: Find numbers divisible by all elements of 'a'
        while (fact >= maxA) {
            boolean valid = true;
            // Check if 'fact' is divisible by all elements in 'a'
            for (int i = 0; i < a.size(); i++) {
                if (fact % a.get(i) != 0) {
                    valid = false;
                    break; // Exit loop if not divisible
                }
            }
            // Add 'fact' to the list if divisible by all elements in 'a'
            if (valid) {
                factNumsA.add(fact);
            }
            fact--; // Decrease 'fact' to check smaller numbers
        }
        
        // Step 3: Check which numbers from factNumsA divide all elements in 'b'
        for (int i = 0; i < factNumsA.size(); i++) {
            int factor = factNumsA.get(i);
            boolean valid = true;
            // Check if each number in 'b' is divisible by 'factor'
            for (int j = 0; j < b.size(); j++) {
                if (b.get(j) % factor != 0) {
                    valid = false;
                    break; // Exit loop if not divisible
                }
            }
            // Add the valid factor to factNums
            if (valid) {
                factNums.add(factor);
            }
        }
        
        // Step 4: Return the count of valid numbers
        return factNums.size();
    }
}
