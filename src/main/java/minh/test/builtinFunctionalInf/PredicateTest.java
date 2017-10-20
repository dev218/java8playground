package minh.test.builtinFunctionalInf;

import java.util.function.Predicate;

/**
 * Predicate take an object as input, perform a assertion and return a Boolean value
 */
public class PredicateTest {

    public static void main(String[] args) {
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> validLength = s -> s.length() > 8;
        Predicate<String> validPassword = isEmpty.negate().and(validLength);

        System.out.println(validLength.test("sljd"));
        System.out.println(validPassword.test("sljd"));
    }
}
