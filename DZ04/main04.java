package DZ04;
import java.util.*;

class User {
    String fName;
    String lName;
    String mName;
    int age;
    String pol;

    public User(String fName, String lName, String mName, int age, String pol) {
        this.fName = fName;
        this.lName = lName;
        this.mName = mName;
        this.age = age;
        this.pol = pol;
    }

    public String toString() {
        return lName + " " + fName.charAt(0) + "." + mName.charAt(0) + ". " + age + " " + pol;
    }
}

public class main04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<User> users = new ArrayList<>();

        while (true) {
            System.out.println("Введите информацию о пользователе (или 'выход' для выхода из программы):");
            String input = scanner.nextLine();
            if (input.equals("выход")) {
                break;
            }
            String[] parts = input.split(" ");
            String fName = parts[0];
            String lName = parts[1];
            String mName = parts[2];
            int age = Integer.parseInt(parts[3]);
            String pol = parts[4];
            users.add(new User(fName, lName, mName, age, pol));
        }

        // Создание массива индексов
        Integer[] indices = new Integer[users.size()];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }

        // Сортировка массива индексов на основе значений возраста в массиве пользователей
        Arrays.sort(indices, Comparator.comparingInt(i -> users.get(i).age));

        System.out.println("Список пользователей (отсортированный по возрасту):");
        for (int index : indices) {
            System.out.println(users.get(index));
        }
    }
}