package minh.test.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapLimitDistinctSort {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 5, 4, 3, 3, 4, 2, 1);
        list.stream().limit(3).map(i -> i*i).distinct().sorted((i, j) -> j - i).collect(Collectors.toList()).forEach(System.out::println);
    }
}
