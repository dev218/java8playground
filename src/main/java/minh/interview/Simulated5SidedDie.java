package minh.interview;

/**
 * You have a method rand7() that generates a random integer from 1 to 7. Use it to
 * write a method rand5() that generates a random integer from 1 to 5.
 * rand7() returns each integer with equal probability. rand5() must also return each
 * integer with equal probability.
 */

public class Simulated5SidedDie {
    public static int roll7(){
        return (int) (Math.random() * 7) + 1;
    }

    public static int roll5from7() {
        int val = roll7();
        while (val > 5) {
            val = roll7();
        }

        return val;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(roll5from7());
        }
    }
}
