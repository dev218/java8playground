package minh.test.stream;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CalculateSum {

    public static void main(String[] args) {
        List<Point> points = createPoints();

        calculateSumOfXByStream(points);

        filterNegativeX(points);

        joinString(points);
    }

    private static void joinString(List<Point> points) {
        System.out.println(
                points.stream()
                        .filter(p -> p.getX() > 0)
                        .mapToInt(p -> p.x)
                        .mapToObj(Integer::toString)
                        .collect(Collectors.joining(", "))
        );
    }

    private static void filterNegativeX(List<Point> points) {
        points.stream()
                .filter(p -> p.x > 0)
                .distinct()
                .forEach(System.out::println);
    }

    private static void calculateSumOfXByStream(List<Point> points) {
        points.stream()
                .mapToInt(p -> p.x)
                .peek(value -> System.out.print(value + " "))
                .reduce(Integer::sum)
                .ifPresent(s -> System.out.println("\nsum = " + s));
    }

    private static List<Point> createPoints() {
        java.util.List<Point> result = new ArrayList<>();

        result.add(new Point(-4, -8));
        result.add(new Point(-2, 9));
        result.add(new Point(-1, -8));
        result.add(new Point(0, -7));
        result.add(new Point(1, 1));
        result.add(new Point(2, 3));
        result.add(new Point(2, 3));
        result.add(new Point(2, -2));
        result.add(new Point(4, -1));

        return result;
    }
}
