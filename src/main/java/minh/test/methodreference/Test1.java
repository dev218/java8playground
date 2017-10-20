package minh.test.methodreference;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Test1 {

    public static void main(String[] args) {
        System.out.println(process("HELLO WORLD", String::toLowerCase));

        System.out.println(process2("HELLO WORLD", 1, String::substring));

        System.out.println(process("tata", String::valueOf));

        System.out.println(process("tata", String::new));

        System.out.println(process("Smith", s -> "MR ".concat(s)));
    }

    private static String process2(String s, int i, BiFunction <String, Integer, String> processor) {
        return processor.apply(s, i);
    }

    private static String process(String s, Function<String, String> processor) {
        return processor.apply(s);
    }
}
