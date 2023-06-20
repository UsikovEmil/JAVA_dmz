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

        System.out.println(numbers);
    }
}