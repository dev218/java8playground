package minh.playground.functional;

@FunctionalInterface
public interface Converter <T,F> {
    T convert(F from);

    default void aDefaultMethod() {
        System.out.println("default method 1");
    }

    default void anotherDefaultMethod() {
        System.out.println("default method 2");
    }
}
