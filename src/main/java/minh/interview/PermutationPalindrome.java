package minh.interview;

public class PermutationPalindrome {

    public static void main(String[] args) {
        String str = "mom";

        System.out.println(hasPalindrome(str));
    }

    private static boolean hasPalindrome(String str) {
        int[] alphabet = new int[26];

        for (char c : str.toCharArray()) {
            alphabet[c - 97]++;
        }

        int count = 0;
        for (int i : alphabet) {
            if ((i % 2) > 0)
                count++;
        }

        return count < 2;
    }
}
