package DZ02;
import java.util.*;
public class main02 { 


    public static void main(String[] args) {
        Map<String, String> filt = new HashMap<>();
        filt.put("name", "Ivanov");
        filt.put("country", "Russia");
        filt.put("city", "Moscow");
        filt.put("age", null);

        StringBuilder where = new StringBuilder();
        for (Map.Entry<String, String> entry : filt.entrySet()) {
            if (entry.getValue() != null) {
                if (where.length() > 0) {
                    where.append(" AND ");
                }
                where.append(entry.getKey()).append(" = '").append(entry.getValue()).append("'");
            }
        }

        String sql = "SELECT * FROM students WHERE " + where.toString();
        System.out.println(sql);
    }
}
