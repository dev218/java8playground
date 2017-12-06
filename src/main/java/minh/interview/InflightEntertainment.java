package minh.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * Users on longer flights like to start a second movie right when their first one ends, but they complain that the
 * plane usually lands before they can see the ending. So you're building a feature for choosing two movies whose total
 * runtimes will equal the exact flight length.

 * Write a function that takes an integer flight_length (in minutes) and a list of integers movie_lengths (in minutes)
 * and returns a boolean indicating whether there are two numbers in movie_lengths whose sum equals flight_length.

 * When building your function:

 * - Assume your users will watch exactly two movies
 * - Don't make your users watch the same movie twice
 * - Optimize for runtime over memory
 */

public class InflightEntertainment {

    public static void main(String[] args) {

    }

    boolean isMatched(int flightLength, int[] movieLengths) {
        Set diffs = new HashSet();

        for (int movieLength : movieLengths) {
            int diff = flightLength - movieLength;

            // if the difference equals to a movie in the set, then it's a match
            if (diffs.contains(diff)) {
                return true;
            } else {
                diffs.add(movieLength);
            }
        }
        return false;
    }
}
