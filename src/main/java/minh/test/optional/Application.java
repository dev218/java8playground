package minh.test.optional;

import java.util.Optional;

public class Application {
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
        //String foo = null;
        String foo = "tata";

        String getFoo() {
            return foo;
        }
    }

    public void test() {

        // OLD WAY OF CHECKING NULL
        Outer outer = new Outer();
        String str = null;
        if (outer != null &&
                outer.getNested() != null
                && outer.getNested().getInner() != null
                && outer.getNested().getInner().getFoo() != null) {
            str = outer.getNested().getInner().getFoo();
        } else {
            str = "valueNotFound";
        }

        // NEW WAY WITH OPTIONAL
        str = Optional.of(new Outer())
                .map(Outer::getNested) //.map(o -> o.getNested())
                .map(Nested::getInner)
                .map(Inner::getFoo)
                .orElse("valueNotFound");
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.test();
    }
}
