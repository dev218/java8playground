package minh.test.optional;

import java.util.Optional;

public class Application {
    class Outer {
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

    public void test() {
        Optional.of(new Outer())
                .map(Outer::getNested)
                .map(Nested::getInner)
                .map(Inner::getFoo)
                .ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.test();
    }
}
