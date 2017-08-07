package minh.test.optional;

import java.util.Optional;

public class App {

    /**
     * The isPresent() method returns true if this instance of Optional has non-null value and false otherwise.
     * The orElseGet() method provides the fallback mechanism in case Optional has null value by accepting the
     * function to generate the default one. The map() method transforms the current Optional’s value and
     * returns the new Optional instance. The orElse() method is similar to orElseGet() but instead of function
     * it accepts the default value.
     */
    public static void main(String[] args) {
        Optional<String> fullName = Optional.ofNullable(null);
        fullName.ifPresent(s -> System.out.println(s));
        System.out.println("Full Name is set? " + fullName.isPresent());
        System.out.println("Full Name: " + fullName.orElseGet(() -> "[none]"));
        System.out.println(fullName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));

        Optional<String> firstName = Optional.of("Tom");
        firstName.ifPresent(s -> {
            System.out.println(s);
        });
        System.out.println("First Name is set? " + firstName.isPresent());
        System.out.println("First Name: " + firstName.orElseGet(() -> "[none]"));
        System.out.println(firstName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));
        System.out.println();
    }
}
