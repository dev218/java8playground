package minh.playground.functional;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

public class ConverterUser {

    public static void main(String[] args) {
        Converter<Integer, String> converter = (from -> Integer.valueOf(from));

        converter.convert("123");
        converter.aDefaultMethod();
        converter.anotherDefaultMethod();

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

        Optional<String> optional = Optional.of("bam");

        optional.isPresent();           // true
        optional.get();                 // "bam"
        optional.orElse("fallback");    // "bam"

        optional.ifPresent((s) -> System.out.println(s.charAt(0)));
    }

    public void tata () {
        int num = 1;
        Converter<Integer, Integer> c2 = (from -> from + num);
        System.out.println(c2.convert(2));

        //num = 3;
    }
}
