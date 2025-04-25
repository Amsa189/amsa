package practiceCode;


import java.util.*;

public class LongestSubstringSlidingWindow {

    public static void main(String[] args) {
        String s = "amsaavveeni";
        System.out.println("Longest non-repeating substring: " + findLongestUniqueSubstring(s));
    }

    public static String findLongestUniqueSubstring(String s) {
        int maxLength = 0;
        String longestSubstring = "";

        // Use a sliding window approach
        Set<Character> seen = new HashSet<>();
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            System.out.println(c);
            // If character is already seen, remove characters from the start
            while (seen.contains(c)) {
                System.out.println(start);
                System.out.println("char at::"+s.charAt(start));
                seen.remove(s.charAt(start));
                start++;
            }

            seen.add(c);

            // Update the longest substring if needed
            if (end - start + 1 > maxLength) {
                maxLength = end - start + 1;
                longestSubstring = s.substring(start, end + 1);
            }
        }

        return longestSubstring;
    }
}
