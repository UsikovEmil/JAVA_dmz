package DZ05;
import java.util.*;

public class main05 {

    public static void main(String[] args) {
        Map<String, Set<String>> phoneBook = new HashMap<>();
        phoneBook.put("Сидоров Иван Петрович", new HashSet<>(Arrays.asList("+7 (999) 482-45-39", "+7 (888) 546-66-87")));
        phoneBook.put("Пушкин Александр Леонидович", new HashSet<>(Arrays.asList("+7 (777) 123-88-45")));
        phoneBook.put("Алферова Вера Сергеевна", new HashSet<>(Arrays.asList("+7 (666) 987-56-12", "+7 (555) 447-22-04", "+7 (444) 357-48-88")));

        List<Map.Entry<String, Set<String>>> entries = new ArrayList<>(phoneBook.entrySet());
        entries.sort((a, b) -> b.getValue().size() - a.getValue().size());

        for (Map.Entry<String, Set<String>> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
