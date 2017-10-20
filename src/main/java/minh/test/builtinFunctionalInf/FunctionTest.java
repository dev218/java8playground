package minh.test.builtinFunctionalInf;

import java.util.function.Function;

/**
 * Function take an input and produce a result
 */

public class FunctionTest {

    public static void main(String[] args) {
        Function<String, Integer> toInt = s -> Integer.valueOf(s);
        Function<String, Integer> toInt2 = Integer::valueOf;

        Function<Outer, Nested> getInner = o -> o.getNested();
        Function<Outer, Nested> getInner2 = Outer::getNested;
    }

    public class Outer {
        Nested nested = new Nested();

        Nested getNested() {
            return nested;
        }
    }

    class Nested {
        Inner inner = new Inner();

        Inner getInner() {
            return inner;
        }
    }

    class Inner {
        String foo = null;
        //String foo = "tata";

        String getFoo() {
            return foo;
        }
    }
}
