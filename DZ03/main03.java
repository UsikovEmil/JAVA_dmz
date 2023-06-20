package DZ03;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class main03 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            numbers.add(rand.nextInt(100));
        }
        numbers.removeIf(n -> n % 2 == 0); //удаляем из списка чётные числа
        int min = numbers.stream().min(Integer::compare).get(); // находим минимальное значение
        int max = numbers.stream().max(Integer::compare).get(); // находим максимальное значение
        double avg = numbers.stream().mapToInt(Integer::intValue).average().getAsDouble(); // находим среднее значение
        System.out.println("Минимальное значение: " + min);
        System.out.println("Максимальное значение: " + max);
        System.out.println("Среднее значение: " + avg);
    }
}