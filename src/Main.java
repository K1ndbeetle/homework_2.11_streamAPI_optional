import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        System.out.println("Задание №1");
        minMax();

        System.out.println();

        System.out.println("Задание №2");
        numberOfEvenNumbers();
    }

    public static void minMax() {
        Stream<Integer> stream = new ArrayList<>
                (Arrays.asList(22, 34, 23, 2, 12, 794, 32, 23, 42)).stream();

        findMinMax(stream, Integer::compareTo, (x, y) ->
            {
                System.out.println("Минимальный элемент - " + x);
                System.out.println("Максимальный элемент - " + y);
            }
        );

        stream.close();
    }

    public static void numberOfEvenNumbers() {
        List<Integer> numbers = Arrays.asList(25, 52, 32, 76, 45, 0, 3, 98, 11, 76, 33);
        int count = (int) numbers.stream()
                .filter(i -> i % 2 == 0)
                .count();
        System.out.println("Количество чётных чисел - " + count);
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> list = stream.collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            list.sort(order);
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }
    }
}