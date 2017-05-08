package minh.test.java8.lambda;

import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Arrays.asList("a", "b", "d").forEach(e -> System.out.print(e));

        System.out.println();
        List<String> list = Arrays.asList("a", "c", "b", "d");
        list.sort((s1, s2) -> s1.compareTo(s2));
        list.forEach(e -> System.out.print(e));
    }
}
