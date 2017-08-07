package minh.test.builtinFunctionalInf;

public class Function {

    public static void main(String[] args) {
        Function test = new Function();
        test.test();
    }

    private void test() {
        java.util.function.Function<String, Integer> toInt = s -> Integer.valueOf(s);

        java.util.function.Function<Outer, Nested> getInner = o -> o.getNested();
        java.util.function.Function<Outer, Nested> getInner2 = Outer::getNested;
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
