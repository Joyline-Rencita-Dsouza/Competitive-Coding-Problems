public class Solution {
    static String kangaroo(int x1, int v1, int x2, int v2) {
        // Case when the kangaroos are already at the same position
        if (x1 == x2) {
            return "YES";
        } 
        
        // Check if kangaroos can never meet (one is ahead and has equal or faster velocity)
        else if ((x1 > x2 && v1 >= v2) || (x1 < x2 && v1 <= v2)) {
            return "NO";
        } 
        
        // Simulate the jumps
        else {
            // If the first kangaroo is ahead, we simulate until they meet or go past each other
            if (x1 > x2) {
                while (x1 > x2) {
                    x1 += v1;  // Increment position of the first kangaroo
                    x2 += v2;  // Increment position of the second kangaroo
                    if (x1 == x2) {  // If they meet at the same position
                        return "YES";
                    }
                }
            } 
            // If the second kangaroo is ahead, we simulate until they meet or go past each other
            else {
                while (x1 < x2) {
                    x1 += v1;  // Increment position of the first kangaroo
                    x2 += v2;  // Increment position of the second kangaroo
                    if (x1 == x2) {  // If they meet at the same position
                        return "YES";
                    }
                }
            }
        }
        // If no meeting happens, return "NO"
        return "NO";
    }
}
