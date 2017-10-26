package minh.interview;

import java.util.*;

/**
 * "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing."
 * <p>
 * Write a function that, given a sentence like the one above, along with the position of an opening parenthesis, finds the corresponding closing parenthesis.
 * <p>
 * Example: if the example string above is input with the number 10 (position of the first parenthesis), the output should be 79 (position of the last parenthesis).
 */

public class MatchingParenthesis {

    public static void main(String[] args) {
        String input = "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.";

        int position = 10;
        System.out.println("Matched closing parenthesis: " + match(input, position));
    }

    private static int match(String input, int position) {
        Stack opening = new Stack();

        for (int i = position; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(')
                opening.push(i);
            else if (c == ')') {
                // remove last opening
                opening.pop();

                // if opening is empty, this is our matching bracket
                if (opening.isEmpty())
                    return i;
            }
        }

        return -1;
    }

    public static int SOLUTIONgetClosingParen(String sentence, int openingParenIndex) {
        int openNestedParens = 0;

        for (int position = openingParenIndex + 1; position < sentence.length(); position++) {
            char c = sentence.charAt(position);

            if (c == '(') {
                openNestedParens++;
            } else if (c == ')') {
                if (openNestedParens == 0) {
                    return position;
                } else {
                    openNestedParens--;
                }
            }
        }

        throw new IllegalArgumentException("No closing parenthesis :(");
    }
}
