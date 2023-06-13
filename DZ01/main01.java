package DZ01;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class main01 {
    public static void main(String[] args) {

        // 1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
        Random random = new Random();
        int i = random.nextInt(2000);
    
        // 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
        int n = Integer.SIZE - Integer.numberOfLeadingZeros(i);
    
        // 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
        List<Integer> m1 = new ArrayList<>();
        for (int j = i; j <= Short.MAX_VALUE; j++) {
          if (j % n == 0) {
            m1.add(j);
          }
        }
    
        // 4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
        List<Integer> m2 = new ArrayList<>();
        for (int j = Short.MIN_VALUE; j <= i; j++) {
          if (j % n != 0) {
            m2.add(j);
          }
        }
    
        System.out.println("i = " + i);
        System.out.println("n = " + n);
        System.out.println("m1 = " + m1);
        System.out.println("m2 = " + m2);
      }
    
    
}
