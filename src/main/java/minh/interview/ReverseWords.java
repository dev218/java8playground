package minh.interview;

/**
 * Your team is scrambling to decipher a recent message, worried it's a plot to break into a major European National
 * Cake Vault. The message has been mostly deciphered, but all the words are backwards! Your colleagues have handed
 * off the last step to you.
 * <p>
 * Write a function reverseWords() that takes a string message and reverses the order of the words in-place. ↴
 */
public class ReverseWords {
    public static void main(String[] args) {
        String input = "find you will pain only go you recordings security the into if";
        //input = "01 23 456 789";

        System.out.println(reverseWords(input));
    }

    private static String reverseWords(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }

        char[] str = input.toCharArray();

        // reverse the whole string
        reverseString(str, 0, str.length - 1);

        // now reverse each word
        int from = 0;
        for (int i = 0; i <= str.length; i++) {
            if (i == str.length  || str[i] == ' ') {
                reverseString(str, from, i - 1);
                from = i + 1;
            }
        }
        return String.valueOf(str);
    }

    private static void reverseString(char[] str, int from, int to) {
        while (from < to) {
            char tmp = str[from];
            str[from] = str[to];
            str[to] = tmp;

            // walk toward each other
            from++;
            to--;
        }
        return;
    }

}
